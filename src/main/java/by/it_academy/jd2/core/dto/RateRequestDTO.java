package by.it_academy.jd2.core.dto;

import java.util.Date;

public class RateRequestDTO {
    private Integer id;
    private Date endDate;
    private Date startDate;

    public RateRequestDTO() {
    }

    public RateRequestDTO(Integer id, Date endDate, Date startDate) {
        this.id = id;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
