package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {
		FileReader fr = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(fr);

//		String br = p.getProperty("browser");
//		// chromeBrowser
//
//		switch(br.toLowerCase()) { 
//		  case "chrome": driver=new ChromeDriver(); break;
//		  case "edge": driver=new EdgeDriver();
//		  break;
//		  case "firefox": driver=new FirefoxDriver();break; 
//		  default :
//		  System.out.println("Invalidate browser");return; }
	}

	// public Logger log;

	@Given("Launch the Chrome browser")
	public void launch_the_chrome_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		log = LogManager.getLogger(this.getClass());
		log.info("***browser will lunch***");

	}

	@When("Enter the URL {string}")
	public void enter_the_url(String url) {
		log.info("****lunch the browser****");
		driver.get(url);

	}

	@When("Enter the username {string} and password {string}")
	public void enter_the_username_and_password(String name, String password) {
		lp=new LoginPage(driver);
		log.info("** Enter the logging detils***");
		lp.userdetails(name, password);
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
		log.info("** click on the log button***");

		lp.login();
	}

	@Then("Navigate to homepage with title {string}")
	public void navigate_to_homepage_with_title(String exp) {
		String actual = driver.getTitle();
		if (driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(exp, actual);
		}
	}

	@When("Click the logoff button")
	public void click_the_logoff_button() {
		lp.logout();
	}

	@Then("User is navigated to the login page with title {string}")
	public void user_is_navigated_to_the_login_page_with_title(String exp1) {
		String name = driver.getTitle();
		Assert.assertEquals(exp1, driver.getTitle());
	}

	@Then("Close the browser")
	public void close_the_browser() {
		driver.close();
	}

	// ........Adding new Customer deatils.....\\

	@When("click on scustomer menu")
	public void click_on_scustomer_menu() {
		cp = new CustomerPage(driver);
		cp.customermenu();

	}

	@When("click on customers")
	public void click_on_customers() {
		cp.customer();
	}

	@When("click on add new customer")
	public void click_on_add_new_customer() {
		cp.addnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
	}

	@When("usre enter the customer info")
	public void usre_enter_the_customer_info() {
		log.info("***Enter the detils***");
		cp.generaldetails("ram@gmail.com", "ram", "Ram", "krishna");
		cp.company("infoys");
		cp.Newsletter();
		cp.Customerroles("Guests");
		cp.Managerofvendor();

	}

	@When("click on save")
	public void click_on_save() {
		cp.save();
	}

	@Then("user can seen the {string}")
	public void user_can_seen_the(String n) {
		Assert.assertEquals(n, "The new customer has been added successfully.");
	}

	@Then("close browser;")
	public void close_browser() {
		// driver.close();
	}

	// search the customer by the mail id

	@Then("user should navigate to searchpage with title of\"Customers \\/ nopCommerce administration\"")
	public void user_should_navigate_to_searchpage_with_title_of_customers_nop_commerce_administration() {
		sp = new SearchCustomerPage(driver);
		log.info("***The search has staard***");
		Assert.assertEquals("Customers / nopCommerce administration", driver.getTitle());
	}

	@Then("customer enter mail_id")
	public void customer_enter_mail_id() {
		sp.mailid("l2odvssp@gmail.com");
	}

	@When("click on search button")
	public void click_on_search_button() {
		sp.search();
	}

	@Then("user should found mail_id in the search table")
	public void user_should_found_mail_id_in_the_search_table() {
		sp.table("l2odvssp@gmail.com");
	}

}
