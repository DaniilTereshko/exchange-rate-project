package by.it_academy.jd2.services.impl;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestCreatorDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.core.exception.BadRateRequestException;
import by.it_academy.jd2.dao.api.ICurrencyDAO;
import by.it_academy.jd2.dao.api.IRateDAO;
import by.it_academy.jd2.services.api.IApiNBRBRequestService;
import by.it_academy.jd2.services.api.IRateService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

public class RateService implements IRateService {
    private final IRateDAO rateJDBCDAO;
    private final ICurrencyDAO currencyDAO;
    private final IApiNBRBRequestService apiNBRBRequestService;

    public RateService(IRateDAO rateDAO, ICurrencyDAO currencyDAO, IApiNBRBRequestService apiNBRBRequestService) {
        this.rateJDBCDAO = rateDAO;
        this.currencyDAO = currencyDAO;
        this.apiNBRBRequestService = apiNBRBRequestService;
    }

    @Override
    public List<RateDTO> get(RateRequestCreatorDTO rateRequestCreatorDTO) {
        RateRequestDTO rateRequest = validate(rateRequestCreatorDTO);
        List<RateDTO> rateDTOS;

        rateDTOS = rateJDBCDAO.get(rateRequest);
        if(rateDTOS == null || rateDTOS.isEmpty()){
            rateDTOS = apiNBRBRequestService.request(rateRequest);
            rateJDBCDAO.save(rateDTOS);
        }
        return rateDTOS;
    }

    @Override
    public List<RateDTO> get(Integer currencyId) {
        return rateJDBCDAO.get(currencyId);
    }

    private RateRequestDTO validate(RateRequestCreatorDTO rateRequestCreatorDTO) {
        LocalDateTime d1 = null;
        LocalDateTime d2 = null;

        RateRequestDTO rateRequestDTO = new RateRequestDTO();
        String dateFormatPattern = "yyyy-MM-dd";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormatPattern);

        String startDate = rateRequestCreatorDTO.getStartDate();
        String endDate = rateRequestCreatorDTO.getEndDate();

        try {
            d1 = LocalDate.parse("2022-12-01", dateFormatter).atStartOfDay();
            d2 = LocalDate.parse("2023-05-31", dateFormatter).atStartOfDay();

            LocalDateTime sDate = LocalDate.parse(startDate, dateFormatter).atStartOfDay();
            LocalDateTime eDate = LocalDate.parse(endDate, dateFormatter).atStartOfDay();
            rateRequestDTO.setStartDate(sDate);
            rateRequestDTO.setEndDate(eDate);
        } catch (DateTimeParseException e) {
            throw new BadRateRequestException("Incorrect date format", e);
        }

        if (!rateRequestDTO.getStartDate().isAfter(d1) || !rateRequestDTO.getEndDate().isBefore(d2)) {
            throw new BadRateRequestException("Working range from 2022-12-01 to 2023-05-31");
        }

        Integer id = currencyDAO.getIdByType(rateRequestCreatorDTO.getCurrencyType());
        rateRequestDTO.setId(id);
        return rateRequestDTO;
    }

}
