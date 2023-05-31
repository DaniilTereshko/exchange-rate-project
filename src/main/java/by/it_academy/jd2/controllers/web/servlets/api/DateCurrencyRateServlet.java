package by.it_academy.jd2.controllers.web.servlets.api;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestDTO;
import by.it_academy.jd2.services.api.IRateService;
import by.it_academy.jd2.services.factory.RateServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DateCurrencyRateServlet", urlPatterns = "/api/date-currency-rate")
public class DateCurrencyRateServlet extends HttpServlet {
    private final IRateService rateService;

    public DateCurrencyRateServlet() {
        this.rateService = RateServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currencyType = req.getParameter("currencyType");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        if(currencyType != null && startDate != null && endDate != null){
            RateRequestDTO rateRequestDTO = new RateRequestDTO(currencyType, startDate, endDate);
            List<RateDTO> rates = rateService.get(rateRequestDTO);

        }
        //ошибка
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
