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
import pageobjects.AutomobileProductData;
import utilities.ExcelReader;
import utilities.Screenshots;

public class tc5_productdata extends Screenshots {
	AutomobileProductData pd;
	boolean result;
	WebDriver driver;
 

@Given("when user is in Tricentis Enter Product Data page")
public void when_user_is_in_tricentis_enter_product_data_page() {
	System.setProperty("webdriver.edge.driver","C:\\Users\\ISAHER\\Desktop\\Selenuim Demo\\TricentisSprint_team2\\src\\test\\resources\\drivers\\msedgedriver.exe");
	driver=new EdgeDriver();
	
	startTest();
	driver.get("http://sampleapp.tricentis.com/101/index.php");
	pd=new AutomobileProductData(driver);
	driver.findElement(By.linkText("Automobile")).click();
	driver.findElement(By.linkText("Enter Product Data")).click();
}

@When("he enters valid product data for automobile from {string} and {int}")
public void he_enters_valid_product_data_for_automobile_from_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader=new ExcelReader();
	List<Map<String,String>> testData=reader.getData("C:\\tricentisdata1.xls", SheetName);
	
	String startdate=testData.get(RowNumber).get("startdate");
    String sum=testData.get(RowNumber).get("sum");
    String merit=testData.get(RowNumber).get("merit");
    String damage=testData.get(RowNumber).get("damage");
    String courtesycar=testData.get(RowNumber).get("courtesycar");
    String OP=testData.get(RowNumber).get("OP");
    
	  pd.enterStartDate(startdate);
	  pd.selectInsuranceSum(sum);
	  pd.selectMeritRating(merit);
	  pd.selectDamageInsurance(damage);
	  pd.selectCourtesyCar(courtesycar);
	  pd.selectOP(OP);
	  
	  String a=driver.findElement(By.xpath("//a[@id='enterproductdata']//child::span")).getText();
	  result=a.equals("0");
	  takeScreenshot(driver);
	  assertEquals(true,result);
}

@Then("he can click on next to select price option")
public void he_can_click_on_next_to_select_price_option() {
	pd.clickNext();
	endTest();
	driver.close();
}
}
