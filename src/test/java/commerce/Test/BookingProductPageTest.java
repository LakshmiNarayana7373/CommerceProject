package commerce.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commerce.base.BaseClass;
import commerce.pages.BookingProductPage;
import commerce.pages.LoginPage;
import commerce.utility.Log;

public class BookingProductPageTest extends BaseClass {
	
	public LoginPage loginpage;
	public BookingProductPage bp;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchbrowser(browser);
	}
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().quit();
	}
    @Test(priority=1)
	public void verifylogin() throws InterruptedException {
    	Log.startTestCase("Login Test");
    	loginpage=new LoginPage();
    	Log.info("user logging the commerce application");
    	bp=loginpage.validatelogin1();
    	Log.info("Login is success");
    	Log.endTestCase("Login Test ");
    	bp.validateBooking();
    	Log.info("Booking product");
    	String ptitle=bp.validateTitle();
    	Log.info("printing the title");
    	Assert.assertEquals(ptitle, "Notebooks");
    	bp.validateTitle();
    	bp.validatecheckboxes();
    	bp.validatefiltering();
    	Log.startTestCase("Booking Test");
    	Log.info("Booking the products in commerce application");
    	bp.validatecart();
    	bp.closenotify();
    	Log.endTestCase("Booking Test");
}

}
