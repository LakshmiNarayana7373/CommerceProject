package commerce.Test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commerce.base.BaseClass;
import commerce.pages.RegisterationPage;
import commerce.utility.Log;
import coomerce.dataprovider.DataProviders;

public class RegistrationPageTest extends BaseClass {

	
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
	@Test(dataProvider= "Credentials Registeration",dataProviderClass=DataProviders.class)
	public void verifyregistration(String firstname,String lastname,String email,String company,String password,String confirmpassword) throws InterruptedException {
    	Log.startTestCase("Registeration Test");
    	RegisterationPage rp=new RegisterationPage();
    	Log.info(" User registerating the commerce application ");
    	Log.info("User enter the register all detials ");
    	rp.validateregister(firstname, lastname, email, company, password, confirmpassword);
    	//rp.validateregister(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email"), prop.getProperty("company"), prop.getProperty("password"), prop.getProperty("confirmpassword"));
    	Log.info("Register is success");
    	Log.endTestCase("Registeration Test");
    }

}
