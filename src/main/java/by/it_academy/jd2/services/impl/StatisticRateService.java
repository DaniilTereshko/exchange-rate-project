package by.it_academy.jd2.services.impl;

import by.it_academy.jd2.core.dto.CurrencyDTO;
import by.it_academy.jd2.core.dto.RateAverageMeanDTO;
import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.core.exception.BadRateRequestException;
import by.it_academy.jd2.dao.api.ICurrencyDAO;
import by.it_academy.jd2.dao.api.IRateDAO;
import by.it_academy.jd2.services.api.IApiNBRBRequestService;
import by.it_academy.jd2.services.api.IStatisticRateService;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class StatisticRateService implements IStatisticRateService {
    private final IRateDAO rateJDBCDAO;
    private final ICurrencyDAO currencyDAO;
    private final IApiNBRBRequestService apiNBRBRequestService;

    public StatisticRateService(IRateDAO rateDAO, ICurrencyDAO currencyDAO, IApiNBRBRequestService apiNBRBRequestService) {
        this.rateJDBCDAO = rateDAO;
        this.currencyDAO = currencyDAO;
        this.apiNBRBRequestService = apiNBRBRequestService;
    }

    public RateAverageMeanDTO get(String currencyType, int monthNumber) {
        currencyType = currencyType.toUpperCase();
        BigDecimal averageMean = null;

        // проверка на валюту
        if (!checkOnType(currencyType)) {
            throw new IllegalArgumentException("Such currency doesn't exist!");
        }

        // проверка на месяц
        if (monthNumber > 12 || monthNumber < 1) {
            throw new IllegalArgumentException("Incorrect month number");
        }

        // получаем количество дней в месяце
        Month month = Month.of(monthNumber);
        int year = 2023;
        int daysInMonth = month.length(LocalDate.of(year, month, 1).isLeapYear());

        LocalDateTime startDate = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(year, month, daysInMonth, 23, 59, 59);

        CurrencyDTO currency = currencyDAO.getByType(currencyType);
        if(currency == null){
            throw new BadRateRequestException("Invalid currency type");
        }
        // пытаемся получить данные из БД
        RateRequestDTO rateRequestDTO = new RateRequestDTO(currency.getID(), startDate, endDate);
        List<RateDTO> rateDTOList = rateJDBCDAO.get(rateRequestDTO);
        Duration between = Duration.between(startDate, endDate);
        long days = between.toDays() + 1;

        if (rateDTOList == null || rateDTOList.isEmpty() || rateDTOList.size() != days) {
            rateDTOList = apiNBRBRequestService.getRatesByDateRange(rateRequestDTO);
            // делаем запрос к API
            averageMean = geoMean(rateDTOList);
            return new RateAverageMeanDTO(currencyType, averageMean, monthNumber);
        } else {
            averageMean = geoMean(rateDTOList);
        }
        return new RateAverageMeanDTO(currencyType, averageMean, monthNumber);
    }

    private BigDecimal geoMean(List<RateDTO> rateDTOList) {
        if (rateDTOList.size() == 0) {
            return BigDecimal.valueOf(0.0);
        }
        BigDecimal gm = BigDecimal.valueOf(1.0);
        for (int i = 0; i < rateDTOList.size(); i++) {
            gm = gm.multiply(rateDTOList.get(i).getCurrencyCost());
        }
        gm = BigDecimal.valueOf(Math.pow(gm.doubleValue(), 1.0 / (double) rateDTOList.size()));
        return gm;
    }

    private boolean checkOnType(String currencyType) {
        return currencyDAO.getByType(currencyType) != null;
    }
}
