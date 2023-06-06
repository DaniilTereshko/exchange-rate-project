package by.it_academy.jd2.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Date;

public class CurrencyDTO {
    @JsonSetter("Cur_ID")
    private int ID;
    @JsonSetter("Cur_Abbreviation")
    private String name;



    public CurrencyDTO(int ID,
                       String name
                       ) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "curID=" + ID +
                ", curAbbreviation='" + name + '\'' +
                '}';
    }
}
