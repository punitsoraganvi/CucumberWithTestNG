package com.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pageobjectmodel.AmazonPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonStepDefination {
	
	WebDriver driver;
	AmazonPage amazon;
	
	@Before
	public void OpenApp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("open the browser and enter the amazon url")
	public void open_the_browser_and_enter_the_amazon_url() {
		String actTitle = driver.getTitle();
	  //  Assert.assertEquals(actTitle, "Amazon.com. Spend less. Smile more.");
	
	}
	@When("search mobile item")
	public void search_mobile_item() {
		amazon = new AmazonPage(driver);
	    amazon.enterText("mobiles");
	    amazon.searchBtn();
	}
	
	@When("click on particuler item")
	public void click_on_particuler_item() {
		amazon = new AmazonPage(driver);
		amazon.clickItem();
	}
	@When("click to add to cart button and goto cart page")
	public void click_to_add_to_cart_button_and_goto_cart_page() {
		amazon = new AmazonPage(driver);
		amazon.addCart();
		amazon.cartPage();
	}
	@Then("to verify the item is added successfully")
	public void to_verify_the_item_is_added_successfully() {
		amazon = new AmazonPage(driver);
		Assert.assertEquals(amazon.getTitleItem(), amazon.getCartTitleItem());
	  	}


}
