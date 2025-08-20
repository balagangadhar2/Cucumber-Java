package stepDefinitions;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.CustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public CustomerPage cp;
	public SearchCustomerPage sp;
	public Logger log = LogManager.getLogger(Steps.class);
	public Properties p;



}
