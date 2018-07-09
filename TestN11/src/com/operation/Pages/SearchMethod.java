package com.operation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchMethod {
	
	WebDriver driver;
	By sId = By.id("searchData");
	By clickId = By.className("searchBtn");
	By sControl = By.xpath("//div[@id='view']/ul/li");
	
	
	public SearchMethod(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void searchWord(String searchWord) {
		driver.findElement(sId).sendKeys(searchWord);
	}
	
	public void clickSearch() {
		driver.findElement(clickId).click();
	}
	
	public void searchControl() {
		List<WebElement> searchElement = driver.findElements(sControl);
		if(searchElement.size()>0) {
			System.out.println("Arama için sonuç bulundu");
		}
	}
	
}
