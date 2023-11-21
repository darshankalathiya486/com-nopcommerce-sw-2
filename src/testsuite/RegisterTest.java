package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Verify Register link
 *  Select gender radio button
 *  Enter First name
 *  Enter Last name
 *  Select Day Month and Year
 *  Enter Email address
 *  Enter Password
 *  Enter Confirm password
 *  Click on REGISTER button
 *  Verify the text 'Your registration completed’
 */

public class RegisterTest extends BaseTest {

    // Declare baseUrl
    String baseUrl = "https://demo.nopcommerce.com/";

    // Open Browser
    @Before
    public void setUP(){
        openBrowser(baseUrl);
    }


    @Test
    //  Method name userShouldRegisterAccountSuccessfully
    public void  userShouldRegisterAccountSuccessfully(){

        // Find the Register link and click on Register link with className
        WebElement registerLink = driver.findElement(By.className("ico-register"));
        registerLink.click();

        // Find the gender radio button and select radio button with id
        WebElement genderRadioButton = driver.findElement(By.xpath("//input[starts-with(@id, 'gender-male')]"));
        genderRadioButton.click();

        // Find the First name field and enter the first name in field
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("Nikuj");

        // Find the Last name field and enter the last name in field
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys("Patel");

        // Find the Day in date of birth and select the Date in field
        WebElement daySelect = driver.findElement(By.name("DateOfBirthDay"));
        daySelect.sendKeys("23");

        // Find the Month in date of birth and select the month in field
        WebElement monthSelect = driver.findElement(By.name("DateOfBirthMonth"));
        monthSelect.sendKeys("05");

        // Find the year in date of birth and select the year in field
        WebElement yearSelect = driver.findElement(By.name("DateOfBirthYear"));
        yearSelect.sendKeys("1998");

        // Find the Email field and enter the email in field
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("lakili2727@marksia.com");

        // Find the Password field and enter the password in field
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Nikuj@123567");

        // Find the Confirm password field and enter the confirm password in field
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("Nikuj@123567");

        // Find the Register button and click the register button
        WebElement registerButton = driver.findElement(By.name("register-button"));
        registerButton.click();

        // Expected resul
        String expectedText = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.className("result"));
        String actualText = actualTextElement.getText();

        // Verify expected and actual text
        Assert.assertEquals(expectedText,actualText);
    }

    //Close browser
    @After
    public void tearDown(){
        closeBrowser();
    }
}
