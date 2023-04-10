package com.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author DELL
 *
 */
public class UIKeywords {

	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {

		if (browserName.equals("Chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (browserName.equals("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("Edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		}

		System.out.println(browserName + "browser is launched successfully");
	}

	public static void launchUrl(String url) {

		driver.get(url);

		System.out.println("Url is launched:" + url);

	}

	public static void closeBrowser() {

		driver.close();

		System.out.println("browser is closed successfully");

	}

	public static void switchToWindow(String byTitle) {

		String parentWindow = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		String title = driver.getTitle();

		for (String window : windows) {

			if (driver.switchTo().window(window).getTitle().equals(byTitle)) {

				System.out.println("switched on window:" + byTitle);
				break;

			}
		}

	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);

	}

	public static void hitButton(int keyCode) throws AWTException {
		Robot robo = new Robot();

		robo.keyPress(keyCode);

	}

	public static List<String> getTexts(By element) {

		List<WebElement> elements = driver.findElements(element);

		List<String> texts = new ArrayList<String>();

		for (WebElement elmnt : elements) {

			texts.add(elmnt.getText());

		}

		return texts;
	}

	public static void mouseMove(By xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(xpath)).build().perform();

	}

	public static void click(By xpath) {
		driver.findElement(xpath).click();

	}

	public static void click(String locatorType, String LocatorValue) {
		getWebElement(locatorType, LocatorValue).click();
	}

	public static WebElement getWebElement(String locatorType, String LocatorValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {

			element = driver.findElement(By.xpath(LocatorValue));
		}

		if (locatorType.equalsIgnoreCase("id")) {

			element = driver.findElement(By.id(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {

			element = driver.findElement(By.cssSelector(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("linkText")) {

			element = driver.findElement(By.linkText(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("partialLinkTest")) {

			element = driver.findElement(By.partialLinkText(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("class")) {

			element = driver.findElement(By.className(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("tagname")) {

			element = driver.findElement(By.tagName(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("name")) {

			element = driver.findElement(By.name(LocatorValue));
		}

		else {

			System.out.println("invalid locator type" + locatorType);
		}
		return element;

	}

	public static List<WebElement> getWebElements(String locatorType, String LocatorValue) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if (locatorType.equalsIgnoreCase("xpath")) {

			elements = driver.findElements(By.xpath(LocatorValue));
		}

		if (locatorType.equalsIgnoreCase("id")) {

			elements = driver.findElements(By.id(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {

			elements = driver.findElements(By.cssSelector(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("linkText")) {

			elements = driver.findElements(By.linkText(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("partialLinkTest")) {

			elements = driver.findElements(By.partialLinkText(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("class")) {

			elements = driver.findElements(By.className(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("tagname")) {

			elements = driver.findElements(By.tagName(LocatorValue));
		}
		if (locatorType.equalsIgnoreCase("name")) {

			elements = driver.findElements(By.name(LocatorValue));
		}

		else {

			System.out.println("invalid locator type" + locatorType);
		}
		return elements;

	}

	public static void mouseMove(String locatorType, String LocatorValue) {

		Actions actions = new Actions(UIKeywords.driver);
		actions.moveToElement(getWebElement(locatorType, LocatorValue)).perform();
	}

	public static List<String> getTexts(String LocatorType, String LocatorValue) {
		List<WebElement> elements = getWebElements(LocatorType, LocatorValue);

		List<String> texts = new ArrayList<String>();

		for (WebElement elmnt : elements) {

			texts.add(elmnt.getText());

		}
		return texts;
	}
}
