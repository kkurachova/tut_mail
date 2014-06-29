package com.autotesting.framework.screens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autotesting.framework.utils.*;

public class CommonPageScreen {
	
    protected WebDriverWrapper driver = WebDriverRunner.getDriver();
    protected final Logger sl4glogger = LoggerFactory.getLogger(CommonPageScreen.class);
	
	public void closePage() {
		sl4glogger.debug("Закрываем браузер.");
		WebDriverRunner.stopWebDriver();
	}
}