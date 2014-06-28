package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.MainPageScreen;

public class ValidLogin {
MainPageScreen mainPage;
	 
	@Test
	public void validLogin() throws InterruptedException{
	 mainPage = new MainPageScreen();
	 Assert.assertTrue(mainPage.validLoginToMail().isMailLinkDisplayed());
	 	}

	@AfterClass
	public void closeBrowser(){
	mainPage.closePage();
	}
}

