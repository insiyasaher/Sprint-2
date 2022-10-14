package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AutomobileVehicleData;
import utilities.ExcelReader;
import utilities.Screenshots;

public class tc3_vehicledata_invalid extends Screenshots{
	AutomobileVehicleData cv;
	boolean result;
	WebDriver driver;
  
	@Given("when user is in Tricentis the Home page")
	public void when_user_is_in_tricentis_the_home_page() {
		System.setProperty("webdriver.edge.driver","C:\\Users\\ISAHER\\Desktop\\Selenuim Demo\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		
		startTest();
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		cv=new AutomobileVehicleData(driver);
		driver.findElement(By.linkText("Automobile")).click();
	}

	@When("he enters invalid vehicle data for automobile from {string} and {int}")
	public void he_enters_invalid_vehicle_data_for_automobile_from_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData("C:\\tricentisdata1.xls", SheetName);
		
	    String make=testData.get(RowNumber).get("make");
	    String Eperformance=testData.get(RowNumber).get("Eperformance");
	    String dom=testData.get(RowNumber).get("dom");
	    String seats=testData.get(RowNumber).get("seats");
	    String fuel=testData.get(RowNumber).get("fuel");
	    String listprice=testData.get(RowNumber).get("listprice");
	    String license=testData.get(RowNumber).get("license");
	    String mileage=testData.get(RowNumber).get("mileage");
	    
	      cv.selectMake(make);
	      cv.enterEnginePerformance(Integer.parseInt(Eperformance));
		  cv.enterDateOfManufacture(dom);
		  cv.selectSeats(Integer.parseInt(seats));
		  cv.selectFuelType(fuel);
		  cv.enterListPrice(Integer.parseInt(listprice));
		  cv.enterLicensePlateNumber(license);
		  cv.enterAnnualMileage(Integer.parseInt(mileage));
		  String a=driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/nav/ul/li[1]/a/span")).getText();
		  result=a.equals("0");
		  takeScreenshot(driver);
		  assertEquals(false,result);
	}

	@Then("he gets error message")
	public void he_gets_error_message() {
		 endTest();
		 driver.close();
	}

 
 
}
