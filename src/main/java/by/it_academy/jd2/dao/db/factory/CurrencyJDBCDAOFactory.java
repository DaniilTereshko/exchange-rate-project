package by.it_academy.jd2.dao.db.factory;

import by.it_academy.jd2.dao.api.ICurrencyDAO;
import by.it_academy.jd2.dao.db.impl.CurrencyJDBCDAO;

public class CurrencyJDBCDAOFactory {
    private static volatile ICurrencyDAO currencyDAO = null;

    private CurrencyJDBCDAOFactory() {
    }

    public static ICurrencyDAO getInstance(){
        if(currencyDAO == null){
            synchronized (CurrencyJDBCDAOFactory.class){
                if(currencyDAO == null){
                    currencyDAO = new CurrencyJDBCDAO();
                }
            }
        }
        return currencyDAO;
    }
}
