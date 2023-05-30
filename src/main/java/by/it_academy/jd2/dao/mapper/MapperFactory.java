package by.it_academy.jd2.dao.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperFactory {
    private static volatile ObjectMapper instance;

    private MapperFactory() {
    }

    public static ObjectMapper getInstance() {
        if (instance == null) {
            synchronized (MapperFactory.class) {
                if (instance == null) {
                    instance = new ObjectMapper();
                    instance.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
                }
            }
        }
        return instance;
    }

}
