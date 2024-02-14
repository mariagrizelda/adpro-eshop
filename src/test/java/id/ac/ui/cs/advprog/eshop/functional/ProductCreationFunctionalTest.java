package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class giProductCreationFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String productCreationUrl;

    @BeforeEach
    void setUp() {
        productCreationUrl = String.format("%s:%d/product/create", testBaseUrl, serverPort);
    }

    @Test
    void testProductCreationSuccess(ChromeDriver driver) {
        String productName = "Sample Product";
        int productQuantity = 50;

        navigateToProductCreationPage(driver);

        fillProductCreationForm(driver, productName, productQuantity);

        submitProductCreationForm(driver);

        waitForProductListPage(driver);

        assertProductInList(driver, productName);
    }

    private void navigateToProductCreationPage(ChromeDriver driver) {
        driver.get(productCreationUrl);
    }

    private void fillProductCreationForm(ChromeDriver driver, String productName, int productQuantity) {
        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        productNameInput.clear();
        productNameInput.sendKeys(productName);

        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        productQuantityInput.clear();
        productQuantityInput.sendKeys(String.valueOf(productQuantity));
    }

    private void submitProductCreationForm(ChromeDriver driver) {
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
    }

    private void waitForProductListPage(ChromeDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Product List']")));
    }

    private void assertProductInList(ChromeDriver driver, String productName) {
        WebElement createdProduct = driver.findElement(By.xpath("//td[contains(text(), '" + productName + "')]"));
        assertEquals(productName, createdProduct.getText());
    }

    // Add more helper methods or test cases as needed
}
