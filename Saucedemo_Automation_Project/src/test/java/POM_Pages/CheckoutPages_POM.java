package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;

public class CheckoutPages_POM extends BasePage{
	private Logger log = LogManager.getLogger(CheckoutPages_POM.class);
	public CheckoutPages_POM(WebDriver wd)
	{
		super(wd);
	}
	//lpcator reposiory
	@FindBy(id="first-name")WebElement txt_firstName;
	@FindBy(id="last-name")WebElement txt_lastname;
	@FindBy(id="postal-code")WebElement txt_zipCode;
	@FindBy(id="continue")WebElement btn_continue;
	@FindBy(id="finish")WebElement btn_finish;
	@FindBy(id="back-to-products")WebElement btn_back_home;
	
	//actions repository
	public void enterDetails(String fname, String lname, String zip) {
		txt_firstName.sendKeys(fname);
		txt_lastname.sendKeys(lname);
		txt_zipCode.sendKeys(zip);
		btn_continue.click();
		log.info("Shipping address details entered");
	}
	public void clickFinish() {
		btn_finish.click();
		log.info("Clicked finish button and order placed");
	}
	public void click_on_back_Home() {
		btn_back_home.click();
		log.info("clicked on Back to Home button");
	}
	
}
