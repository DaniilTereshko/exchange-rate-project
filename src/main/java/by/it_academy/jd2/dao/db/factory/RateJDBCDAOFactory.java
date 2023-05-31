package by.it_academy.jd2.dao.db.factory;

import by.it_academy.jd2.dao.API.IRateDAO;
import by.it_academy.jd2.dao.db.RateJDBCDAO;

public class RateJDBCDAOFactory {
    private static volatile IRateDAO rateDAO = null;

    private RateJDBCDAOFactory() {
    }

    public static IRateDAO getInstance(){
        if(rateDAO == null){
            synchronized (RateJDBCDAOFactory.class){
                if(rateDAO == null){
                    rateDAO = new RateJDBCDAO();
                }
            }
        }
        return rateDAO;
    }
}
