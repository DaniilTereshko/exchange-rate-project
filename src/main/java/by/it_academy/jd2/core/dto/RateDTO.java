package by.it_academy.jd2.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.sql.Date;

public class RateDTO {
    @JsonSetter("Cur_ID")
    private Integer currencyID;
    @JsonSetter("Cur_OfficialRate")
    private BigDecimal currencyCost;
    @JsonSetter("Date")
    private Date dateExchangeRate;
    @JsonIgnore
    boolean isWeekend;

    public RateDTO() {
    }

    public RateDTO(Integer currencyID, BigDecimal currencyCost, Date dateExchangeRate, boolean isWeekend) {
        this.currencyID = currencyID;
        this.currencyCost = currencyCost;
        this.dateExchangeRate = dateExchangeRate;
        this.isWeekend = isWeekend;
    }

    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }

    public BigDecimal getCurrencyCost() {
        return currencyCost;
    }

    public void setCurrencyCost(BigDecimal currencyCost) {
        this.currencyCost = currencyCost;
    }

    public Date getDateExchangeRate() {
        return dateExchangeRate;
    }

    public void setDateExchangeRate(Date dateExchangeRate) {
        this.dateExchangeRate = dateExchangeRate;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
}
