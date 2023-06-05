package by.it_academy.jd2.services.api;

import java.util.List;

public interface IApiRequestService<T, R>{
    List<R> getRatesByDateRange(T item);
}
