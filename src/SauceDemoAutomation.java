import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SauceDemoAutomation {
    public static void main(String[] args) {
       
//    	System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Java & Selenium\\chromedriver_win32\\chromedriver.exe");
     
//        WebDriver driver = new ChromeDriver();\
        
        System.setProperty("webdriver.gecko.driver","D:\\Softwares\\Java & Selenium\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

       
        driver.get("https://www.saucedemo.com/");

      
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".btn_action"));

        usernameField.sendKeys(getCharSeqFromString("standard_user"));      
        passwordField.sendKeys(getCharSeqFromString("secret_sauce"));
        loginButton.click();

        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        sortDropdown.sendKeys(getCharSeqFromString("Price (low to high)"));

       
        WebElement addToCartButton;
        for (int i = 0; i < 3; i++) {

        	
            addToCartButton = driver.findElement(By.xpath("(//button[text()='Add to cart'])[" + (i + 1) + "]"));
          
           addToCartButton.click();
        }


        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        WebElement cartItem;
        WebElement cartItemPrice;
        WebElement removeButton;
        for (int i = 0; i < 2; i++) {
            cartItem = driver.findElement(By.xpath("(//div[@class='cart_item'])[" + (i + 1) + "]"));
            cartItemPrice = cartItem.findElement(By.className("inventory_item_price"));
            String price = cartItemPrice.getText().substring(1);

            if (Double.parseDouble(price) < 15) {
                removeButton = cartItem.findElement(By.className("cart_button"));
                removeButton.click();
            }
        }

 
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

     
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.id("continue"));

        firstNameField.sendKeys(getCharSeqFromString("John"));
        lastNameField.sendKeys(getCharSeqFromString("Doe"));
        postalCodeField.sendKeys(getCharSeqFromString("12345"));
        continueButton.click();

   
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

       
        WebElement logo = driver.findElement(By.className("app_logo"));
        logo.click();

        
        WebElement menuButton = driver.findElement(By.className("bm-burger-button"));
        menuButton.click();

        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        logoutLink.click();

        driver.quit();
    }
    
    public static CharSequence[] getCharSeqFromString(String input) {
    	CharSequence[] charSeq = new CharSequence[input.length()];
    	for (int i = 0; i < input.length(); i++) {
    		charSeq[i] = String.valueOf(input.toCharArray()[i]);
    	}
    	return charSeq;
    }
}
