package prakhar.rathore;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prakhar.Abstractclasses.AbstractComponents;

public class CartSection extends AbstractComponents {

	WebDriver driver;

	public CartSection(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement check;

	@FindBy(css = ".cartSection h3")
	List<WebElement> productlist;

	public Boolean verifyproduct(String cartproduct) {
		Boolean cart = productlist.stream().anyMatch(product -> product.getText().equals(cartproduct));
		return cart;
	}

	public Checkout checkout() {
		check.click();
		Checkout out = new Checkout(driver);
		return out;
		
	}
}