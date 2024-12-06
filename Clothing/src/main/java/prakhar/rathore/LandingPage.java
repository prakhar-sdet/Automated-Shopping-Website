package prakhar.rathore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prakhar.Abstractclasses.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement name;
	// WebElement name = driver.findElement(By.id());

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement login;

	public ProductCatalogue credentials(String name1, String pasword) {
		name.sendKeys(name1);
		password.sendKeys(pasword);
		login.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}