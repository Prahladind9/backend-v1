package com.spring.professional.reader;

import com.spring.professional.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component("db-records-reader")
public class DbRecordsReader implements RecordsReader{
    @Override
    public Collection<Record> readRecords() {
        return Collections.EMPTY_LIST;
    }
}
