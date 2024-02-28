package Project_POM;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.ExcelScript;

public class CarPOM {
	
public WebDriver driver;
ExcelScript ex;
	
	//Constructor
	public CarPOM(WebDriver driver) throws IOException
	{
		this.driver=driver;
		ex=new ExcelScript();
		ex.CarLoan();
		PageFactory.initElements(driver,this);
	}
	
//	WebElement Locators+identification
	
	@FindBy(tagName="h1")
	WebElement 	Heading_check;
	
	@FindBy(id="car-loan")
	WebElement car_menu;
	
	@FindBy(id="loanamount")
	WebElement LoanAmount;
	
	@FindBy(id="loaninterest")
	WebElement LoanInterest;
	
	@FindBy(id="loanterm")
	WebElement LoanTenure;
	
	@FindBy(xpath="//*[@id=\"emiamount\"]/p/span")//*[@id="emiamount"]/p/span
	WebElement LoanEMI;
	
	@FindBy(xpath="//*[@id=\"emipaymenttable\"]/table/tbody")
	WebElement Table;

	@FindBy(xpath="/html/body/header/div/nav/button/span")
	WebElement Menu;
	
	@FindBy(xpath="//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement Cal;
	
	@FindBy(xpath="//*[@id=\"menu-item-3294\"]/a")
	WebElement a;
	
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]/div/label")
	public WebElement EMIScroll;
	
	@FindBy(xpath="//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div")
	WebElement CarYearBtn;
	
	
// Action Methods
	
	public String checkHeading()
	{
		String heading=Heading_check.getText();
		return heading;
	}
	
	public void CarClick()
	{
		car_menu.click();
	}
	public void Loan_Amount()
	{
		LoanAmount.sendKeys(Keys.CONTROL + "a");
		LoanAmount.sendKeys(ex.getCar_P());
	}
	public void Loan_Interest()
	{
		LoanInterest.sendKeys(Keys.CONTROL + "a");
		LoanInterest.sendKeys(ex.getCar_I());
	}
	
	public void Loan_Tenure()
	{
		LoanTenure.sendKeys(Keys.CONTROL + "a");
		LoanTenure.sendKeys(ex.getCar_LT());
		CarYearBtn.click();
	}
	
	public String Loan_EMI()
	{
		String EMI = LoanEMI.getText();
		System.out.print("EMI: ");
		return EMI;
		
	}
	public void Menu_Click() {
		
		Cal.click();
		a.click();
		
	}
	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", EMIScroll);
	}
	public void EmiCalculation() {
		double e, principle_amount;
		double rate_of_interest;
		int tenture_in_month;
		String EMI=Loan_EMI();
		System.out.println(EMI);
		EMI = EMI.replace(",", "");
		int intValue = Integer.parseInt(EMI);
		System.out.println("The Loan EMI "+intValue);
		principle_amount = 1500000;
		rate_of_interest = (9.5/12)/100;
		tenture_in_month = 12;
		e = principle_amount * rate_of_interest;
		Math.pow(2, 3);
		e = e * Math.pow(1+rate_of_interest, tenture_in_month);
		e = e/(Math.pow(1+rate_of_interest, tenture_in_month)-1);
		System.out.println("Monthly EMI to be paid "+e);
		double Month_Interest =  e*(rate_of_interest);
		System.out.println("Monthly interest to be paid "+Month_Interest);
		double Month_principle = e - Month_Interest ;
		System.out.println("Monthly interest to be paid "+Month_principle);


	}

}
