package com.spring.professional.reader;

import com.spring.professional.ds.Record;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
@Order(1)
public class WebServiceRecordsReader implements RecordsReader{
    @Override
    public Collection<Record> readRecords() {
        return Collections.EMPTY_LIST;
    }
}
