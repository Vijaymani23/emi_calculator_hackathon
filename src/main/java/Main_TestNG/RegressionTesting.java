package Main_TestNG;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Project_POM.CarPOM;
import Project_POM.HomePOM;
import Project_POM.LoanCal1;
import Project_POM.LoanCal2;
import Project_POM.LoanCal3;
import Resources.Screenshots;
@Listeners(Main_TestNG.ExtentReportManager.class)
public class RegressionTesting  {
	
	public static WebDriver driver;
	CarPOM lp;
	HomePOM Hl ;
	Screenshots ss;
	LoanCal1 lc1;
	LoanCal2 lc2;
	LoanCal3 lc3;

	@BeforeClass
	void setup() throws InterruptedException
	{
//		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://emicalculator.net/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		ss=new Screenshots();
		
	}
	@Test(priority=1)
	void testLogo() throws IOException, AWTException, InterruptedException
	{
		lp=new CarPOM(driver);
		ss.ScreenShotTaker(driver,"EmiCal");
	    Assert.assertEquals(lp.checkHeading(), "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");
	}
	@Test(priority=2)
	void Car_Loan() throws IOException, AWTException, InterruptedException
	{
		lp.CarClick();
		lp.Loan_Amount();
		lp.Loan_Interest();
		lp.Loan_Tenure();	
		ss.ScreenShotTaker(driver,"CarLoan");
	    lp.scroll();
		ss.ScreenShotTaker(driver,"CarLoanEmi");
	}
	@Test(priority=3)
	void EMI_Calculation()
	{
		lp.EmiCalculation();
		lp.Menu_Click();	
	}
    @Test(priority=4)
    public void Home_page() throws IOException, InterruptedException, AWTException {
  	   Hl=new HomePOM(driver);
	   Hl.Home_Loan_Set();
	   Thread.sleep(5000);
	   ss.ScreenShotTaker(driver,"HomeLoan");
	   Hl.Scroll1();
	   ss.ScreenShotTaker(driver,"HomeLoanEMI");
	   Hl.scroll2();
	   Hl.WriteTable();
	   ss.ScreenShotTaker(driver,"HomeLoanTable");
    }
    @Test(priority=5)
    public void Calc1() throws InterruptedException, IOException {
    	lc1=new LoanCal1(driver);
		lc1.LoanCalClick();
		lc1.LoanAMT();
		lc1.LoanINt();
		lc1.Tenure();
		lc1.yearTomonth();
		lc1.feeCharges();
		lc1.emi();
		lc1.adv();
		lc1.date();
		lc1.month();
		lc1.Dropdn();
		lc1.hover();
		System.out.println("UI check for EMI Calculator page done Successfully");
		System.out.println("=====================");
    }
    @Test(priority=6)
    public void Calc2() throws InterruptedException, IOException {
    	lc2=new LoanCal2(driver);
		lc2.LoanCal2Click();
		lc2.emi();
		lc2.UI_Check2();
		System.out.println("UI check for Loan Amount Calculator page done Successfully");
		System.out.println("=====================");
    }
    @Test(priority=7)
    public void Calc3() throws InterruptedException, IOException {
    	lc3=new LoanCal3(driver);
		lc3.LoanCal3Click();
		lc3.UI_Check3();
		System.out.println("UI check for Loan Tenure Calculator page done Successfully");
		System.out.println("=====================");
    }
    
    public String captureScreen(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_"+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	    }
    
    @AfterClass
    public void close_b() {
    	driver.close();
    }
    


}
