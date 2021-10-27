package no.dependency.injection;

public class Runner {
    public static void main(String[] args) {
        EmployeesSalariesReportService service = new EmployeesSalariesReportService();
        service.generateReport();
    }
}
