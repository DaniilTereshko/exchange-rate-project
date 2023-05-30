package by.it_academy.jd2.controllers.web.servlets.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AverageCurrencyRateServlet", urlPatterns = "/api/average-currency-rate")
public class AverageCurrencyRateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currencyType = req.getParameter("currencyType");
        String month = req.getParameter("month");
        if(currencyType != null && month != null){
            //BigDecimal = rateService.get(currencyType);
            //отдаем ответ в json
        }
        //ошибка
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
