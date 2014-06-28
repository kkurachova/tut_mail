package com.autotesting.framework.screens;

import org.openqa.selenium.By;

public class MainPageScreen extends CommonPageScreen {	
    
	private static final String URL = "http://www.tut.by/";
    private static final String OPEN_MAIL_XPATH = "//*[@id='mainmenu']/div/ul[1]/li[2]/a";
    private static final String LOGIN = "adminkat1@tut.by";
    private static final String EMPTY_LOGIN = "";
    private static final String LOGIN_FIELD_XPATH = "//*[@id='Username']";
    private static final String PASSWORD = "1qaz1qaz";
    private static final String PASSWORD_FIELD_XPATH = "//*[@id='Password']";
    private static final String ENTER_BUTTON_XPATH = "//*[@id='form']/fieldset/div[3]/input";
    private static final String INVALID_LOGIN = "adminkatt1@tut.by";
    private static final String INVALID_PASSWORD = "1qaz2wsx";
    private static final String RESTORE_PASSWORD_LINK_XPATH = "//*[@id='form']/fieldset/div[2]/a";
    private static final String PATH_TO_ERROR_MESSAGE = "//*[@id='form']/fieldset/strong";
    
    
    public MainPageScreen(){
    sl4glogger.debug(LOGIN, PASSWORD);
    driver.get(URL);
    }
          
    public InboxMailPageScreen validLoginToMail() throws InterruptedException { 
    	sl4glogger.info(String.format("Выполняем вход в систему с LOGIN = %s и PASSWORD = %s", LOGIN, PASSWORD));
    	driver.sendKeysByXpath(LOGIN_FIELD_XPATH, LOGIN);
    	driver.sendKeysByXpath(PASSWORD_FIELD_XPATH, PASSWORD);
    	driver.clickByXpath(ENTER_BUTTON_XPATH);
    	InboxMailPageScreen mailPage = new InboxMailPageScreen();
        return mailPage.getPage();			
    } 
          
    public MainPageScreen invalidLoginNameToMail() throws InterruptedException {     
    	sl4glogger.info(String.format("Выполняем вход в систему с INVALID_LOGIN = %s и INVALID_PASSWORD = %s", INVALID_LOGIN, INVALID_PASSWORD));
    	driver.clickByXpath(LOGIN_FIELD_XPATH);
    	driver.clickByXpath(PASSWORD_FIELD_XPATH);
    	driver.clickByXpath(ENTER_BUTTON_XPATH);
    	return this;
    }
    
	public boolean isErrorMessageDisplayed(){
		return driver.findElements(By.xpath(PATH_TO_ERROR_MESSAGE)).size()>0;
		
	}
    
    public void invalidPasswordToMail() throws InterruptedException {     
        driver.findElement(By.xpath(OPEN_MAIL_XPATH)).click();
        driver.findElement(By.xpath(LOGIN_FIELD_XPATH)).sendKeys(LOGIN);
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(INVALID_PASSWORD);
        driver.findElement(By.xpath(ENTER_BUTTON_XPATH)).click();
    }
    
    public void invalidLoginAndPasswordToMail() throws InterruptedException { 
        driver.findElement(By.xpath(OPEN_MAIL_XPATH)).click();
        driver.findElement(By.xpath(LOGIN_FIELD_XPATH)).sendKeys(INVALID_LOGIN);
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(INVALID_PASSWORD);
        driver.findElement(By.xpath(ENTER_BUTTON_XPATH)).click();
    }
    
    
    public RestorePasswordPageScreen restorePassword() {   
        driver.findElement(By.xpath(RESTORE_PASSWORD_LINK_XPATH)).click();
        RestorePasswordPageScreen restorePasswordpage = new RestorePasswordPageScreen();
        return restorePasswordpage.getPage();
    }
    
    public void emptyLoginToMail() throws InterruptedException { 
        driver.findElement(By.xpath(OPEN_MAIL_XPATH)).click();
        driver.findElement(By.xpath(LOGIN_FIELD_XPATH)).sendKeys(EMPTY_LOGIN);
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(ENTER_BUTTON_XPATH)).click();
    }

}