package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.InboxMailPageScreen;
import com.autotesting.framework.screens.MainPageScreen;
import com.autotesting.framework.screens.RestorePasswordPageScreen;

public class ValidLogin {
MainPageScreen mainPage;
	 
	@Test
	public void ValidLogin() throws InterruptedException{
	 mainPage = new MainPageScreen();
	 InboxMailPageScreen inbox = mainPage.ValidLoginToMail();
	 Assert.assertTrue(inbox.isMailLinkDisplayed());
	 inbox.closePage();
	}
	
	@Test
	public void InvalidLoginNameToMail() throws InterruptedException{
		MainPageScreen mainPage = new MainPageScreen();
		Assert.assertTrue(mainPage.InvalidLoginNameToMail().isErrorMessageDisplayed());
		mainPage.closePage();
	}
	
	public class RestorePasswordPageLayout {
		
	@Test
	public RestorePasswordPageLayout() {
		MainPageScreen mainpage = new MainPageScreen();
		RestorePasswordPageScreen restore =  mainpage.restorePassword().getPage();
		Assert.assertTrue(restore.isRestorePasswordLinkDisplayed());
		restore.closePage();
	}

}
}