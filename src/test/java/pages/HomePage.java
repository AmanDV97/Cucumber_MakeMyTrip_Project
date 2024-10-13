package pages;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import utilities.Utilities;

public class HomePage {
	WebDriver driver;
	Utilities utils;
	WebDriverWait eWait;
	LocalDate currentDate;
	int dayOfMonth;
	final String ExpectedTitle = "MakeMyTrip";
	SoftAssert Sassert;
	
	//Locators
	By closePopup = By.xpath("//span[@class='commonModal__close']");
	By roundTrip = By.xpath("//li[text()='Round Trip']");
	By fromCity = By.xpath("//label[@for='fromCity']");
	By fromCityText = By.xpath("//input[@placeholder='From']");
	By BLR = By.xpath("//span[@class='sr_iata font14 lightGreyText latoBold' and text()='BLR']");
	By toCity = By.xpath("//label[@for='toCity']");
	By toCityText = By.xpath("//input[@placeholder='To']");
	By BOM = By.xpath("//span[@class='sr_iata font14 lightGreyText latoBold' and text()='BOM']");
	By departureDate = By.xpath("(//p[text()=''])[1]");
	By travellers = By.xpath("//label[@for='travellers']");
	By Adults = By.xpath("//li[@data-cy='adults-3']");
	By Children = By.xpath("//li[@data-cy='children-1']");
	By ApplyButton = By.xpath("//button[@class=\"primaryBtn btnApply pushRight\"]");
	By passengerType = By.xpath("//div[@class='white-space-no-wrap blackText latoBold lineHeight18 darkGreyText appendBottom3' and text()='Regular']");
	By Search = By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']");
	
	
	public HomePage(WebDriver driver,Utilities utils){
		this.driver = driver;
		this.utils = utils;
		eWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void MakeMyTrip() {
		driver.get(utils.getUrl());
		driver.manage().window().maximize();
		eWait.until(ExpectedConditions.presenceOfElementLocated(closePopup)).click();
	}
	
	public void MakeMyTrip_checkSite(int count) {
		String ActualTitle = driver.getTitle();
		utils.screenShot(driver, count);
		Sassert = new SoftAssert();
		Sassert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	public void roundTrip() {
		eWait.until(ExpectedConditions.presenceOfElementLocated(roundTrip)).click();
	}
	
	public void fromCity(){
		eWait.until(ExpectedConditions.presenceOfElementLocated(fromCity)).click();
		eWait.until(ExpectedConditions.presenceOfElementLocated(fromCityText)).sendKeys("Bengaluru");
		eWait.until(ExpectedConditions.presenceOfElementLocated(BLR)).click();
	}
	
	public void toCity() {
		eWait.until(ExpectedConditions.presenceOfElementLocated(toCity)).click();;
		eWait.until(ExpectedConditions.presenceOfElementLocated(toCityText)).sendKeys("Mumbai");
		eWait.until(ExpectedConditions.presenceOfElementLocated(BOM)).click();
	}
	
	public void departureDate() {
		currentDate = LocalDate.now();
		dayOfMonth = currentDate.getDayOfMonth();
        System.out.println("Day: " + dayOfMonth);
        eWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[text()='"+dayOfMonth+"'])[1]"))).click();
	}
	
	public void returnDate() {
		dayOfMonth+=2;
		eWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//p[text()='"+dayOfMonth+"'])[1]"))).click();
	}
	
	public void travellers() {
		eWait.until(ExpectedConditions.presenceOfElementLocated(travellers)).click();
		eWait.until(ExpectedConditions.presenceOfElementLocated(Adults)).click();
		eWait.until(ExpectedConditions.presenceOfElementLocated(Children)).click();
		eWait.until(ExpectedConditions.presenceOfElementLocated(ApplyButton)).click();
	}
	
	public void passengerType() {
		eWait.until(ExpectedConditions.presenceOfElementLocated(passengerType)).click();;
		eWait.until(ExpectedConditions.presenceOfElementLocated(Search)).click();
	}
}
