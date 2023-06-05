package by.it_academy.jd2.controllers.web.servlets.api;

import by.it_academy.jd2.core.dto.RateDTO;
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

@WebServlet(name = "TypeCurrencyRateServlet", urlPatterns = "/api/type-currency-rate")
public class TypeCurrencyRateServlet extends HttpServlet {
    private IRateService rateService;
    public TypeCurrencyRateServlet() {
        this.rateService = RateServiceFactory.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8;");
        PrintWriter writer = resp.getWriter();
        String currencyType = req.getParameter("currencyType");
        List<RateDTO> rates = null;
        if(currencyType != null){
            rates = rateService.get(currencyType);
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
