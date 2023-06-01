package by.it_academy.jd2.core.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class RateRequestDTO {
    private Integer id;
    private LocalDateTime endDate;
    private LocalDateTime startDate;

    public RateRequestDTO() {
    }

    public RateRequestDTO(Integer id, LocalDateTime endDate, LocalDateTime startDate) {
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
