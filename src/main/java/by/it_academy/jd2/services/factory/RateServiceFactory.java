package by.it_academy.jd2.services.factory;

import by.it_academy.jd2.dao.db.factory.CurrencyJDBCDAOFactory;
import by.it_academy.jd2.dao.db.factory.RateJDBCDAOFactory;
import by.it_academy.jd2.services.api.IRateService;
import by.it_academy.jd2.services.impl.RateService;

public class RateServiceFactory {
    private static volatile IRateService rateService = null;

    private RateServiceFactory() {
    }

    public static IRateService getInstance(){
        if(rateService == null){
            synchronized (RateServiceFactory.class){
                if(rateService == null){
                    rateService = new RateService(RateJDBCDAOFactory.getInstance(), CurrencyJDBCDAOFactory.getInstance());
                }
            }
        }
        return rateService;
    }
}
