package prakhar.rathore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prakhar.Abstractclasses.AbstractComponents;

public class Checkout extends AbstractComponents {

	WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectcountry;

	@FindBy(css = ".action__submit")
	WebElement submit;

	By listwait = By.cssSelector(".list-group");

	public void cartpayment(String countryname) throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryname).build().perform();
		waitforelement(listwait);
		selectcountry.click();

	}
	
	public Confirmation submitorder() {
		submit.click();
		Confirmation confirm = new Confirmation(driver);
		return confirm;
	}

}
