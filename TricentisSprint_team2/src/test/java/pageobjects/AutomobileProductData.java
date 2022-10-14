package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AutomobileProductData {
	
	WebDriver driver;
	@FindBy(id="enterproductdata")
	WebElement product;
	
	@FindBy(id="startdate")
	WebElement DOS;
	
	@FindBy(id="insurancesum")
	WebElement sum;
	

	@FindBy(id="meritrating")
	WebElement merit;
	
	@FindBy(id="damageinsurance")
	WebElement damage;
	

	@FindBy(id="courtesycar")
	WebElement Courtesycar;
	
	 @FindBy(xpath="//input[@id='EuroProtection']//following::span[@class='ideal-check']")
	 WebElement euroProtection;
	
	@FindBy(id="nextselectpriceoption")
	WebElement next;
	
	
	
	public  AutomobileProductData(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickProductData() {
		product.click();
	}
	
	public void enterStartDate(String s) {
		DOS.sendKeys(s);
		}
	
	public void selectInsuranceSum(String s)
	{
	Select sum1 =new Select(sum);
		sum1.selectByVisibleText(s);
	}
	

	public void selectMeritRating(String s) {
		Select merit1=new Select(merit);
		merit1.selectByVisibleText(s);
	}
	
	public void selectDamageInsurance(String s)
	{
	Select ds =new Select(damage);
		ds.selectByVisibleText(s);
	}
	

	public void selectCourtesyCar(String s) {
		Select Courtesytcar1=new Select(Courtesycar);
		Courtesytcar1.selectByVisibleText(s);
	}
	
	
	public void selectOP(String OP)
	{
		euroProtection.click();
		
	}
	public boolean clickNext() {
		next.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver.findElement(By.id("selectpriceoption")).isDisplayed();
	}

}
