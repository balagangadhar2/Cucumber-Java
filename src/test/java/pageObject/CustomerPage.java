package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
	
	public WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//p[normalize-space()='Customers']//i[contains(@class,'right fas fa-angle-left')]")
	WebElement customer_btn;
	@FindBy(xpath="//a[@href='/Admin/Customer/List']")
	WebElement customer_list;
	@FindBy(xpath="//a[normalize-space()='Add new']")
	WebElement add_btn;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email_txt;
	@FindBy(xpath="//input[@id='Password']")
	WebElement password_txt;
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement first_txt;
	@FindBy(xpath="//input[@id='LastName']")
	WebElement last_txt;
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement male_btn;
	@FindBy(xpath="//input[@id='Company']")
	WebElement company_txt;
	@FindBy(xpath="//input[@id='IsTaxExempt']")
	WebElement tax_txt;
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/span/span[1]/span/ul/li/input")
	WebElement Newsletter_txt;
	@FindBy(xpath="//li[text()='nopCommerce admin demo store']")
	WebElement nop_txt;
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/span/span[1]/span/ul/li/input")
	WebElement customerRole_txt;
	@FindBy(xpath="//ul[@id='select2-SelectedCustomerRoleIds-results']//li")
	List<WebElement> list_txt;
	@FindBy(xpath="//select[@id='VendorId']")
	WebElement vedor_txt;///list 
	@FindBy(xpath="//input[@id='MustChangePassword']")
	WebElement change_btn;
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement admin_txt;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement save_btn;
	
	
	
	public void customermenu() {
		customer_btn.click();
	}
	public void customer() {
		//.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", customer_list);


	}
	public void addnew() {
		add_btn.click();
	}
	
	public void generaldetails(String email,String password,String first,String last) {
		email_txt.sendKeys(email);
		password_txt.sendKeys(password);
		first_txt.sendKeys(first);
		last_txt.sendKeys(last);
		male_btn.click();
	}
	public void company(String company) {
		company_txt.sendKeys(company);
		tax_txt.click();
	}
	public void Newsletter() {
		Newsletter_txt.click();
		nop_txt.click();
	}
	public void Customerroles( String name) {
		customerRole_txt.clear();
		customerRole_txt.click();
		for(int i=0;i<list_txt.size();i++) {
			String names=list_txt.get(i).getText();
			if(names.equals(name)) {
				list_txt.get(i).click();
			}
		}
	}
	public void Managerofvendor() {
		Select n= new Select(vedor_txt);
		n.selectByIndex(1);
		change_btn.click();
		admin_txt.sendKeys("NA");
	}

	public void save() {
		save_btn.click();
	}

}
