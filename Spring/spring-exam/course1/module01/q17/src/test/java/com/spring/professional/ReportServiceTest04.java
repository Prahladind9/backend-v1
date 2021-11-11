package com.spring.professional;

import com.spring.professional.ds.Report;
import com.spring.professional.service.ReportService;
import com.spring.professional.writer.ReportWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@TestPropertySource(properties = "report.global.name="+ ReportServiceTest04.REPORT_NAME)
public class ReportServiceTest04 {
    static final String REPORT_NAME = "Mock_Report";

    @Autowired
    private ReportService reportService;
    @MockBean
    private ReportWriter reportWriter;

    @Test
    public void shouldPassReportToWrite(){
        reportService.execute();

        verify(reportWriter).write(any(Report.class), eq(REPORT_NAME));
    }
}
