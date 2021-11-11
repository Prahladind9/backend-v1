package com.spring.professional.validator;

import com.spring.professional.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.spring.professional.validator.RecordsValidatorType.RecordsValidatorMode.FILE;

@Component
@RecordsValidatorType(FILE)
public class FileRecordsValidator implements RecordsValidator{
    @Override
    public void validate(Collection<Record> records) {

    }
}
