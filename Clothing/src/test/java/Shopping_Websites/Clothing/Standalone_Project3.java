package Shopping_Websites.Clothing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import prakhar.rathore.CartSection;
import prakhar.rathore.Checkout;
import prakhar.rathore.Confirmation;
import prakhar.rathore.LandingPage;
import prakhar.rathore.ProductCatalogue;

public class Standalone_Project3 {

	public static void main(String[] args) throws InterruptedException {

		String cartproduct = "IPHONE 13 PRO";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage page = new LandingPage(driver);
		page.goTo();
		ProductCatalogue productcatalogue = page.credentials("singhprakhar302@gmail.com", "Pr@kh@r8756");
		List<WebElement> products = productcatalogue.cartlist();
		productcatalogue.productclick(cartproduct);
		CartSection section = productcatalogue.gotocart();
		Boolean cart1 = section.verifyproduct(cartproduct);
		Assert.assertTrue(cart1);
		Checkout out = section.checkout();
		out.cartpayment("India");
		Confirmation confirm = out.submitorder();
		String cmessage = confirm.verifymessage();
		Assert.assertTrue(cmessage.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}

}
