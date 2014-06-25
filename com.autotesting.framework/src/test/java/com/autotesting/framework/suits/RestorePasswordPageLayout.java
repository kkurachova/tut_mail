package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.MainPageScreen;

public class RestorePasswordPageLayout {
	
	@Test
	public RestorePasswordPageLayout() {
		MainPageScreen mainpage = new MainPageScreen();
		Assert.assertTrue(mainpage.restorePassword().isRestorePasswordLinkDisplayed());
		
	}

}

