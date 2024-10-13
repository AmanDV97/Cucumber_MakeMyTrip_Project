package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.Utilities;

public class BaseClass {
	public Utilities utils;
	public String browser;
	public WebDriver driver;
	ChromeOptions options;
	
	public void BrowserSetup(){
		System.out.println("BrowserSetup");
		utils = new Utilities();
		browser = utils.getBrowserInfo();
		System.out.println("BrowserSetup_browser"+browser);
		if(browser.equalsIgnoreCase("Chrome")) {
			System.out.println("BrowserSetup_path"+utils.path);
			System.setProperty("webdriver.chrome.driver", utils.path+"//Drivers//chromedriver.exe");
			options = new ChromeOptions();
//			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}
	}
	
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
