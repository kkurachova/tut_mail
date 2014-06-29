package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.InboxMailPageScreen;
import com.autotesting.framework.screens.MainPageScreen;

public class ValidLogin {
MainPageScreen mainPage;
	 
	@Test
	public void validLogin() throws InterruptedException{
	 mainPage = new MainPageScreen();
	 InboxMailPageScreen inbox = mainPage.validLoginToMail();
	 Assert.assertTrue(inbox.isMailLinkDisplayed());
	 inbox.closePage();
	 	}
	
	@Test
	public void invalidLoginNameToMail() throws InterruptedException{
		MainPageScreen mainPage = new MainPageScreen();
		Assert.assertTrue(mainPage.invalidLoginNameToMail().isErrorMessageDisplayed());
		mainPage.closePage();
	}

	@AfterClass
	public void closeBrowser(){
	
	}
}

