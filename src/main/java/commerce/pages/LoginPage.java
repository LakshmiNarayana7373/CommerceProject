package commerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commerce.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginclick;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginbtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public  BookingProductPage validatelogin1() {
		loginclick.click();
		email.sendKeys("lakshminarayana7372@gmail.com");
		password.sendKeys("Narayana7373@");
		loginbtn.click();
		return new BookingProductPage();
		
	}
	
	public ShoppingCartpage validatelogin(String Username,String Password) {
		loginclick.click();
		email.sendKeys(Username);
		password.sendKeys(Password);
		loginbtn.click();
		return new ShoppingCartpage();
		
	}
	
	

}
