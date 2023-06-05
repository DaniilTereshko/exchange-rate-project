package by.it_academy.jd2.services.factory;

import by.it_academy.jd2.dao.db.factory.CurrencyJDBCDAOFactory;
import by.it_academy.jd2.dao.db.factory.RateJDBCDAOFactory;
import by.it_academy.jd2.services.api.IRateService;
import by.it_academy.jd2.services.api.IStatisticRateService;
import by.it_academy.jd2.services.impl.RateService;
import by.it_academy.jd2.services.impl.StatisticRateService;

public class StatisticRateServiceFactory {
    private static volatile IStatisticRateService statisticRateService = null;

    private StatisticRateServiceFactory() {
    }

    public static IStatisticRateService getInstance(){
        if(statisticRateService == null){
            synchronized (StatisticRateServiceFactory.class){
                if(statisticRateService == null){
                    statisticRateService = new StatisticRateService(RateJDBCDAOFactory.getInstance(), CurrencyJDBCDAOFactory.getInstance(), ApiNBRBRequestServiceFactory.getInstance());
                }
            }
        }
        return statisticRateService;
    }
}
