package by.it_academy.jd2;

import by.it_academy.jd2.core.dto.CurrencyDTO;
import by.it_academy.jd2.dao.mapper.MapperFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {



        ObjectMapper mapper = MapperFactory.getInstance();

        File file = new File("src/test/resources/currency.json");
        File fileTList = new File("src/test/resources/currency_list.json");

        CurrencyDTO dto = mapper.readValue(file, CurrencyDTO.class);

        List<CurrencyDTO> dtos = mapper.readValue(fileTList, new TypeReference<List<CurrencyDTO>>(){});

        for (CurrencyDTO cur : dtos) {
            System.out.println(cur);
        }


        //List<CurrencyDTO> dtos = mapper.readValue(fileTList, mapper.getTypeFactory().constructCollectionType(List.class, CurrencyDTO.class));




    }
}