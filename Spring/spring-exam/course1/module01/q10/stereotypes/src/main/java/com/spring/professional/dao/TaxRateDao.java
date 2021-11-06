package com.spring.professional.dao;

import com.spring.professional.ds.Article;
import com.spring.professional.ds.TaxRate;
import org.springframework.stereotype.Repository;

@Repository
public class TaxRateDao {
    public TaxRate getTaxRate(Article article){
        return new TaxRate();
    }
}
