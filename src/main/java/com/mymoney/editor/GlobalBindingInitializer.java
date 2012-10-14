package com.mymoney.editor;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.domainlanguage.money.Money;

public class GlobalBindingInitializer implements WebBindingInitializer {

    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Money.class, new MoneyEditor());
    }

}

