package by.it_academy.jd2.services.api;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;

import java.util.List;

public interface IRateService {
    List<RateDTO> get(RateRequestDTO rateRequestDTO);
    List<RateDTO> get(Integer currencyType);
}
