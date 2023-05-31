package by.it_academy.jd2.dao.API;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;

import java.util.List;

public interface IRateDAO extends ICRUDDAO<RateDTO>{
    List<RateDTO> get(RateRequestDTO rateRequestDTO);
    List<RateDTO> get(Integer currencyType);
}
