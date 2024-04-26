package stepDefinations;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

public class LoginSteps {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Initialize the driver
        wait = new WebDriverWait(driver, 20); // WebDriverWait with a timeout of 10 seconds
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%3F&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    }

    @When("the user enters a valid username")
    public void the_user_enters_a_valid_username() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
        emailField.sendKeys("enter you prime email adrress");
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
    }

    @And("the user enters their password")
    public void the_user_enters_their_password() {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        passwordField.sendKeys("enter prime password");
    }

    @And("the user clicks the sign in button")
    public void the_user_clicks_the_sign_in_button() {
        WebElement signInSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signInSubmit")));
        signInSubmitButton.click();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        wait.until(ExpectedConditions.urlContains("www.amazon.com"));
        assertTrue(driver.getCurrentUrl().contains("www.amazon.com"));
    }

    @And("a welcome message should be displayed")
    public void a_welcome_message_should_be_displayed() {
        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
        assertTrue(welcomeMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser and release resources
        }
    }
}
