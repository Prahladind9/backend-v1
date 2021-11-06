package com.spring.professional.service;

import com.spring.professional.components.TaxCalculationComponent;
import com.spring.professional.dao.TaxRateDao;
import com.spring.professional.ds.Article;
import com.spring.professional.ds.TaxCalculation;
import com.spring.professional.ds.TaxInformation;
import com.spring.professional.ds.TaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxInformationService {
    @Autowired
    private TaxRateDao taxRateDao;
    @Autowired
    private TaxCalculationComponent taxCalculationComponent;

    public TaxInformation getTaxInformation(Article article){
        TaxRate taxRate = taxRateDao.getTaxRate(article);
        TaxCalculation taxCalculation = taxCalculationComponent.calculateTax(article, taxRate);
        return new TaxInformation(article, taxCalculation);
    }
}
