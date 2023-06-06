package by.it_academy.jd2.services.api;

import by.it_academy.jd2.core.dto.CurrencyDTO;

import java.util.List;

public interface IApiRequestService<T, R>{
    List<R> getRatesByDateRange(T item);
    CurrencyDTO getCurrencyType(String name);
}
