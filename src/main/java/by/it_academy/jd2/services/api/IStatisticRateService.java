package by.it_academy.jd2.services.api;

import by.it_academy.jd2.core.dto.RateAverageMeanDTO;

public interface IStatisticRateService {
    RateAverageMeanDTO get(String currencyType, int monthNumber);
}
