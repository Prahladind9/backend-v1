package com.spring.professional.service;

import com.spring.professional.backup.DbRecordsBackup;
import com.spring.professional.bls.DbRecordsProcessor;
import com.spring.professional.non.beans.RecordsHash;
import com.spring.professional.non.beans.RecordsUtil;
import com.spring.professional.non.beans.RecordsValidator;
import com.spring.professional.reader.DbRecordsReader;
import com.spring.professional.writer.DbRecordsWriter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordsService2 {

    public RecordsService2(DbRecordsReader dbRecordsReader, DbRecordsBackup dbRecordsBackup, DbRecordsProcessor dbRecordsProcessor, DbRecordsWriter dbRecordsWriter, Optional<RecordsHash> recordsHash, @Nullable RecordsUtil recordsUtil) {
        System.out.println(
                "RecordsService2{" +
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
