package commerce.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public  static Properties prop;
	
	public static  ThreadLocal<WebDriver>  driver=new ThreadLocal<WebDriver>();
	
	public  static  WebDriver getDriver() {
		 return driver.get();
		
	}
	
	@BeforeSuite
	public void beforesuite() {
		DOMConfigurator.configure("log4j.xml");
	}
	@BeforeTest
	public void configproperties()  {
		prop=new Properties();
		
			
			try {
				FileInputStream fis=new FileInputStream("C:\\Users\\10698942\\eclipse-workspace\\CommerceDemoStore\\configuration\\config.properties");
				prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}  catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static WebDriver launchbrowser(String browserName) {
		//String browserName=prop.getProperty("broswer");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());	
		}
		else {
			System.out.println("please enter the correct browser"+browserName);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		
		
			
	}
	
}
