package steps;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AutomobileInsurantData;
import pageobjects.AutomobileProductData;
import pageobjects.AutomobileVehicleData;
import pageobjects.SelectPriceOption;
import utilities.ExcelReader;
import utilities.Screenshots;

public class tc6_priceoption extends Screenshots{
	WebDriver driver;
	AutomobileVehicleData cv1;
	AutomobileInsurantData cv2;
	AutomobileProductData cv3;
	SelectPriceOption cv4;
	WebDriverWait wait;
	
    
@Given("when user enters valid vehicle data")
public void when_user_enters_valid_vehicle_data() throws IOException  {
	startTest();
	System.setProperty("webdriver.edge.driver","C:\\Users\\ISAHER\\Desktop\\Selenuim Demo\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
	driver=new EdgeDriver();;
	
	driver.get("http://sampleapp.tricentis.com/101/index.php");
	
	driver.findElement(By.linkText("Automobile")).click();
	
	cv1=new AutomobileVehicleData(driver);
	 
	  cv1.selectMake("Opel");
	  cv1.enterDateOfManufacture("09/27/2020");
	  cv1.enterEnginePerformance(344);
	  cv1.selectSeats(4);
	  cv1.selectFuelType("Petrol");
	  cv1.enterListPrice(550);
	  cv1.enterLicensePlateNumber("KA-19-5678");
	  cv1.enterAnnualMileage(2000);
	  cv1.clicknext();
}

@Given("user enters valid insurant data")
public void user_enters_valid_insurant_data()  throws InterruptedException {
	
	cv2=new AutomobileInsurantData(driver);
	
	cv2.enterfirstname("Insiya");
	cv2.enterlastname("Saher");
	cv2.enterDateOfBirth("09/09/2000");
	cv2.selectCountry("India");
	cv2.enterZipcode(440004);
	cv2.selectOccupation("Farmer");
	cv2.selectHobbies("Speeding");
	cv2.clicknext();
   
}

@Given("user enters valid product data")
public void user_enters_valid_product_data() throws InterruptedException{
	cv3=new AutomobileProductData(driver);
	   
	cv3.enterStartDate("01/09/2023");
	cv3.selectInsuranceSum("5.000.000,00");
	cv3.selectMeritRating("Bonus 1");
	cv3.selectDamageInsurance("No Coverage");
	cv3.selectOP("Euro Protection");
	cv3.selectCourtesyCar("No");
	cv3.clickNext();
}

@When("User selects price option for automobile")
public void user_selects_price_option_for_automobile() throws IOException {
	cv4=new SelectPriceOption(driver);
	   
	   cv4.selectPriceOption("Gold");
	   cv4.clickNext();
	   
	   
		  String a=driver.findElement(By.xpath("//a[@id='selectpriceoption']//child::span")).getText();
		  boolean result=a.equals("0");
		  takeScreenshot(driver);
		  assertEquals(true,result);

}

@Then("User navigates to Send Quote window of Automobile")
public void user_navigates_to_send_quote_window_of_automobile() {
	
	endTest();
	driver.close();
}
}
