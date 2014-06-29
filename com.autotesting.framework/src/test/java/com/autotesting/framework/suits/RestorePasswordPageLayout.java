package com.autotesting.framework.suits;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.autotesting.framework.screens.MainPageScreen;
import com.autotesting.framework.screens.RestorePasswordPageScreen;

public class RestorePasswordPageLayout {
	
	@Test
	public RestorePasswordPageLayout() {
		MainPageScreen mainpage = new MainPageScreen();
		RestorePasswordPageScreen restore =  mainpage.restorePassword().getPage();
		Assert.assertTrue(restore.isRestorePasswordLinkDisplayed());
		restore.closePage();
	}

}

