package com.autotesting.framework.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.autotesting.framework.suits.ValidLogin;

public class WebDriverWrapper extends ChromeDriver {
    protected final org.slf4j.Logger log = LoggerFactory.getLogger(ValidLogin.class);
    public static final int TIMEOUT_FOR_ACTION_SECONDS = 3;
      
    public WebDriverWrapper(ChromeDriverService service) {
        super(service, DesiredCapabilities.chrome());
    }
  
    public void clickByXpath(String xpath) {
        log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
        waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
        findElement(By.xpath(xpath)).click();
     }
      
    public void clickByXpath(String xpath, int timeout) {
        log.debug("[ACTION]: Click element by xpath: '" + xpath + "'");
        waitForElementPresentAndVisible(xpath, timeout);
        findElement(By.xpath(xpath)).click();
     }
    
    public void sendKeysByXpath(String xpath, String text) {
    	log.debug("[ACTION]: SendKeys by xpath: '" + xpath + "'");
        waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
        findElement(By.xpath(xpath)).sendKeys(text);
    }
  
    public void waitForElementPresentAndVisible(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
} 
