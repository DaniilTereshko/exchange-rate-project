package by.it_academy.jd2.services.impl;

import by.it_academy.jd2.core.dto.CurrencyDTO;
import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestCreatorDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.core.exception.BadRateRequestException;
import by.it_academy.jd2.dao.api.ICurrencyDAO;
import by.it_academy.jd2.dao.api.IRateDAO;
import by.it_academy.jd2.services.api.IApiNBRBRequestService;
import by.it_academy.jd2.services.api.IRateService;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class RateService implements IRateService {
    private static final LocalDate START_VALID_DATE = LocalDate.of(2022, 12, 1);
    private static final LocalDate END_VALID_DATE = LocalDate.of(2023, 5, 31);
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
        validate(rateRequestCreatorDTO);
        RateRequestDTO rateRequest = new RateRequestDTO();
        rateRequest.setEndDate(rateRequestCreatorDTO.getEndDate());
        rateRequest.setStartDate(rateRequestCreatorDTO.getStartDate());
        CurrencyDTO currency = currencyDAO.getByType(rateRequestCreatorDTO.getCurrencyType());
        rateRequest.setId(currency.getID());

        List<RateDTO> rateDTOS;
        Duration between = Duration.between(rateRequest.getStartDate(), rateRequest.getEndDate());
        long days = between.toDays() + 1;

        rateDTOS = rateJDBCDAO.get(rateRequest);
        if(rateDTOS == null || rateDTOS.isEmpty() || rateDTOS.size() != days){
            rateDTOS = apiNBRBRequestService.getRatesByDateRange(rateRequest);
            rateJDBCDAO.save(rateDTOS);
        }
        return rateDTOS;
    }

    @Override
    public List<RateDTO> get(String currencyType) {
        CurrencyDTO currency = currencyDAO.getByType(currencyType);
        if(currency == null){
            throw new BadRateRequestException("Incorrect currency type");
        }
        else {
            return rateJDBCDAO.get(currency.getID());
        }
    }

    private void validate(RateRequestCreatorDTO rateRequestCreatorDTO) {
        if (!rateRequestCreatorDTO.getStartDate().isAfter(START_VALID_DATE.atStartOfDay()) || !rateRequestCreatorDTO.getEndDate().isBefore(END_VALID_DATE.atStartOfDay())) {
            throw new BadRateRequestException("Working range from 2022-12-01 to 2023-05-31");
        }
        CurrencyDTO currency = currencyDAO.getByType(rateRequestCreatorDTO.getCurrencyType());
        if(currency == null){
            currency = apiNBRBRequestService.getCurrencyType(rateRequestCreatorDTO.getCurrencyType());
            if(currency != null){
                currencyDAO.save(currency);
            }
            else {
                throw new BadRateRequestException("Incorrect currency type");
            }
        }
    }

}
