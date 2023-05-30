package by.it_academy.jd2.services.api;

import by.it_academy.jd2.core.dto.RateDTO;

import java.util.List;

public interface IRateService {
    List<RateDTO> get(String currencyType, String startDate, String endDate);
    List<RateDTO> get(String currencyType);
}
