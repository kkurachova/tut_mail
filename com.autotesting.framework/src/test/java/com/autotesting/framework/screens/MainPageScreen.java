package com.autotesting.framework.screens;

public class MainPageScreen extends CommonPageScreen {	
    
	private static final String URL = "http://www.tut.by/";
    private static final String OPEN_MAIL_XPATH = "//a[@title='Почта']";
    private static final String LOGIN = "adminkat1@tut.by";
    private static final String EMPTY_LOGIN = "";
    private static final String LOGIN_FIELD_XPATH = "//*[@id='Username']";
    private static final String PASSWORD = "1qaz1qaz";
    private static final String PASSWORD_FIELD_XPATH = "//*[@id='Password']";
    private static final String ENTER_BUTTON_XPATH = "//input[@value='Войти']";
    private static final String INVALID_LOGIN = "adminkatt1@tut.by";
    private static final String RESTORE_PASSWORD_LINK_XPATH = "//*[@id='form']/fieldset/div[2]/a";
    private static final String PATH_TO_ERROR_MESSAGE = "//*[@id='form']/fieldset/strong";

   	       
    public MainPageScreen(){
	    sl4glogger.debug(LOGIN, PASSWORD);
	    driver.get(URL);
	}
          
    public InboxMailPageScreen ValidLoginToMail() throws InterruptedException { 
    	sl4glogger.info(String.format("Выполняем вход в систему с LOGIN = %s и PASSWORD = %s", LOGIN, PASSWORD));
    	driver.clickByXpath(OPEN_MAIL_XPATH);
    	driver.sendKeysByXpath(LOGIN_FIELD_XPATH, LOGIN);
    	driver.sendKeysByXpath(PASSWORD_FIELD_XPATH, PASSWORD);
    	driver.clickByXpath(ENTER_BUTTON_XPATH);
    	InboxMailPageScreen mailPage = new InboxMailPageScreen();
        return mailPage.getPage();			
    }
    
         
    public MainPageScreen InvalidLoginNameToMail() throws InterruptedException {     
    	sl4glogger.info(String.format("Ошибка при входе в систему с INVALID_LOGIN = %s и INVALID_PASSWORD = %s", INVALID_LOGIN, PASSWORD));
    	driver.clickByXpath(OPEN_MAIL_XPATH);
    	driver.sendKeysByXpath(LOGIN_FIELD_XPATH, INVALID_LOGIN);
    	driver.sendKeysByXpath(PASSWORD_FIELD_XPATH, PASSWORD);
    	driver.clickByXpath(ENTER_BUTTON_XPATH);
    	return this;
    }
    
	public boolean isErrorMessageDisplayed(){
		return driver.isElementDisplayed(PATH_TO_ERROR_MESSAGE);
	}
       
	public RestorePasswordPageScreen restorePassword() {   
        sl4glogger.info(String.format("Переходим на страницу восстановления пароля"));
        driver.clickByXpath(OPEN_MAIL_XPATH);
        driver.clickByXpath(RESTORE_PASSWORD_LINK_XPATH);
        RestorePasswordPageScreen restorePasswordpage = new RestorePasswordPageScreen();
        return restorePasswordpage.getPage();
    }
    
    public void emptyLoginToMail() throws InterruptedException { 
    	sl4glogger.info(String.format("Ошибка при входе в систему с EMPTY_LOGIN = %s и PASSWORD = %s", EMPTY_LOGIN, PASSWORD));
    	driver.clickByXpath(OPEN_MAIL_XPATH);
    	driver.sendKeysByXpath(LOGIN_FIELD_XPATH, EMPTY_LOGIN);
    	driver.sendKeysByXpath(PASSWORD_FIELD_XPATH, PASSWORD);
    	driver.clickByXpath(ENTER_BUTTON_XPATH);
    	}
}