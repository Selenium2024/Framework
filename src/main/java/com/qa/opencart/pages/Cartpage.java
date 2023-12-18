package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class Cartpage {

	int i = 10;
	private By cart = By.id("id");

	public void getCart() {
		System.out.println(cart);
	}

}
