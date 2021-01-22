package companies.oracle.saloon.maintenance.servicetype;

public abstract class ServiceType {

    /**
     * Service Name
     * @return Service Name Selected
     */
    String getServiceName() {
        return null;
    }

    /**
     * getTimeForService
     * @return no of minutes for the service selected
     */
    Integer getTimeForService(){
        return null;
    }
}
