package com.grio23;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;import org.w3c.css.sac.Locator;

import com.config.TestBase;
import com.grio23util.Environment;
import com.grio23util.PropUtil;
import com.grio23util.WaitFor;
import com.keywords.UIKeywords;

public class ProductTests extends TestBase {

	@Test
	public void verifySearchResultForPoloMen() throws AWTException {

		PropUtil repo = new PropUtil();
		Environment env = new Environment();

		UIKeywords.launchUrl(env.getAppurl());

		//UIKeywords.enterText(repo.getLocator("search_Products_textBox"),"us polo assn men shirts"[0],repo.getLocator("search_Products_textBox"), "us polo assn men shirts"[1]);

		UIKeywords.hitButton(KeyEvent.VK_ENTER);

		List<String> productTitles = UIKeywords.getTexts(repo.getLocator("product_titles_text")[0],repo.getLocator("product_titles_text")[1]);

		for (String productTitle : productTitles) {

			Assert.assertTrue(productTitles.contains("polo"), "roduct title doesnt contains polo" + productTitle);
		}
	}

	@Test

	public void verifycategoryListForMensShirts() {

		List<String> expected = new ArrayList<String>();
		expected.add("Graphic Tees");
		expected.add("Polos");
		expected.add("Solid Tees");
		expected.add("Sports Polos");
		expected.add("Muscle Vests");
		expected.add("Striped Tees");
		expected.add("Henley Tees");
		expected.add("Tees");
		expected.add("Muscle Tanks");
		expected.add("Active Tees");
		expected.add("Active Polos");

		PropUtil repo = new PropUtil();
		Environment env = new Environment();

		UIKeywords.launchUrl(env.getAppurlYepMe());

		UIKeywords.mouseMove(repo.getLocator("men_menu")[0],repo.getLocator("men_menu")[1]);
		UIKeywords.click(repo.getLocator("menu_tshirts_polo")[0],repo.getLocator("menu_tshirts_polo")[1]);
		WaitFor.elementToBePresent(repo.getLocator("categories_text")[0],repo.getLocator("categories_text")[1]);
		List<String> actualcategories = UIKeywords.getTexts(repo.getLocator("categories_text")[0],repo.getLocator("categories_text")[1]);

		Assert.assertTrue(actualcategories.contains(expected),"List didnt match:"+expected+ "actual:"+actualcategories);
		
	}

}
