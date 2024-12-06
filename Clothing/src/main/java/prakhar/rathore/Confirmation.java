package prakhar.rathore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prakhar.Abstractclasses.AbstractComponents;

public class Confirmation extends AbstractComponents {

	WebDriver driver;
	public Confirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmtext;
	
	public String verifymessage() {
		String message = confirmtext.getText();
		return message;
	}
	

}
