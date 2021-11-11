package com.spring.professional.writer;

import com.spring.professional.ds.Record;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Qualifier("db-writer")
public class DbRecordsWriter implements RecordsWriter{
    @Override
    public void writeRecords(Collection<Record> records) {

    }
}
