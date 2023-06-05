package by.it_academy.jd2.services.api;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestCreatorDTO;

import java.util.List;

public interface IRateService {
    List<RateDTO> get(RateRequestCreatorDTO rateRequestCreatorDTO);
    List<RateDTO> get(String currencyType);
}
