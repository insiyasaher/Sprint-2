package steps;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import pageobjects.HomePage;
import utilities.Screenshots;

public class tc1_selectvehicle extends Screenshots {
  
	HomePage home;
	boolean result;
	WebDriver driver;
	
	@Given("user is in Tricentis Home page")
	public void user_is_in_tricentis_home_page() {

		System.setProperty("webdriver.edge.driver","C:\\Users\\ISAHER\\Desktop\\Selenuim Demo\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		
		startReport();
		startTest();
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		home=new HomePage(driver);	
	}
	
	@When("User clicks on Automobile")
	public void user_clicks_on_automobile() throws IOException, InterruptedException {
	    
		result=home.clickAutomobile();
		takeScreenshot(driver);
		 assertEquals(true, result);
		 Thread.sleep(5000);
	}
	
	@Then("User reaches Enter Vehicle Data Page of Automobile")
	public void user_reaches_enter_vehicle_data_page_of_automobile() {
	   endTest();
	   driver.close();
	}
}
