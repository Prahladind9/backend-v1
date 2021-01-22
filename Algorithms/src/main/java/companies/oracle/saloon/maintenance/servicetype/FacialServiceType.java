package companies.oracle.saloon.maintenance.servicetype;

public class FacialServiceType extends ServiceType {

    String getServiceName() {
        return ServiceTypes.FACIAL.name();
    }


    Integer getTimeForService(){
        return 35;
    }
}
