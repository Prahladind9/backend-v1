package com.spring.professional.service;

import com.spring.professional.backup.DbRecordsBackup;
import com.spring.professional.bls.DbRecordsProcessor;
import com.spring.professional.non.beans.RecordsHash;
import com.spring.professional.non.beans.RecordsUtil;
import com.spring.professional.non.beans.RecordsValidator;
import com.spring.professional.reader.DbRecordsReader;
import com.spring.professional.writer.DbRecordsWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class RecordsService1 {
    @Autowired
    public DbRecordsReader dbRecordsReader;
    @Autowired
    public DbRecordsBackup dbRecordsBackup;
    @Autowired
    public DbRecordsProcessor dbRecordsProcessor;
    @Autowired
    DbRecordsWriter dbRecordsWriter;
    @Autowired
    private Optional<RecordsHash> recordsHash;
    @Autowired
    @Nullable
    private RecordsUtil recordsUtil;
    @Autowired(required = false)
    private RecordsValidator recordsValidator;

    public RecordsService1() {
        System.out.println(
                "RecordsService1{" +
                        "dbRecordsReader=" + dbRecordsReader +
                        ", dbRecordsBackup=" + dbRecordsBackup +
                        ", dbRecordsProcessor=" + dbRecordsProcessor +
                        ", dbRecordsWriter=" + dbRecordsWriter +
                        ", recordsHash=" + recordsHash +
                        ", recordsUtil=" + recordsUtil +
                        ", recordsValidator=" + recordsValidator +
                        '}'
        );
    }

    @PostConstruct
    public void init(){
        System.out.println("RecordsService1{" +
                "dbRecordsReader=" + dbRecordsReader +
                ", dbRecordsBackup=" + dbRecordsBackup +
                ", dbRecordsProcessor=" + dbRecordsProcessor +
                ", dbRecordsWriter=" + dbRecordsWriter +
                ", recordsHash=" + recordsHash +
                ", recordsUtil=" + recordsUtil +
                ", recordsValidator=" + recordsValidator +
                '}');
    }
}
