package com.autotesting.framework.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageScreen {	
    private static WebDriver driver;
    
    private static final String OPEN_MAIL_XPATH = "//*[@id='mainmenu']/div/ul[1]/li[2]/a";
    private static final String LOGIN = "adminkat1@tut.by";
    private static final String EMPTY_LOGIN = "";
    private static final String LOGIN_FIELD_XPATH = "//*[@id='Username']";
    private static final String PASSWORD = "1qaz1qaz";
    private static final String PASSWORD_FIELD_XPATH = "//*[@id='Password']";
    private static final String ENTER_BUTTON_XPATH = "//*[@id='form']/fieldset/div[3]/input";
    private static final String INVALID_LOGIN = "adminkatt1@tut.by";
    private static final String INVALID_PASSWORD = "1qaz2wsx";
    private static final String RESTORE_PASSWORD_LINK_XPASS = "//*[@id='form']/fieldset/div[2]/a";
    public InboxMailPageScreen validLoginToMail() throws InterruptedException {    
        driver.findElement(By.xpath(OPEN_MAIL_XPATH)).click();
        driver.findElement(By.xpath(LOGIN_FIELD_XPATH)).sendKeys(LOGIN);
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(ENTER_BUTTON_XPATH)).click();
        InboxMailPageScreen mailPage = new InboxMailPageScreen();
        return mailPage.getPage();
       				
    } 
    
    public MainPageScreen invalidLoginNameToMail() throws InterruptedException {     
        driver.findElement(By.xpath(OPEN_MAIL_XPATH)).click();
        driver.findElement(By.xpath(LOGIN_FIELD_XPATH)).sendKeys(INVALID_LOGIN);
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys(PASSWORD);
        driver.findElement(By.xpath(ENTER_BUTTON_XPATH)).click();
        return this;
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
        driver.findElement(By.xpath(RESTORE_PASSWORD_LINK_XPASS)).click();
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