package commerce.Test;

import org.testng.annotations.Test;
import org.testng.Assert;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import commerce.base.BaseClass;
import commerce.pages.CheckOutPage;
import commerce.pages.LoginPage;
import commerce.pages.ShoppingCartpage;
import commerce.utility.Log;
import coomerce.dataprovider.DataProviders;



public class ShoppingCartPageTest  extends BaseClass{
	public LoginPage loginpage;
	public ShoppingCartpage sp;
	public CheckOutPage co;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchbrowser(browser);
	}
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
	  getDriver().quit();
	}
	 @Test(dataProvider= "credentials",dataProviderClass=DataProviders.class)
	public void verifylogin(String username,String pswd) {
    	Log.startTestCase("Login Test");
    	loginpage=new LoginPage();
    	Log.info("user logging the commerce application");
    	sp=loginpage.validatelogin(username, pswd);
    	Log.info("Login is success");
    	Log.endTestCase("Login Test ");
    	sp.validateshoppingcart();
    	Double unitprice2=sp.validateunitprice();
    	Log.info("User checking the unit price");
    	Double totalprice2=sp.validatetotalprice();
    	Log.info("User checking the total price");
    	Double expertedunitprice=unitprice2*2;
    	Log.error("total price was inncorrect");
    	Assert.assertEquals(totalprice2, expertedunitprice);
    	sp.proceed();
    	co=sp.billingaddress(prop.getProperty("city1"), prop.getProperty("address1"), prop.getProperty("postalcode1"), prop.getProperty("phonenumber1"));
    	Log.info("User entering the billing detials");
    	co.valiadteshippingmethod();
    	Log.info("User entering the shipping method");
    	co.validatepaymentmethod();
    	co.validatepaymentinformation(prop.getProperty("cardname"), prop.getProperty("cardnumber1"), prop.getProperty("cardcode1"));
    	co.validateorder();
    	Log.endTestCase("End of the commerce page");

}

}
