package by.it_academy.jd2.controllers.web.servlets.api;

import by.it_academy.jd2.core.dto.RateDTO;
import by.it_academy.jd2.services.api.IRateService;
import by.it_academy.jd2.services.factory.RateServiceFactory;
import by.it_academy.jd2.services.impl.RateService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@WebServlet(name = "TypeCurrencyRateServlet", urlPatterns = "/api/type-currency-rate")
public class TypeCurrencyRateServlet extends HttpServlet {
    private IRateService rateService;
    public TypeCurrencyRateServlet() {
        this.rateService = RateServiceFactory.getInstance();
    }

    //private final IRateService rateService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer currencyType = null;
                if (req.getParameter("currencyId")!=null){
                    currencyType = Integer.parseInt(req.getParameter("currencyId"));
                }
        if(currencyType != null){
            List<RateDTO> rateDTOList = rateService.get(currencyType);

            //отдаем ответ в json
        }
        //ошибка
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
