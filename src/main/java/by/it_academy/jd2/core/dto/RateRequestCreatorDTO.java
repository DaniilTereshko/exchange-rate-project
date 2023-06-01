package by.it_academy.jd2.core.dto;

public class RateRequestCreatorDTO {
    private String currencyType;
    private String endDate;
    private String startDate;

    public RateRequestCreatorDTO() {
    }

    public RateRequestCreatorDTO(String currencyType, String startDate, String endDate) {
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
