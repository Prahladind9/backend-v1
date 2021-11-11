package com.spring.professional.validator;

import com.spring.professional.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.spring.professional.validator.RecordsValidatorType.RecordsValidatorMode.DB;

@Component
@RecordsValidatorType(DB)
public class DbRecordsValidator implements RecordsValidator{
    @Override
    public void validate(Collection<Record> records) {

    }
}
