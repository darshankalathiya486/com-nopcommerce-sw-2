package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1. Verify the text ‘Welcome, Please Sign In!’ with userShouldNavigateToLoginPageSuccessfully method name.
 * 2. userShouldLoginSuccessfullyWithValidCredentials
 *             * click on the ‘Login’ link
 *             * Enter valid username
 *             * Enter valid password
 *             * Click on ‘LOGIN’ button
 *             * Verify the ‘Log out’ text is display
 * 3. verifyTheErrorMessage
 *             * click on the ‘Login’ link
 *             * Enter invalid username
 *             * Enter invalid password
 *             * Click on Login button
 *             * Verify the error message ‘Login was unsuccessful.
 *                  Please correct the errors and try again. No customer account found’
 */

public class LoginTest extends BaseTest {

    // Declare baseUrl
    String baseUrl = "https://demo.nopcommerce.com/";

    // Open Browser
    @Before
    public void setUP(){
        openBrowser(baseUrl);
    }


    @Test
    // Method name userShouldNavigateToLoginPageSuccessfully
    public void userShouldNavigateToLoginPageSuccessfully(){

        // Find the login link and click on login link with className
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        // Expected result
        String expectedText = "Welcome, Please Sign In!";

        // Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//div/h1"));
        String actualText = actualTextElement.getText();

        // Verify expected and actual text
        Assert.assertEquals("Not redirected to login page", expectedText, actualText);
    }

    @Test
    // Method name userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Find the login link and click on login link with className
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        // Find the Username field and enter the valid username in the filed
        WebElement userName = driver.findElement(By.className("email"));
        userName.sendKeys("lakili2727@marksia.com");

        // Find the password field and enter the valid password in the field
        WebElement passwordEnter = driver.findElement(By.className("password"));
        passwordEnter.sendKeys("Nikuj@123567");

        //Find the Login button and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class= 'button-1 login-button']"));
        loginButton.click();

        // Expected resul
        String expectedText = "Log out";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[@class='ico-logout']"));
        String actualText = actualTextElement.getText();

        // Verify expected and actual text
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    // Method name verifyTheErrorMessage
    public void verifyTheErrorMessage(){

        // Find the login link and click on login link with className
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();

        // Find the Username field and enter the valid username in the filed
        WebElement userName = driver.findElement(By.className("email"));
        userName.sendKeys("lakili275745@marksia.com");

        // Find the password field and enter the valid password in the field
        WebElement passwordEnter = driver.findElement(By.className("password"));
        passwordEnter.sendKeys("Nikuj@123587");

        //Find the Login button and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class= 'button-1 login-button']"));
        loginButton.click();

        // Expected result
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        // Find the errorMessage element and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error message not displayed",expectedErrorMessage, actualErrorMessage);
    }


    @After
    public void tearDown(){
        closeBrowser();
    }

}
