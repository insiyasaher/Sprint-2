package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

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
import pageobjects.SendQuote;
import utilities.Screenshots;

public class tc7_sendquote extends Screenshots{
	WebDriver driver;
	AutomobileVehicleData cv1;
	AutomobileInsurantData cv2;
	AutomobileProductData cv3;
	SelectPriceOption cv4;
	SendQuote cv5;
	WebDriverWait wait;

@Given("when user enters the valid vehicle data")
public void when_user_enters_the_valid_vehicle_data() {
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


@Given("user enters valid the insurant data")
public void user_enters_valid_the_insurant_data() {

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


@Given("user enters valid the product data")
public void user_enters_valid_the_product_data() {
	
		cv3=new AutomobileProductData(driver);
		   
		cv3.enterStartDate("01/09/2023");
		cv3.selectInsuranceSum("5.000.000,00");
		cv3.selectMeritRating("Bonus 1");
		cv3.selectDamageInsurance("No Coverage");
		cv3.selectOP("Euro Protection");
		cv3.selectCourtesyCar("No");
		cv3.clickNext();
}


@Given("user selects a sprice option")
public void user_selects_a_sprice_option() {
	
		cv4=new SelectPriceOption(driver);
		   
	    cv4.selectPriceOption("Gold");
	    cv4.clickNext();
	 
}


@When("User gives valid user details")
public void user_gives_valid_user_details() throws IOException {
	 cv5=new SendQuote(driver);
	    
	    cv5.enterEmail("saherinsiya@gmail.com");
	    cv5.enterUsername("isaher");
	    cv5.enterPassword("Insiya@1234");
	    cv5.enterConfirmpassword("Insiya@1234");
	    cv5.clickSendemail();
	    

		  String a=driver.findElement(By.xpath("//a[@id='sendquote']//child::span")).getText();
		  boolean result=a.equals("0");
		  takeScreenshot(driver);
		  assertEquals(true,result);

}

@Then("User receives a quote")
public void user_receives_a_quote() {

	endTest();
	endReport();
}

}
