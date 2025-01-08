package test9;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestPunisher {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();

	String mywebsite = "https://www.saucedemo.com/";

	String UserName = "standard_user";
	String Password = "secret_sauce";

	@BeforeTest

	public void mySetub() {
		driver.get(mywebsite);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)

	public void login() {
		WebElement usernameinput = driver.findElement(By.id("user-name"));
		WebElement passwordinput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-button"));

		usernameinput.sendKeys(UserName);
		passwordinput.sendKeys(Password);
		loginButton.click();

	}

	@Test(priority = 2, enabled = false)
	public void AddToCartItem() {

		List<WebElement> AddToTheCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToTheCartButtons.size(); i++) {
			AddToTheCartButtons.get(i).click();
		}

	}

	@Test(priority = 3, enabled = false)

	public void Addcertainnumberofitems() {

		List<WebElement> AddToTheCartButtons = driver.findElements(By.className("btn"));
		for (int i = 0; i < AddToTheCartButtons.size(); i++) {

			if (i == 0 || i == 2) {
				continue;
			}
			AddToTheCartButtons.get(i).click();
		}

	}

	@Test(priority = 4, enabled = false)
	public void Additemsthestartwithsauce() {

		List<WebElement> itemsname = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AddToTheCartButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < itemsname.size(); i++) {

			if (itemsname.get(i).getText().startsWith("Sauce")) {
				AddToTheCartButtons.get(i).click();

			}
		}

	}

	@Test(priority = 5)
	public void addrandomitem() {
		List<WebElement> AddToTheCartButtons = driver.findElements(By.className("btn"));
		int randomindex = rand.nextInt(AddToTheCartButtons.size());
		System.out.println(randomindex);
		AddToTheCartButtons.get(randomindex).click();
	}

	@Test(priority = 6)
	public void CheckoutProcess() {

		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		ShoppingCart.click();

		WebElement Checkoutbutton = driver.findElement(By.id("checkout"));
		Checkoutbutton.click();
		// Array of first names

		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Edward" };

		int RandomFirstName = rand.nextInt(firstNames.length);

		// Array of last names
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };
		int RandomLastName = rand.nextInt(lastNames.length);

		String[] postalCodes = { "12345", "67890", "54321", "98765", "11223" };
		int RandomPostalCode = rand.nextInt(postalCodes.length);

		WebElement FirstnameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostCodeInput = driver.findElement(By.id("postal-code"));

		FirstnameInput.sendKeys(firstNames[RandomFirstName]);

		LastNameInput.sendKeys(lastNames[RandomLastName]);
		PostCodeInput.sendKeys(postalCodes[RandomPostalCode]);

		WebElement ContinueButton = driver.findElement(By.id("continue"));
		ContinueButton.click();
		WebElement FinishButton = driver.findElement(By.id("finish"));
		FinishButton.click();
	}

	@AfterTest

	public void AfterTheTest() {

	}

}
