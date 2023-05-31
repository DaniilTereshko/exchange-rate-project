package by.it_academy.jd2.dao.api;

import java.util.List;

public interface ICRUDDAO<T> {
    List<T> get();
    List<T> save(List<T> dtos);


}
