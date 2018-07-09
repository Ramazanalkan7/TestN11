package com.operation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuCase {

	WebDriver driver;
	By favId = By.xpath("//a[@href='https://www.n11.com/hesabim/istek-listelerim']");
	By favPage = By.xpath("//a[@href='https://www.n11.com/hesabim/favorilerim']");
	
	public MenuCase(WebDriver driver) {
		this.driver = driver;
	}

	public void favPage() {
		WebElement fav = driver.findElement(By.xpath("//div[@class='myAccount']"));
		Actions act = new Actions(driver);
		int elementPosition = fav.getLocation().getY();
		String js = String.format("window.scroll(0, %s)", elementPosition);
		((JavascriptExecutor) driver).executeScript(js);
		act.moveToElement(fav).perform();
		driver.findElement(favId).click();
		driver.findElement(favPage).click();
	}
	
	
	

}
