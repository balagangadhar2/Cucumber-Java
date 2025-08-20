package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	public WebDriver driver;
	
	public SearchCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement mail_txt;
	@FindBy(xpath="//input[@id='SearchFirstName']")
	WebElement firsst_txt;
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement search_btn;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;

	
	public void mailid(String mail) {
		mail_txt.sendKeys(mail);
	}
	public void search() {
		search_btn.click();
	}
	public int getNoOfRows() {
		return (tableRows.size());
	}

	public int getNoOfColumns() {
		return (tableColumns.size());
	}
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	WebElement table;
	
	public boolean  table(String mail) {
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
					.getText();

					
			
			System.out.println(emailid);

			if (emailid.equals(mail)) {
				flag = true;
				break;
			}
		}

		return flag;

	}
	}
	


