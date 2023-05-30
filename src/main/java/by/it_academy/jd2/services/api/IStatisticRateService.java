package by.it_academy.jd2.services.api;

import java.math.BigDecimal;

public interface IStatisticRateService {
    BigDecimal averageByMonth(String currencyType, String month);
}
