package by.it_academy.jd2;

import by.it_academy.jd2.core.dto.CurrencyDTO;
//import by.it_academy.jd2.dao.db.ds.HikariCPDataSource;
import by.it_academy.jd2.dao.mapper.MapperFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {


        ObjectMapper mapper = MapperFactory.getInstance();

        File file = new File("src/test/resources/currency.json");
        File fileTList = new File("src/test/resources/currency_list.json");

        CurrencyDTO dto = mapper.readValue(file, CurrencyDTO.class);

        List<CurrencyDTO> dtos = mapper.readValue(fileTList, new TypeReference<List<CurrencyDTO>>() {
        });

/*
        try (Connection connection = HikariCPDataSource.getConnection();
        ) {
            PreparedStatement statement;
            for (CurrencyDTO curryncy : dtos) {
                statement = connection.prepareStatement("INSERT INTO app.currency(\n" +
                        "\tcur_id, \"parentID\", code, abbreviation, name_currency, name_bel, name_eng, \"quotName\", \"quotName_Bel\", \"quotName_Eng\", \"nameMulti\", \"name_BelMulti\", \"name_EngMulti\", scale, periodicity, \"dateStart\", \"dateEnd\")\n" +
                        "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                statement.setInt(1, curryncy.getID());
                statement.setInt(2, curryncy.getParentID());
                statement.setString(3, curryncy.getCode());
                statement.setString(4, curryncy.getAbbreviation());
                statement.setString(5, curryncy.getName());
                statement.setString(6, curryncy.getNameBel());
                statement.setString(7, curryncy.getNameEng());
                statement.setString(8, curryncy.getQuotName());
                statement.setString(9, curryncy.getQuotNameBel());
                statement.setString(10, curryncy.getQuotNameEng());
                statement.setString(11, curryncy.getNameMulti());
                statement.setString(12, curryncy.getNameBelMulti());
                statement.setString(13, curryncy.getNameEngMulti());
                statement.setInt(14, curryncy.getScale());
                statement.setInt(15, curryncy.getPeriodicity());
                statement.setDate(16, curryncy.getDateStart());
                statement.setDate(17, curryncy.getDateEnd());
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Didn't manage to establish connection to DB", e);
        }
*/

/*
        for (CurrencyDTO cur : dtos) {
            System.out.println(cur);
        }

*/
        //List<CurrencyDTO> dtos = mapper.readValue(fileTList, mapper.getTypeFactory().constructCollectionType(List.class, CurrencyDTO.class));


    }
}