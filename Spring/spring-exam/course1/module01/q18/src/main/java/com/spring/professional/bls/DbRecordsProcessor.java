package com.spring.professional.bls;

import com.spring.professional.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class DbRecordsProcessor implements RecordsProcessor{
    @Override
    public Collection<Record> processRecords(Collection<Record> records) {
        return Collections.EMPTY_LIST;
    }
}
