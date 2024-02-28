package Cucumber.Steps;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import Project_POM.CarPOM;
import Project_POM.HomePOM;
import Project_POM.LoanCal1;
import Project_POM.LoanCal2;
import Project_POM.LoanCal3;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionRegression {
	static WebDriver driver;
	static CarPOM lp;
	HomePOM Hl;
	LoanCal1 lc1;
	LoanCal2 lc2;
	LoanCal3 lc3;
	int intValue;

	@Given("User selects car loan in the application")
	public void user_selects_car_loan_in_the_application() throws IOException {
		driver = Hooks.driver;
		lp = new CarPOM(driver);
		lp.CarClick();
		Assert.assertEquals(lp.checkHeading(), "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");

	}

	@When("Users enters the values to compute the emi")
	public void users_enters_the_values_to_compute_the_emi() {
		lp.Loan_Amount();
		lp.Loan_Interest();
		lp.Loan_Tenure();

	}

	@Then("The Emi is displayed is compared with the computed one")
	public void the_emi_is_displayed_is_compared_with_the_computed_one() {

		lp.scroll();
		lp.EmiCalculation();
	}

	@Given("The user navigates to the Home Loan page")
	public void the_user_navigates_to_the_home_loan_page() throws InterruptedException {
		Thread.sleep(5500);
		lp.Menu_Click();

	}

	@When("The user enters the values")
	public void the_user_enters_the_values() throws IOException {
		Hl = new HomePOM(driver);
		Hl.Home_Loan_Set();

	}

	@When("Emi is calculated")
	public void emi_is_calculated() {

		boolean status = Hl.EMI.isDisplayed();
		Hl.Scroll1();
		Assert.assertEquals(status, true);
	}

	@When("Year on year table is displayed is saved in an excel")
	public void year_on_year_table_is_displayed_is_saved_in_an_excel() throws IOException, InterruptedException {

		boolean status = Hl.Table.isDisplayed();
		Hl.scroll2();
		Assert.assertEquals(status, true);
		Thread.sleep(5000);
		Hl.WriteTable();

	}

	@Given("The user navigates to Loan page")
	public void the_user_navigates_to_loan_page() throws IOException {
		lc1 = new LoanCal1(driver);
		lc1.LoanCalClick();

	}

	@Then("User do all the neccessary UI Functionality")
	public void user_do_all_the_neccessary_ui_functionality() throws InterruptedException {
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

	}

	@Then("User selects Loan amount calculator to do all the neccessary UI Functionality")
	public void user_selects_loan_amount_calculator_to_do_all_the_neccessary_ui_functionality()
			throws InterruptedException, IOException {
		lc2 = new LoanCal2(driver);
		lc2.LoanCal2Click();
		lc2.emi();
		lc2.UI_Check2();

	}

	@Then("User selects Loan Tenure Calculator to do all the neccessary UI Functionality")
	public void user_selects_loan_tenure_calculator_to_do_all_the_neccessary_ui_functionality()
			throws InterruptedException, IOException {
		lc3 = new LoanCal3(driver);
		lc3.LoanCal3Click();
		lc3.UI_Check3();
		// driver.quit();

	}

	@Given("Car loan page is clicked")
	public void car_loan_page_is_clicked() throws IOException {
		driver = Hooks.driver;
		lp = new CarPOM(driver);
		lp.CarClick();
		System.out.println("Smoke testing for car loan funtionality is passed");
		System.out.println();
	}

	@Given("Home Loan page is clicked")
	public void home_loan_page_is_clicked() {
		lp.Menu_Click();
		System.out.println("Smoke testing for loan loan funtionality is passed");
		System.out.println();
	}

	@Given("Emi calaculator page is clicked")
	public void emi_calaculator_page_is_clicked() throws IOException {
		lc1 = new LoanCal1(driver);
		lc1.LoanCalClick();
		System.out.println("Smoke testing for EMI calculator page funtionality is passed");
		System.out.println();
	}

	@Given("Loan Amount calculator page is clicked")
	public void loan_amount_calculator_page_is_clicked() throws IOException {
		lc2 = new LoanCal2(driver);
		lc2.LoanCal2Click();
		System.out.println("Smoke testing for Loan Amount calculator page funtionality is passed");
		System.out.println();
	}

	@Then("Loan Tenure calculator page is clicked")
	public void loan_tenure_calculator_page_is_clicked() throws IOException {
		lc3 = new LoanCal3(driver);
		lc3.LoanCal3Click();
		System.out.println("Smoke testing for Loan Tenure calculator page funtionality is passed");
	}

}
