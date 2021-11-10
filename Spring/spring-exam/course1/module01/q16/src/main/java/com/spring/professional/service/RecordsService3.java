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

import java.util.Optional;

@Service
public class RecordsService3 {

    @Autowired
    public RecordsService3(DbRecordsReader dbRecordsReader, DbRecordsBackup dbRecordsBackup, DbRecordsProcessor dbRecordsProcessor, DbRecordsWriter dbRecordsWriter, Optional<RecordsHash> recordsHash, @Nullable RecordsUtil recordsUtil, @Autowired(required = false) RecordsValidator recordsValidator) {
        System.out.println(
                "RecordsService3{" +
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

    //@Autowired
    public RecordsService3(DbRecordsReader dbRecordsReader, DbRecordsBackup dbRecordsBackup, DbRecordsProcessor dbRecordsProcessor, DbRecordsWriter dbRecordsWriter, Optional<RecordsHash> recordsHash, @Nullable RecordsUtil recordsUtil) {
        System.out.println(
                "RecordsService3{" +
                        "dbRecordsReader=" + dbRecordsReader +
                        ", dbRecordsBackup=" + dbRecordsBackup +
                        ", dbRecordsProcessor=" + dbRecordsProcessor +
                        ", dbRecordsWriter=" + dbRecordsWriter +
                        ", recordsHash=" + recordsHash +
                        ", recordsUtil=" + recordsUtil +
                        '}'
        );
    }
}
