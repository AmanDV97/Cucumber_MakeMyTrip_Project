package pages;

import org.openqa.selenium.WebDriver;

import utilities.Utilities;

public class FlightBooking {
	WebDriver driver;
	Utilities utils;
	
	public FlightBooking(WebDriver driver,Utilities utils){
		this.driver = driver;
		this.utils = utils;
	}
	
	public void flightPage_Validate(int count) {
		utils.screenShot(driver,count);
	}
}
