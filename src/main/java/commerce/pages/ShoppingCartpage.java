package commerce.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commerce.base.BaseClass;

public class ShoppingCartpage extends BaseClass {
	
  
	@FindBy(xpath="//span[@class='cart-label']")
	WebElement shoppingcart;
	
	@FindBy(xpath="//table[@class='cart']/tbody/tr/td")
    List<WebElement> shoppingtable;
	
	@FindBy(xpath="//span[@class='product-unit-price']")
	WebElement unitprice;
	
	@FindBy(xpath="//span[@class='product-subtotal']")
	WebElement totalprice;
	
	
	@FindBy(id="termsofservice")
	WebElement agreecheckbox;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkout;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement country;
	
	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement state;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement city;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement address;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalcode;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phonenumber;
	
	@FindBy(xpath="(//button[@class='button-1 new-address-next-step-button'])[1]")
	WebElement continuebtn;

	
	public ShoppingCartpage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void validateshoppingcart() {
		shoppingcart.click();
		for(WebElement ele:shoppingtable) {
			String tabletext=ele.getText();
			System.out.println(tabletext);
		}
	}
	public double validateunitprice() {
		String unitprice1=unitprice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-Z0-9]","");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
		
	}
	public double validatetotalprice() {
		String totalprice1=totalprice.getText();
		String total=totalprice1.replaceAll("[^a-zA-Z0-9]", "");
		double finaltotalprice=Double.parseDouble(total);
		return finaltotalprice/100;
	}
	public void proceed() {
		agreecheckbox.click();
		checkout.click();
		
		
	}
	public CheckOutPage billingaddress(String city1,String address1,String postalcode1,String phonenumber1) {
		Select country1=new Select(country);
		country1.selectByValue("133");;
		Select state1=new Select(state);
		state1.selectByIndex(0);
		city.sendKeys(city1);
		address.sendKeys(address1);
		postalcode.sendKeys(postalcode1);
		phonenumber.sendKeys(phonenumber1);
		continuebtn.click();
		return new CheckOutPage();
	}
}
