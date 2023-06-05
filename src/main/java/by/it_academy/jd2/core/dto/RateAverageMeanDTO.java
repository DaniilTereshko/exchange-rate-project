package by.it_academy.jd2.core.dto;

import java.math.BigDecimal;

public class RateAverageMeanDTO {
    private String currencyType;
    private BigDecimal averageMean;
    private int monthNumber;

    public RateAverageMeanDTO(String currencyType, BigDecimal averageMean, int monthNumber) {
        this.currencyType = currencyType;
        this.averageMean = averageMean;
        this.monthNumber = monthNumber;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getAverageMean() {
        return averageMean;
    }

    public void setAverageMean(BigDecimal averageMean) {
        this.averageMean = averageMean;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }
}
