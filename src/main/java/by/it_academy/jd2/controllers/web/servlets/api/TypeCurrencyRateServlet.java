package by.it_academy.jd2.controllers.web.servlets.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "TypeCurrencyRateServlet", urlPatterns = "/api/type-currency-rate")
public class TypeCurrencyRateServlet extends HttpServlet {
    //private final IRateService rateService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currencyType = req.getParameter("currencyType");
        if(currencyType != null){
            //List<RateDTO> = rateService.get(currencyType);
            //отдаем ответ в json
        }
        //ошибка
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
