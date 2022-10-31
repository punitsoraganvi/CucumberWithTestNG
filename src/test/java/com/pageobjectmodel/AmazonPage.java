package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	WebDriver driver;

	@FindBy(id = "twotabsearchtextbox")
	WebElement textBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-component-id='23']")
	WebElement item;

	@FindBy(xpath = "//span[@id='nav-cart-count']")
	WebElement addTOCart;
	
	@FindBy(id="productTitle")
	WebElement itemTitle;
	
	
	
	@FindBy(id="nav-cart")
	WebElement cartPage;
	
	@FindBy(xpath="//span[@class='a-list-item']//a[@class='a-link-normal sc-product-link']")
	WebElement cartItem;
	

	public AmazonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterText(String text) {
		textBox.sendKeys(text);
	}

	public void searchBtn() {
		searchBtn.click();
	}

	public void clickItem() {
		item.click();
	}
	public String getTitleItem() {
		String title1 = cartItem.getText();
		return title1;
	}

	public void addCart() {
		addTOCart.click();
	}
	
	public void cartPage() {
		cartPage.click();
	}
	public String getCartTitleItem() {
		String title2 = cartItem.getText();
		return title2;
	}
	
	

}