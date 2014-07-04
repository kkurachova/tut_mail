package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.MainPageScreen;

public class invalidLoginName {
	MainPageScreen mainPage;

	@Test
	public void invalidLoginNameToMail() throws InterruptedException{
		MainPageScreen mainPage = new MainPageScreen();
		Assert.assertTrue(mainPage.invalidLoginNameToMail().isErrorMessageDisplayed());
	}
	
	@AfterClass
	public void closeBrowser(){
	mainPage.closePage();
	}
}
