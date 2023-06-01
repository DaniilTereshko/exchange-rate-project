package by.it_academy.jd2.services.factory;

import by.it_academy.jd2.services.api.IApiNBRBRequestService;
import by.it_academy.jd2.services.impl.ApiNBRBRequestService;

public class ApiNBRBRequestServiceFactory {
    private static volatile IApiNBRBRequestService apiRequestService = null;

    private ApiNBRBRequestServiceFactory() {
    }

    public static IApiNBRBRequestService getInstance(){
        if(apiRequestService == null){
            synchronized (ApiNBRBRequestServiceFactory.class){
                if(apiRequestService == null){
                    apiRequestService = new ApiNBRBRequestService();
                }
            }
        }
        return apiRequestService;
    }
}
