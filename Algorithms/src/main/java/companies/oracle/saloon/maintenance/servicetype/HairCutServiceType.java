package companies.oracle.saloon.maintenance.servicetype;

public class HairCutServiceType extends ServiceType {

    String getServiceName() {
        return ServiceTypes.HARI_CUT.name();
    }


    Integer getTimeForService(){
        return 20;
    }
}
