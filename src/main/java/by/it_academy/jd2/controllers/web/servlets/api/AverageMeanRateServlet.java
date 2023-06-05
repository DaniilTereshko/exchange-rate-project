package by.it_academy.jd2.controllers.web.servlets.api;

import by.it_academy.jd2.core.dto.RateAverageMeanDTO;
import by.it_academy.jd2.dao.mapper.MapperFactory;
import by.it_academy.jd2.services.api.IStatisticRateService;
import by.it_academy.jd2.services.factory.StatisticRateServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AverageCurrencyRateServlet", urlPatterns = "/api/average-currency-rate")
public class AverageMeanRateServlet extends HttpServlet {
    private final IStatisticRateService statisticRateService;

    public AverageMeanRateServlet() {
        this.statisticRateService = StatisticRateServiceFactory.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8;");
        PrintWriter writer = resp.getWriter();
        RateAverageMeanDTO rateAverageMeanDTO = null;
        String currencyType = req.getParameter("currencyType");
        String monthNumber = req.getParameter("month");
        if(currencyType != null && monthNumber != null){

            rateAverageMeanDTO = statisticRateService.get(currencyType, Integer.parseInt(monthNumber));

        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You must enter currency type and month number");
        }
        if(rateAverageMeanDTO != null){
            writer.write(MapperFactory.getInstance().writeValueAsString(rateAverageMeanDTO));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
