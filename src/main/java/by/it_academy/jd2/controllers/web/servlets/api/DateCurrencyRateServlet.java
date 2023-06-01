package by.it_academy.jd2.controllers.web.servlets.api;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.core.dto.RateRequestCreatorDTO;
import by.it_academy.jd2.dao.mapper.MapperFactory;
import by.it_academy.jd2.services.api.IRateService;
import by.it_academy.jd2.services.factory.RateServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DateCurrencyRateServlet", urlPatterns = "/api/date-currency-rate")
public class DateCurrencyRateServlet extends HttpServlet {
    private final IRateService rateService;

    public DateCurrencyRateServlet() {
        this.rateService = RateServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8;");
        PrintWriter writer = resp.getWriter();
        List<RateDTO> rates = null;
        String currencyType = req.getParameter("currencyType");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        if(currencyType != null && startDate != null && endDate != null){
            RateRequestCreatorDTO rateRequestCreatorDTO = new RateRequestCreatorDTO(currencyType, startDate, endDate);
            rates = rateService.get(rateRequestCreatorDTO);
        }
        else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must enter start date, end date, currency type as input.");
        }
        if(rates != null){
            writer.write(MapperFactory.getInstance().writeValueAsString(rates));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
