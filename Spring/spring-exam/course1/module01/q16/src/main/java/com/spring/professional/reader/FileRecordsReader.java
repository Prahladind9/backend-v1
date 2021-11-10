package com.spring.professional.reader;

import com.spring.professional.ds.Record;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class FileRecordsReader implements RecordsReader, Ordered {
    @Override
    public Collection<Record> readRecords() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
