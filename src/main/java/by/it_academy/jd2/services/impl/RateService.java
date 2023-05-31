package by.it_academy.jd2.services.impl;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.dao.API.IRateDAO;
import by.it_academy.jd2.dao.mapper.MapperFactory;
import by.it_academy.jd2.services.api.IRateService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RateService implements IRateService {
    private final IRateDAO rateJDBCDAO;

    public RateService(IRateDAO rateDAO) {
        this.rateJDBCDAO = rateDAO;
    }

    @Override
    public List<RateDTO> get(RateRequestDTO rateRequestDTO) {
        validate(rateRequestDTO);
        List<RateDTO> rateDTOS = rateJDBCDAO.get(rateRequestDTO);
        if(rateDTOS.isEmpty()){
            List<RateDTO> rateDTOS1 = rateRequest();
        }
        return null;
    }

    @Override
    public List<RateDTO> get(Integer currencyId) {
        return rateJDBCDAO.get(currencyId);
    }

    private void validate(RateRequestDTO rateRequestDTO){

    }
    private List<RateDTO> rateRequest(){
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(""))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                String body = response.body();
                ObjectMapper instance = MapperFactory.getInstance();

                List<RateDTO> rateDTOS = instance.readValue(body, new TypeReference<List<RateDTO>>() {
                });
                return rateDTOS;
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
