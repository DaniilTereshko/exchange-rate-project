package by.it_academy.jd2.core.dto;

public class RateRequestDTO {
    private String currencyType;
    private String endDate;
    private String startDate;

    public RateRequestDTO() {
    }

    public RateRequestDTO(String currencyType, String endDate, String startDate) {
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
