package com.pages.Testcases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.operation.Pages.LoginPage;
import com.operation.Pages.MenuCase;
import com.operation.Pages.PageCase;
import com.operation.Pages.SearchMethod;

public class TestMain {

	WebDriver driver;
	
	
	@Test
	public void testCase() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.n11.com/");
		
		if(driver.getTitle()!= null) {
			System.out.println("Anasayfa açýldý..");
		}
		
		LoginPage login = new LoginPage(driver);
		login.typeUsername("ramazanalkan7@gmail.com");
		login.typePassword("R123456789");
		login.clickOnLoginButton();
		
		SearchMethod search = new SearchMethod(driver);
		search.searchWord("samsung");
		search.clickSearch();
		search.searchControl();
		
		PageCase page = new PageCase(driver);
		page.ClickOnPage(2);
		page.favProduct(3);

		MenuCase operation = new MenuCase(driver);
		operation.favPage();
		page.clearFav();
		
		driver.close();
	}
	
	
	

}
