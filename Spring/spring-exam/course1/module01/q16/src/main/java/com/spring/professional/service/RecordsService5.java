package com.spring.professional.service;

import com.spring.professional.reader.RecordsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsService5 {
    @Autowired
    public void setRecordsReaders(List<RecordsReader> recordsReaders){
        System.out.println(getClass().getSimpleName() + " setRecordsReaders");
        recordsReaders.stream()
                .map(r -> "\t" + r.getClass().getSimpleName())
                .forEach(System.out::println);

    }
}
