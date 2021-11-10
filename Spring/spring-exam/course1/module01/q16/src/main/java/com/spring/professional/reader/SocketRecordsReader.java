package com.spring.professional.reader;

import com.spring.professional.ds.Record;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.Collection;
import java.util.Collections;

@Component
@Priority(2)
public class SocketRecordsReader implements RecordsReader{
    @Override
    public Collection<Record> readRecords() {
        return Collections.EMPTY_LIST;
    }
}
