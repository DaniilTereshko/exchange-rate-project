package by.it_academy.jd2.core.dto;

import java.time.LocalDateTime;

public class RateRequestCreatorDTO {
    private String currencyType;
    private LocalDateTime endDate;
    private LocalDateTime startDate;

    public RateRequestCreatorDTO() {
    }

    public RateRequestCreatorDTO(String currencyType, LocalDateTime startDate, LocalDateTime endDate) {
        this.currencyType = currencyType;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
