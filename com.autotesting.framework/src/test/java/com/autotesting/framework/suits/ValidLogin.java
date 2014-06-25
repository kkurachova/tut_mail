package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.MainPageScreen;

public class ValidLogin {

	@Test
	public void validLogin() throws InterruptedException{
	 MainPageScreen mainPage = new MainPageScreen();
	 Assert.assertTrue(mainPage.validLoginToMail().isMailLinkDisplayed());
	 
	}
 
}