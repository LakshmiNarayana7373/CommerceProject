package commerce.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commerce.base.BaseClass;

public class CheckOutPage  extends BaseClass{
	
	@FindBy(xpath="(//input[@name='shippingoption'])[2]")
	WebElement shippingcheckbox;
	
	@FindBy(xpath="//button[@class='button-1 shipping-method-next-step-button']")
	WebElement shippingcontinuebtn;
	
	@FindBy(id="paymentmethod_1")
	WebElement payment;
	
	@FindBy(xpath="//button[@class='button-1 payment-method-next-step-button']")
	WebElement paymentcontinuebtn;
	
	@FindBy(id="CreditCardType")
	WebElement creditcard;
	
	@FindBy(id="CardholderName")
	WebElement cardholder;
	
	@FindBy(id="CardNumber")
	WebElement cardnumber;
	
	@FindBy(id="ExpireMonth")
	WebElement expiremonth;
	
	@FindBy(id="ExpireYear")
	WebElement expireyear;
	
	@FindBy(id="CardCode")
	WebElement cardcode;
	
	@FindBy(xpath="//button[@class='button-1 payment-info-next-step-button']")
	WebElement paymentinformation;
	
	@FindBy(xpath="//button[@class='button-1 confirm-order-next-step-button']")
	WebElement confirmorder;
	
	
	
	public CheckOutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void valiadteshippingmethod() {
		shippingcheckbox.click();
		shippingcontinuebtn.click();
	}
	public void validatepaymentmethod() {
		payment.click();
		paymentcontinuebtn.click();
	}
	public void validatepaymentinformation(String cardname,String cardnumber1,String cardcode1) {
		Select credit=new Select(creditcard);
		credit.selectByValue("MasterCard");
		cardholder.sendKeys(cardname);
		cardnumber.sendKeys(cardnumber1);
		Select month=new Select(expiremonth);
		month.selectByValue("5");
		Select year=new Select(expireyear);
		year.selectByValue("2028");
		cardcode.sendKeys(cardcode1);
		paymentinformation.click();
	}
     public void validateorder() {
    	 confirmorder.click();
 }
}
