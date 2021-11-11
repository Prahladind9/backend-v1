package com.spring.professional.service;

import com.spring.professional.bls.RecordsProcessor;
import com.spring.professional.reader.RecordsReader;
import com.spring.professional.validator.RecordsValidator;
import com.spring.professional.validator.RecordsValidatorType;
import com.spring.professional.writer.RecordsWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RecordsService {
    @Autowired
    @Qualifier("dbRecordsProcessor")
    private RecordsProcessor recordsProcessor;

    @Autowired
    @Qualifier("file-records-reader")
    private RecordsReader recordsReader;

    @Autowired
    @Qualifier("db-writer")
    private RecordsWriter recordsWriter;

    @Autowired
    @RecordsValidatorType(RecordsValidatorType.RecordsValidatorMode.FILE)
    private RecordsValidator recordsValidator;
}
