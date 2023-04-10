package com.config;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.keywords.UIKeywords;

public class TestBase {

	@Parameters("browser-name")
	@BeforeMethod
	public void setUp(@Optional String browserName) throws Exception {
if(browserName ==null) {
	
	browserName= "Chrome";
}

		if (browserName.isEmpty()) {

			browserName = "Chrome";

			System.out.println("setting default browser as chrome");
		}

		UIKeywords.openBrowser(browserName);
	}

	public void tearDown() {
		UIKeywords.closeBrowser();
		
		System.out.println("browser closed");
	}

}
