package com.mymoney.model;

import java.util.HashSet;
import java.util.Set;

public class Category /*extends BaseEntity*/ {

	
	private final String category;
	private final Set<String> subcategories = new HashSet<String>();
	
	public Category(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	public Set<String> getSubcategories() {
		return subcategories;
	}
	
	public void addSubcategory(String subcategory) {
		this.subcategories.add(subcategory);
	}
	
	public void setSubcategories(Set<String> subcategories) {
		subcategories = this.subcategories;
	}
	
}
