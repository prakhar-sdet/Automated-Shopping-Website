package prakhar.rathore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prakhar.Abstractclasses.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By product1 = By.cssSelector(".mb-3");
	By product2 = By.cssSelector(".card-body button:last-of-type");
	By product3 = By.cssSelector("#toast-container");
//	By product4 = driver.findElement(By.cssSelector();

	@FindBy(css = ".card-body")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement abc;

	public List<WebElement> cartlist() throws InterruptedException {
		waitforelement(product1);
		return products;

	}

	public WebElement cartname(String cartproduct) {
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(cartproduct)).findFirst()
				.orElse(null);
		return prod;
	}

	public void productclick(String cartproduct) throws InterruptedException {
		WebElement prod = cartname(cartproduct);
		prod.findElement(product2).click();
		waitforelement(product3);
		waitforelementinvisible(abc);
		
	}
}
