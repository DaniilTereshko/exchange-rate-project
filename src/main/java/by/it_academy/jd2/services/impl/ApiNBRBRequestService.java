package by.it_academy.jd2.services.impl;

import by.it_academy.jd2.core.dto.CurrencyDTO;
import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.dao.mapper.MapperFactory;
import by.it_academy.jd2.services.api.IApiNBRBRequestService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ApiNBRBRequestService implements IApiNBRBRequestService {
    @Override
    public List<RateDTO> getRatesByDateRange(RateRequestDTO item) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        HttpClient httpClient = HttpClient.newHttpClient();
        String uri = "https://api.nbrb.by/ExRates/Rates/Dynamics/";

        uri += item.getId() + "?" + "startDate=" + dateFormat.format(item.getStartDate()) + "&endDate=" + dateFormat.format(item.getEndDate());
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
