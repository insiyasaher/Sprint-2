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
import pageobjects.AutomobileInsurantData;
import pageobjects.AutomobileVehicleData;
import utilities.ExcelReader;
import utilities.Screenshots;

public class tc4_insurantdata extends Screenshots {
	AutomobileInsurantData cv;
	boolean result;
	WebDriver driver;
	
	@Given("when user is in Tricentis Enter Insurant Data page")
	public void when_user_is_in_tricentis_enter_insurant_data_page() {
		System.setProperty("webdriver.edge.driver","C:\\Users\\ISAHER\\Desktop\\Selenuim Demo\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		
		startTest();
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		cv=new AutomobileInsurantData(driver);
		driver.findElement(By.linkText("Automobile")).click();
		driver.findElement(By.linkText("Enter Insurant Data")).click();
	}

	@When("he enters valid insurant data for automobile from {string} and {int}")
	public void he_enters_valid_insurant_data_for_automobile_from_and(String SheetName, Integer RowNumber ) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData("C:\\tricentisdata1.xls", SheetName);
		
	    String fname=testData.get(RowNumber).get("fname");
	    String lname=testData.get(RowNumber).get("lname");
	    String dob=testData.get(RowNumber).get("dob");
	    String country=testData.get(RowNumber).get("country");
	    String zipcode=testData.get(RowNumber).get("zipcode");
	    String occupation=testData.get(RowNumber).get("occupation");
	    String hobbies=testData.get(RowNumber).get("hobbies");
	    
	    cv.enterfirstname(fname);
	    cv.enterlastname(lname);
	    cv.enterDateOfBirth(dob);
	    cv.selectCountry(country);
	    cv.enterZipcode(Integer.parseInt(zipcode));
	    cv.selectOccupation(occupation);
	    cv.selectHobbies(hobbies);
	    String a=driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/nav/ul/li[2]/a/span")).getText();
	    result=a.equals("0");
		  takeScreenshot(driver);
		  assertEquals(true,result);
	}
	
	@Then("he can click on next to enter product data")
	public void he_can_click_on_next_to_enter_product_data() {
		cv.clicknext();
		endTest();
		
		driver.close();
	}
  
}
