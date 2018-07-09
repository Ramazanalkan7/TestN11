package com.operation.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageCase {

	WebDriver driver;
	By pageId = By.xpath("//div[@class='pagination']/a");
	By view = By.xpath("//span[@class='textImg followBtn']");
	By product = By.xpath("//h3[@class='productName bold']");
	By deleteFav = By.xpath("//span[@class='deleteProFromFavorites']");
	By favCount = By.xpath("//h3[@class='productName ']");
	By alertButton = By.xpath("//div[@class='btnHolder']");
	private String productName;

	public PageCase(WebDriver driver) {

		this.driver = driver;
	}

	public void pageClick(int page) {
		List<WebElement> pageElement = driver.findElements(pageId);
		pageElement.get((page - 1)).click();
	}
	
	public void ClickOnPage(int pageNumber) {
		List<WebElement> pageNumberList = driver.findElements(By.xpath("//div[@class='pagination']/a"));
		
		String pages = Integer.toString(pageNumber);

		int whileDurum=10;
		int index =pageNumberList.size();
		while (whileDurum < 20){
			try {
				for (int i = 0; i < pageNumberList.size(); i++) {
					if(pageNumberList.get(i).getText().contains(pages)) {
					pageNumberList.get(i).click();
					whileDurum=21;				
					}
					
				}
				if(whileDurum != 21) {
					pageNumberList.get(index-1).click();
					pageNumberList = driver.findElements(By.xpath("//div[@class='pagination']/a"));
					index =pageNumberList.size();
					System.out.println("forun dýþýndayým");
				}
			} catch (Exception e) {
				
			}finally{
				System.out.println("Seçilen sayfa açýldý");
			}
			
			
		} 
		
		
	
	}
	

	public void favProduct(int index) {

		List<WebElement> favElement = driver.findElements(view);
		List<WebElement> productElement = driver.findElements(product);
		setProductName(productElement.get(index - 1).getText());
		favElement.get(index - 1).click();

	}

	public void clearFav() {
		System.out.println(getProductName());
		List<WebElement> productElement = driver.findElements(favCount);
		List<WebElement> deleteElement = driver.findElements(deleteFav);

		if (productElement.size() > 0) {
			for (int i = 0; i < productElement.size(); i++) {
				if (productElement.get(i).getText().contains(getProductName())) {
					System.out.println("Ýzlemeye alýnan ürün bulundu...");
					deleteElement.get(i).click();
				}
			}
		} else {
			System.out.println("Favoriler listesi boþtur!!");
		}

		driver.switchTo().activeElement();
		driver.findElement(alertButton).click();
		driver.switchTo().defaultContent();

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
