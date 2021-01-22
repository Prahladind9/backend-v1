package companies.oracle.saloon.maintenance.servicetype;

public class BeardServiceType extends ServiceType {

    String getServiceName() {
        return ServiceTypes.BEARD.name();
    }


    Integer getTimeForService(){
        return 10;
    }
}
