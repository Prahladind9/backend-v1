package spring.dependency.injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = getSpringContext("xls-reports");

        EmployeesSalariesReportService service = context.getBean(EmployeesSalariesReportService.class);
        service.generateReport();
    }

    private static AnnotationConfigApplicationContext getSpringContext(String profile){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(profile);
        context.register(Configuration.class);
        context.refresh();
        return context;
    }
}
