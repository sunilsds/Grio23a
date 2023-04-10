package com.grio23util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.keywords.UIKeywords;

public class WaitFor {
	private static FluentWait<WebDriver> wait = null;
	static {

		wait = new FluentWait<WebDriver>(UIKeywords.driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));

		wait.withMessage("wait is finished and element is not loaded or available");

	}

	public static void elementToBePresent(By locator) {

		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void elementToBePresent(String LocatorType, String LocatorValue) {
		
		wait.ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated((By) UIKeywords.getWebElement(LocatorType, LocatorValue)));
	}

}
