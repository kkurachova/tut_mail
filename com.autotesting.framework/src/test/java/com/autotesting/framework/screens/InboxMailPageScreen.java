package com.autotesting.framework.screens;

import org.openqa.selenium.By;

public class InboxMailPageScreen extends CommonPageScreen {
	private static final String PATH_TO_MAIL_LINK = "//*[@id=':e']/span";
		
	public InboxMailPageScreen getPage(){
		return this;
	}
	
	public boolean isMailLinkDisplayed(){
		return driver.findElements(By.xpath(PATH_TO_MAIL_LINK)).size()>0;
		
	}

}
