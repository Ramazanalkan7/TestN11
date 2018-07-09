package com.operation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	By signId = By.className("btnSignIn");
	By uid = By.id("email");
	By upass = By.id("password");
	By loginButton = By.id("loginButton");
	By erorMesage = By.xpath("//div[@class='errorMessage']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		driver.findElement(signId).click();
	}
	
	public void typeUsername(String username) {
		driver.findElement(uid).sendKeys(username);
	}
	
	public void typePassword(String password) {
		
		driver.findElement(upass).sendKeys(password);
		
	}
	
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
		if(!driver.findElement(erorMesage).isEnabled()) {
			System.out.println("Kullanýcý adý veya þifre hatalý");
			System.exit(0);
		}
		
	}
	
	
	
}
