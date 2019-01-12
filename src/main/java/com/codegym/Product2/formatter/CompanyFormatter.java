package com.codegym.Product2.formatter;

import com.codegym.Product2.model.Company;
import com.codegym.Product2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CompanyFormatter implements Formatter<Company> {
    private CompanyService companyService;
    @Autowired
    private CompanyFormatter (CompanyService companyService){this.companyService = companyService;}
    @Override
    public Company parse(String text, Locale locale) throws ParseException {
        return companyService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Company object, Locale locale) {
        return "["+object.getId()+","+object.getName()+"]";
    }
}
