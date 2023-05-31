package by.it_academy.jd2.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Date;

public class CurrencyDTO {
    @JsonSetter("Cur_ID")
    private int ID;
    @JsonSetter("Cur_ParentID")
    private int parentID;
    @JsonSetter("Cur_Code")
    private String code;
    @JsonSetter("Cur_Abbreviation")
    private String abbreviation;
    @JsonSetter("Cur_Name")
    private String name;
    @JsonSetter("Cur_Name_Bel")
    private String nameBel;
    @JsonSetter("Cur_Name_Eng")
    private String nameEng;
    @JsonSetter("Cur_QuotName")
    private String quotName;
    @JsonSetter("Cur_QuotName_Bel")
    private String quotNameBel;
    @JsonSetter("Cur_QuotName_Eng")
    private String quotNameEng;
    @JsonSetter("Cur_NameMulti")
    private String nameMulti;
    @JsonSetter("Cur_Name_BelMulti")
    private String nameBelMulti;
    @JsonSetter("Cur_Name_EngMulti")
    private String nameEngMulti;

    @JsonSetter("Cur_Scale")
    private int scale;
    @JsonSetter("Cur_Periodicity")
    private int periodicity;

    @JsonSetter("Cur_DateStart")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateStart;
    @JsonSetter("Cur_DateEnd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateEnd;

    public CurrencyDTO(){}

    public CurrencyDTO(int ID,
                       int parentID,
                       String code,
                       String abbreviation,
                       String name,
                       String nameBel,
                       String nameEng,
                       String quotName,
                       String quotNameBel,
                       String quotNameEng,
                       String nameMulti,
                       String nameBelMulti,
                       String nameEngMulti,
                       int scale,
                       int periodicity,
                       Date dateStart,
                       Date dateEnd) {
        this.ID = ID;
        this.parentID = parentID;
        this.code = code;
        this.abbreviation = abbreviation;
        this.name = name;
        this.nameBel = nameBel;
        this.nameEng = nameEng;
        this.quotName = quotName;
        this.quotNameBel = quotNameBel;
        this.quotNameEng = quotNameEng;
        this.nameMulti = nameMulti;
        this.nameBelMulti = nameBelMulti;
        this.nameEngMulti = nameEngMulti;
        this.scale = scale;
        this.periodicity = periodicity;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameBel() {
        return nameBel;
    }

    public void setNameBel(String nameBel) {
        this.nameBel = nameBel;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getQuotName() {
        return quotName;
    }

    public void setQuotName(String quotName) {
        this.quotName = quotName;
    }

    public String getQuotNameBel() {
        return quotNameBel;
    }

    public void setQuotNameBel(String quotNameBel) {
        this.quotNameBel = quotNameBel;
    }

    public String getQuotNameEng() {
        return quotNameEng;
    }

    public void setQuotNameEng(String quotNameEng) {
        this.quotNameEng = quotNameEng;
    }

    public String getNameMulti() {
        return nameMulti;
    }

    public void setNameMulti(String nameMulti) {
        this.nameMulti = nameMulti;
    }

    public String getNameBelMulti() {
        return nameBelMulti;
    }

    public void setNameBelMulti(String nameBelMulti) {
        this.nameBelMulti = nameBelMulti;
    }

    public String getNameEngMulti() {
        return nameEngMulti;
    }

    public void setNameEngMulti(String nameEngMulti) {
        this.nameEngMulti = nameEngMulti;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(int periodicity) {
        this.periodicity = periodicity;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "curID=" + ID +
                ", curParentID=" + parentID +
                ", curCode='" + code + '\'' +
                ", curAbbreviation='" + abbreviation + '\'' +
                ", curName='" + name + '\'' +
                ", curNameBel='" + nameBel + '\'' +
                ", curNameEng='" + nameEng + '\'' +
                ", curQuotName='" + quotName + '\'' +
                ", curQuotName_Bel='" + quotNameBel + '\'' +
                ", curQuotName_Eng='" + quotNameEng + '\'' +
                ", curNameMulti='" + nameMulti + '\'' +
                ", curNameBelMulti='" + nameBelMulti + '\'' +
                ", curNameEngMulti='" + nameEngMulti + '\'' +
                ", curScale=" + scale +
                ", curPeriodicity=" + periodicity +
                ", curDateStart=" + dateStart +
                ", curDateEnd=" + dateEnd +
                '}';
    }
}
