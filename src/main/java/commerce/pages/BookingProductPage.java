package commerce.pages;



import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



import commerce.base.BaseClass;

public class BookingProductPage extends BaseClass {
	
	@FindBy(xpath="(//a[normalize-space()='Computers'])[1]")
	WebElement computerproduct;
	
	@FindBy(xpath="//ul[@class='top-menu notmobile']/li[1]/ul/li")
	List<WebElement> differentproduct;
	
	@FindBy(xpath="//div[@class='page-title']")
	WebElement pagetitle;
	
	@FindBy(xpath="//input[@id='attribute-option-6']")
	WebElement i5core;
	
	@FindBy(xpath="//input[@id='attribute-option-7']")
	WebElement i7core;
	
	@FindBy(xpath="//select[@id='products-orderby']")
	WebElement sortby;
	
	@FindBy(xpath="//select[@id='products-pagesize']")
	WebElement display;
	
	@FindBy(xpath="(//button[@class='button-2 product-box-add-to-cart-button'])[1]")
	WebElement AddToCart;
	
	@FindBy(xpath="//button[@id='add-to-cart-button-4']")
	WebElement nextpagecart;
	
	@FindBy(xpath="//*[@id=\"bar-notification\"]/div/span")
	WebElement notificationclose;
	
	public BookingProductPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void validateBooking() {
		Actions act=new Actions(getDriver());
		act.moveToElement(computerproduct).build().perform();
		
		for(WebElement ele:differentproduct) {
			String productnames=ele.getText();
			System.out.println(productnames);
			if(productnames.equalsIgnoreCase("Notebooks")) {
				ele.click();
				break;
			}
		}	
	}
	public String validateTitle() {
		String title=pagetitle.getText();
		System.out.println(title);
		return title;
		
	}
	public void validatecheckboxes() {
		i5core.click();
		i7core.click();
		
	}
	public void validatefiltering() {
		Select dropdown1=new Select(sortby);
		dropdown1.selectByValue("5");
		Select dropdown2=new Select(display);
		dropdown2.selectByValue("9");
	}
	public void validatecart() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", AddToCart);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",nextpagecart);
	}
	public ShoppingCartpage closenotify() {
		notificationclose.click();
		return new ShoppingCartpage();
	}
}
