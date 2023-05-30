package by.it_academy.jd2.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.sql.Date;

public class CurrencyDTO {
    @JsonSetter("Cur_ID")
    private int curID;
    @JsonSetter("Cur_ParentID")
    private int curParentID;
    @JsonSetter("Cur_Code")
    private String curCode;
    @JsonSetter("Cur_Abbreviation")
    private String curAbbreviation;
    @JsonSetter("Cur_Name")
    private String curName;
    @JsonSetter("Cur_Name_Bel")
    private String curNameBel;
    @JsonSetter("Cur_Name_Eng")
    private String curNameEng;
    @JsonSetter("Cur_QuotName")
    private String curQuotName;
    @JsonSetter("Cur_QuotName_Bel")
    private String curQuotName_Bel;
    @JsonSetter("Cur_QuotName_Eng")
    private String curQuotName_Eng;
    @JsonSetter("Cur_NameMulti")
    private String curNameMulti;
    @JsonSetter("Cur_Name_BelMulti")
    private String curNameBelMulti;
    @JsonSetter("Cur_Name_EngMulti")
    private String curNameEngMulti;

    @JsonSetter("Cur_Scale")
    private int curScale;
    @JsonSetter("Cur_Periodicity")
    private int curPeriodicity;

    @JsonSetter("Cur_DateStart")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date curDateStart;
    @JsonSetter("Cur_DateEnd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date curDateEnd;

    public CurrencyDTO(){}
    public CurrencyDTO(int curID,
                       int curParentID,
                       String curCode,
                       String curAbbreviation,
                       String curName,
                       String curName_Bel,
                       String curName_Eng,
                       String curQuotName,
                       String curQuotName_Bel,
                       String curQuotName_Eng,
                       String curNameMulti,
                       String curNameBelMulti,
                       String curName_EngMulti,
                       int curScale,
                       int curPeriodicity,
                       Date curDateStart,
                       Date curDateEnd) {
        this.curID = curID;
        this.curParentID = curParentID;
        this.curCode = curCode;
        this.curAbbreviation = curAbbreviation;
        this.curName = curName;
        this.curNameBel = curName_Bel;
        this.curNameEng = curName_Eng;
        this.curQuotName = curQuotName;
        this.curQuotName_Bel = curQuotName_Bel;
        this.curQuotName_Eng = curQuotName_Eng;
        this.curNameMulti = curNameMulti;
        this.curNameBelMulti = curNameBelMulti;
        this.curNameEngMulti = curName_EngMulti;
        this.curScale = curScale;
        this.curPeriodicity = curPeriodicity;
        this.curDateStart = curDateStart;
        this.curDateEnd = curDateEnd;
    }


    public int getCurID() {
        return curID;
    }

    public int getCurParentID() {
        return curParentID;
    }

    public String getCurCode() {
        return curCode;
    }

    public String getCurAbbreviation() {
        return curAbbreviation;
    }

    public String getCurName() {
        return curName;
    }

    public String getCurName_Bel() {
        return curNameBel;
    }

    public String getCurName_Eng() {
        return curNameEng;
    }

    public String getCurQuotName() {
        return curQuotName;
    }

    public String getCurQuotName_Bel() {
        return curQuotName_Bel;
    }

    public String getCurQuotName_Eng() {
        return curQuotName_Eng;
    }

    public String getCurNameMulti() {
        return curNameMulti;
    }

    public String getCurNameBelMulti() {
        return curNameBelMulti;
    }

    public String getCurName_EngMulti() {
        return curNameEngMulti;
    }

    public int getCurScale() {
        return curScale;
    }

    public int getCurPeriodicity() {
        return curPeriodicity;
    }

    public Date getCurDateStart() {
        return curDateStart;
    }

    public Date getCurDateEnd() {
        return curDateEnd;
    }

    public void setCurID(int curID) {
        this.curID = curID;
    }

    public void setCurParentID(int curParentID) {
        this.curParentID = curParentID;
    }

    public void setCurCode(String curCode) {
        this.curCode = curCode;
    }

    public void setCurAbbreviation(String curAbbreviation) {
        this.curAbbreviation = curAbbreviation;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public void setCurName_Bel(String curName_Bel) {
        this.curNameBel = curName_Bel;
    }

    public void setCurName_Eng(String curName_Eng) {
        this.curNameEng = curName_Eng;
    }

    public void setCurQuotName(String curQuotName) {
        this.curQuotName = curQuotName;
    }

    public void setCurQuotName_Bel(String curQuotName_Bel) {
        this.curQuotName_Bel = curQuotName_Bel;
    }

    public void setCurQuotName_Eng(String curQuotName_Eng) {
        this.curQuotName_Eng = curQuotName_Eng;
    }

    public void setCurNameMulti(String curNameMulti) {
        this.curNameMulti = curNameMulti;
    }

    public void setCurNameBelMulti(String curNameBelMulti) {
        this.curNameBelMulti = curNameBelMulti;
    }

    public void setCurName_EngMulti(String curName_EngMulti) {
        this.curNameEngMulti = curName_EngMulti;
    }

    public void setCurScale(int curScale) {
        this.curScale = curScale;
    }

    public void setCurPeriodicity(int curPeriodicity) {
        this.curPeriodicity = curPeriodicity;
    }

    public void setCurDateStart(Date curDateStart) {
        this.curDateStart = curDateStart;
    }

    public void setCurDateEnd(Date curDateEnd) {
        this.curDateEnd = curDateEnd;
    }

    @Override
    public String toString() {
        return "CurrencyDTO{" +
                "curID=" + curID +
                ", curParentID=" + curParentID +
                ", curCode='" + curCode + '\'' +
                ", curAbbreviation='" + curAbbreviation + '\'' +
                ", curName='" + curName + '\'' +
                ", curNameBel='" + curNameBel + '\'' +
                ", curNameEng='" + curNameEng + '\'' +
                ", curQuotName='" + curQuotName + '\'' +
                ", curQuotName_Bel='" + curQuotName_Bel + '\'' +
                ", curQuotName_Eng='" + curQuotName_Eng + '\'' +
                ", curNameMulti='" + curNameMulti + '\'' +
                ", curNameBelMulti='" + curNameBelMulti + '\'' +
                ", curNameEngMulti='" + curNameEngMulti + '\'' +
                ", curScale=" + curScale +
                ", curPeriodicity=" + curPeriodicity +
                ", curDateStart=" + curDateStart +
                ", curDateEnd=" + curDateEnd +
                '}';
    }
}
