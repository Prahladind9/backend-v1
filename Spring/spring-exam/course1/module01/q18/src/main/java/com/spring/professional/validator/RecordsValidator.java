package com.spring.professional.validator;

import com.spring.professional.ds.Record;

import java.util.Collection;

public interface RecordsValidator {
    void validate(Collection<Record> records);
}
