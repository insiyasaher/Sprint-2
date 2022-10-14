package pageobjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomobileVehicleData {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	
	
	@FindBy(id="make")
	WebElement make;

	@FindBy(id="engineperformance")
	WebElement enginePerformance;
	
	@FindBy(id="dateofmanufacture")
	WebElement dateOfManufacture;
	
	@FindBy(id="numberofseats")
	WebElement seats;
	
	@FindBy(id="fuel")
	WebElement fuel;
	
	@FindBy(id="listprice")
	WebElement listPrice;
	
	@FindBy(id="licenseplatenumber")
	WebElement licensePlateNumber;
	
	@FindBy(id="annualmileage")
	WebElement annualMileage;
	
	
	@FindBy(id="nextenterinsurantdata")
	WebElement next;
	
	
	public AutomobileVehicleData(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void selectMake(String s) {
		Select Make1=new Select(make);
		Make1.selectByVisibleText(s);
	}
  
	
	public void enterEnginePerformance(int n) {
		enginePerformance.sendKeys(""+n);
				
	}
	
	
	public void enterDateOfManufacture(String s) {
				dateOfManufacture.sendKeys(s);
	}
	
	public void selectSeats(int n) {
		Select Seats1=new Select(seats);
		Seats1.selectByVisibleText(""+n);
	}
	

	
	public void selectFuelType(String s) {
		Select Fuel1=new Select(fuel);
		Fuel1.selectByVisibleText(s);
	}

	public void enterListPrice(int n) {
		
		listPrice.sendKeys(""+n);
		
	}
	
	public void enterLicensePlateNumber(String s) {
	
		licensePlateNumber.sendKeys(s);
	}
	
	
	public void enterAnnualMileage(int n) {
		
		annualMileage.sendKeys(""+n);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("annualmileage")));
		
	}
	
	public boolean clicknext() {
		next.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(By.id("enterinsurantdata")).isDisplayed();
	}
	
	
	
	
	
	

}
