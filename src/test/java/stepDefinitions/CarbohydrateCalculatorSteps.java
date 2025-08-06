package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

import static org.junit.Assert.*;

public class CarbohydrateCalculatorSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on the carbohydrate calculator page")
    public void i_am_on_the_calculator_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");
    }

    @When("I enter valid demographic data with age {string}")
    public void i_enter_valid_demographic_data(String age) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cage"))).clear();
        driver.findElement(By.id("cage")).sendKeys(age);

        driver.findElement(By.id("cheightmeter")).clear();
        driver.findElement(By.id("cheightmeter")).sendKeys("170");

        driver.findElement(By.id("ckg")).clear();
        driver.findElement(By.id("ckg")).sendKeys("65");

        driver.findElement(By.cssSelector("label[for='csex1']")).click(); // Male

        Select activity = new Select(driver.findElement(By.name("cactivity")));
        activity.selectByVisibleText("Moderate: exercise 4-5 times/week");
    }

    @When("I fill out the form with gender {string}, age {string}, height {string}, weight {string}, and activity {string}")
    public void i_fill_out_form(String gender, String age, String height, String weight, String activity) {
        if (gender.equalsIgnoreCase("Male")) {
            driver.findElement(By.cssSelector("label[for='csex1']")).click();
        } else {
            driver.findElement(By.cssSelector("label[for='csex2']")).click();
        }

        driver.findElement(By.id("cage")).clear();
        driver.findElement(By.id("cage")).sendKeys(age);

        driver.findElement(By.id("cheightmeter")).clear();
        driver.findElement(By.id("cheightmeter")).sendKeys(height);

        driver.findElement(By.id("ckg")).clear();
        driver.findElement(By.id("ckg")).sendKeys(weight);

        Select dropdown = new Select(driver.findElement(By.name("cactivity")));
        dropdown.selectByVisibleText(activity);
    }

    @When("I click the Calculate button")
    public void i_click_calculate_button() {
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();
    }

    @Then("I should see a carbohydrate result")
    public void i_should_see_carbohydrate_result() {
        WebElement resultBlock = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='h2result']"))
        );
        assertTrue("Result block should be displayed", resultBlock.isDisplayed());
        driver.quit();
    }

    @Given("I open the carbohydrate calculator in Chrome")
    public void i_open_calculator_in_chrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");
    }

    @Then("the page title should contain {string}")
    public void page_title_should_contain(String expectedTitle) {
        String title = driver.getTitle();
        assertTrue("Page title should contain expected text",
                title.toLowerCase().contains(expectedTitle.toLowerCase()));
        driver.quit();
    }
}
