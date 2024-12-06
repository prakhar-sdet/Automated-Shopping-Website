package prakhar.Abstractclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import prakhar.rathore.CartSection;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;

	}
	
	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement click;

	public void waitforelement(By elf) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elf));
		Thread.sleep(2000);	}
	
	public void waitforelementinvisible(WebElement cartinvisible) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(cartinvisible));
		Thread.sleep(2000);
	}
	
	public CartSection gotocart() {
		click.click();
		CartSection section = new CartSection(driver);
		return section;
	}
}	

