package commerce.Test;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import commerce.base.BaseClass;
import commerce.pages.LoginPage;
import commerce.pages.ShoppingCartpage;
import commerce.utility.Log;
import coomerce.dataprovider.DataProviders;


public class LoginPageTest extends BaseClass {
	public LoginPage loginpage;
	public ShoppingCartpage sp;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchbrowser(browser);
	}
	
    @Test(dataProvider= "credentials",dataProviderClass=DataProviders.class)
	public void verifylogin(String username,String pswd) {
    	Log.startTestCase("Login Test");
    	loginpage=new LoginPage();
    	Log.info("user logging the commerce application");
    	loginpage.validatelogin(username,pswd);
    	Log.info("Login is success");
    	Log.endTestCase("Login Test ");
}
    @AfterMethod
	public void teardown() throws InterruptedException, IOException {
    	TakesScreenshot  ts=(TakesScreenshot) driver;
    	File f=ts.getScreenshotAs(OutputType.FILE);
    	File dstf=new File("C:\\Users\\10698942\\eclipse-workspace\\CommerceProject\\ScreenShot\\loginpage.png");
    	FileUtils.copyFile(f, dstf);
		getDriver().quit();
	}
   
    
}
