package commerce.pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commerce.base.BaseClass;

public class RegisterationPage extends BaseClass {
	
	

	
	
	@FindBy(xpath="/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	WebElement register;
	@FindBy(id="gender-male")
	WebElement gender;
	@FindBy(id="FirstName")
	WebElement FirstName;
	@FindBy(id="LastName")
	WebElement LastName;
	@FindBy(xpath="//select[@name='DateOfBirthDay']")
	WebElement DateOfBirthDay;
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement DateOfBirthMonth;
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	WebElement DateOfBirthYear;
	@FindBy(id="Email")
	WebElement Email;
	@FindBy(id="Company")
	WebElement CompanyName;
	@FindBy(id="Password")
	WebElement pswd;
	@FindBy(id="ConfirmPassword")
	WebElement confirmpswd;
	@FindBy(id="register-button")
	WebElement registerbtn;
	
	
	public RegisterationPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public void validateregister(String firstname,String lastname,String email,String company,String password,String confirmpassword) {
		register.click();
		gender.click();
		FirstName.sendKeys(firstname);
		LastName.sendKeys(lastname);
		Select day=new Select(DateOfBirthDay);
		day.selectByValue("8");
		Select month=new Select(DateOfBirthMonth);
		month.selectByVisibleText("September");
		Select year=new Select(DateOfBirthYear);
		year.selectByValue("1998");
		Email.sendKeys(email);
		CompanyName.sendKeys(company);
		pswd.sendKeys(password);
		confirmpswd.sendKeys(confirmpassword);
		registerbtn.click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
