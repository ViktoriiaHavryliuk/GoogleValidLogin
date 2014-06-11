package org.jbehave.demo.google.pages;

import com.thoughtworks.selenium.Selenium;

public class GoogleAfterLoginPage {

	private Selenium selenium;
	private static final String TIMEOUT = "100000";
	public GoogleAfterLoginPage(Selenium selenium) {
		this.selenium = selenium;
		
		}


	
	public boolean isLoginNamePresent(String message) {
		//return selenium.isElementPresent("errormsg_0_Passwd");
		//html/body/div[2]/div[2]/div/span[1]
		////*[@id='gb']/div[1]/div[1]/div/div[3]/div[1]/a
		/*selenium.waitForPageToLoad(TIMEOUT);
		selenium.isElementPresent("//*[@id='gb']/div[1]/div[1]/div[2]/div[3]/div[1]/a");
		System.out.println(selenium.getText("//*[@id='gb']/div[1]/div[1]/div[2]/div[3]/div[1]/a"));*/
		selenium.waitForPageToLoad(TIMEOUT);
		return selenium.getText("//*[@id='gb']/div[1]/div[1]/div[2]/div[3]/div[1]/a").contains(message);
	}
}


