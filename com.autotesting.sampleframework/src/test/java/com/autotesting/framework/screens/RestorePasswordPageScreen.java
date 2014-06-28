package com.autotesting.framework.screens;

import org.openqa.selenium.By;

public class RestorePasswordPageScreen extends CommonPageScreen {
	private static final String PATH_TO_RESTORE_PASSWORD_MESSAGE = "//*[@id='body']/h2";
	
	public RestorePasswordPageScreen getPage(){
		return this;
	}
	
	public boolean isRestorePasswordLinkDisplayed(){
		return driver.findElements(By.xpath(PATH_TO_RESTORE_PASSWORD_MESSAGE)).size()>0;
		
	}

}

