package by.it_academy.jd2.services.impl;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.dao.api.ICurrencyDAO;
import by.it_academy.jd2.dao.api.IRateDAO;
import by.it_academy.jd2.dao.mapper.MapperFactory;
import by.it_academy.jd2.services.api.IRateService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RateService implements IRateService {
    private final IRateDAO rateJDBCDAO;
    private final ICurrencyDAO currencyDAO;

    public RateService(IRateDAO rateDAO, ICurrencyDAO currencyDAO) {
        this.rateJDBCDAO = rateDAO;
        this.currencyDAO = currencyDAO;
    }

    @Override
    public List<RateDTO> get(RateRequestDTO rateRequestDTO) {
        validate(rateRequestDTO);
        List<RateDTO> rateDTOS;

        rateDTOS = rateJDBCDAO.get(rateRequestDTO);
        if(rateDTOS == null || rateDTOS.isEmpty()){
            rateDTOS = rateRequest(rateRequestDTO);
            rateJDBCDAO.save(rateDTOS);
        }
        return rateDTOS;
    }

    @Override
    public List<RateDTO> get(String currencyType) {
        return null;
    }

    private void validate(RateRequestDTO rateRequestDTO){

    }
    private List<RateDTO> rateRequest(RateRequestDTO rateRequestDTO){
        HttpClient httpClient = HttpClient.newHttpClient();
        String uri = "https://api.nbrb.by/ExRates/Rates/Dynamics/";
        Integer curId= currencyDAO.getIdByType(rateRequestDTO.getCurrencyType());

        uri += curId + "?" + "startDate=" + rateRequestDTO.getStartDate() + "&endDate=" + rateRequestDTO.getEndDate();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == HttpServletResponse.SC_OK){
                String body = response.body();
                ObjectMapper instance = MapperFactory.getInstance();
                return instance.readValue(body, new TypeReference<>(){});
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
