package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CustomerPage;
import pageObject.LoginPage;

public class Steps {
	public WebDriver driver;
	public LoginPage lp;
	public CustomerPage cp;
	
	@Given("Launch the Chrome browser")
	public void launch_the_chrome_browser() {
	     driver=new ChromeDriver();
	     lp=new LoginPage(driver);
	     driver.manage().window().maximize();
	}

	@When("Enter the URL {string}")
	public void enter_the_url(String url) {
		driver.get(url);
	     
	}

	@When("Enter the username {string} and password {string}")
	public void enter_the_username_and_password(String name, String password) {
	    lp.userdetails(name, password);
	}

	@When("Click on the login button")
	public void click_on_the_login_button() {
	     lp.login();
	}

	@Then("Navigate to homepage with title {string}")
	public void navigate_to_homepage_with_title(String exp) {
	     String actual=driver.getTitle();
	     if(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")) {
	    	 driver.close();
	    	 Assert.assertTrue(false);
	     }else {
	    	 Assert.assertEquals(exp, actual);
	     }
	}

	@When("Click the logoff button")
	public void click_the_logoff_button() {
	     lp.logout();
	}

	@Then("User is navigated to the login page with title {string}")
	public void user_is_navigated_to_the_login_page_with_title(String exp1) {
	    String name= driver.getTitle();
	    Assert.assertEquals(exp1,driver.getTitle());
	}

	@Then("Close the browser")
	public void close_the_browser() {
	     driver.close();
	}
	
	
	//........Adding new Customer deatils.....\\
	
	
	@When("click on scustomer menu")
	public void click_on_scustomer_menu() {
		cp=new CustomerPage(driver);
		cp.customermenu();

	}

	@When("click on customers")
	public void click_on_customers() {
	     cp.customer();	}

	@When("click on add new customer")
	public void click_on_add_new_customer() {
		cp.addnew();
	     	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	     Assert.assertEquals("Add a new customer / nopCommerce administration",driver.getTitle());
	}

	@When("usre enter the customer info")
	public void usre_enter_the_customer_info() {
	     cp.generaldetails("ram@gmail.com",  "ram", "Ram", "krishna");
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
	public void user_can_seen_the(String  n) {
		Assert.assertEquals(n, "The new customer has been added successfully.");
	     	}

	@Then("close browser;")
	public void close_browser() {
		//driver.close();
	     	}



}
