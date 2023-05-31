package by.it_academy.jd2.dao.api;

import by.it_academy.jd2.core.dto.CurrencyDTO;

public interface ICurrencyDAO {
    Integer getIdByType(String currencyType);
}
