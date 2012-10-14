package com.mymoney.editor;

import java.beans.PropertyEditorSupport;

import com.domainlanguage.money.Money;
import com.mymoney.model.Account;

//converts string representation to Money object
public class MoneyEditor extends PropertyEditorSupport {

	public void setAsText(String val) {
		double amount = 0.0;		
		if ( (val != null) && (!val.trim().equals("")) ) {
			amount = Double.valueOf(val);
		}
		Money money = Money.valueOf(amount, Account.DEFAULT_CURRENCY);
		setValue(money);
	}
	
	public String getAsText() {
		Money money = (Money)getValue();
		String moneyStr = "";
		if (money != null) {
			moneyStr = money.toString();
			moneyStr = moneyStr.substring(2);//trim currency symbol and space
		}
		return moneyStr;
	}
}