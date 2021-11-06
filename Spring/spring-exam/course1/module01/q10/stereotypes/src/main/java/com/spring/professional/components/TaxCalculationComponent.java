package com.spring.professional.components;

import com.spring.professional.ds.Article;
import com.spring.professional.ds.TaxCalculation;
import com.spring.professional.ds.TaxRate;
import org.springframework.stereotype.Component;

@Component
public class TaxCalculationComponent {
    public TaxCalculation calculateTax(Article article, TaxRate taxRate){
        return new TaxCalculation();
    }
}
