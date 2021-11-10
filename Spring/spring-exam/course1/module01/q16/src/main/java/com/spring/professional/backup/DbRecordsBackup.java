package com.spring.professional.backup;

import com.spring.professional.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DbRecordsBackup implements RecordsBackup{
    @Override
    public void backupRecordsBackup(Collection<Record> records) {

    }
}
