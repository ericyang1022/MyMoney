package com.mymoney.editor;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.domainlanguage.money.Money;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalBindingInitializer implements WebBindingInitializer {

    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Money.class, new MoneyEditor());

        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true);
        binder.registerCustomEditor(Date.class, editor);

    }

}

