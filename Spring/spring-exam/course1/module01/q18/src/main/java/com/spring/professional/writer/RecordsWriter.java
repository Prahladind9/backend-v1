package com.spring.professional.writer;

import com.spring.professional.ds.Record;

import java.util.Collection;

public interface RecordsWriter {
    void writeRecords(Collection<Record> records);
}
