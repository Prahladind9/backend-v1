package companies.oracle.saloon.maintenance.servicetype;

public class CurlingServiceType extends ServiceType {

    String getServiceName() {
        return ServiceTypes.CURLING.name();
    }


    Integer getTimeForService(){
        return 20;
    }
}