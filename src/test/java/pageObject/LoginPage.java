package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email_btn;
	@FindBy(xpath="//input[@id='Password']")
	WebElement password_btn;
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement login_btn;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout_btn;
	
	public void userdetails(String name,String pass) {
		email_btn.clear();
		email_btn.sendKeys(name);
		password_btn.clear();

		password_btn.sendKeys(pass);
	}
	public void login() {
		login_btn.click();
	}
	public void logout() {
		logout_btn.click();
	}

}
