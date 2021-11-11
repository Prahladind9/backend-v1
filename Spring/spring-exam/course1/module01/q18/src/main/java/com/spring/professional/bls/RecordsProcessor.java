package com.spring.professional.bls;

import com.spring.professional.ds.Record;

import java.util.Collection;

public interface RecordsProcessor {
    Collection<Record> processRecords(Collection<Record> records);
}
