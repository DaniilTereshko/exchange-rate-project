package by.it_academy.jd2.core.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

public class RateDTO {
    private BigInteger currencyID;
    private BigDecimal currencyCost;
    Date dateExchangeRate;
    boolean isWeekend;

    public RateDTO(BigInteger currencyID, BigDecimal currencyCost, Date dateExchangeRate, boolean isWeekend) {
        this.currencyID = currencyID;
        this.currencyCost = currencyCost;
        this.dateExchangeRate = dateExchangeRate;
        this.isWeekend = isWeekend;
    }

    public BigInteger getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigInteger currencyID) {
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
