package com.ait.qa31;
/**
 *
 * В проекте FirstSeleniumProject создайте,
 * пожалуйста, родительский класс TestBase и его
 * наследник CreateAccountTests с позитивным
 * методом регистрации на сайте
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class CreateAccountTests extends TestBase {
    @Test
    public void createNewAccountPositiveTest() {
        var registerLink = driver.findElement(By.cssSelector("[href='/register']"));
        highlightElement(registerLink);
        driver.findElement(By.cssSelector("[href='/register']")).click();
//      driver.findElement(By.cssSelector("[for='FirstName']")).click();
        driver.findElement(By.cssSelector("[name='FirstName']")).clear();
        driver.findElement(By.cssSelector("[name='FirstName']")).sendKeys("Evgenii");
        driver.findElement(By.cssSelector("[name='LastName']")).clear();
        driver.findElement(By.cssSelector("[name='LastName']")).sendKeys("Tsapko");
        driver.findElement(By.cssSelector("[name='Email']")).clear();
        driver.findElement(By.cssSelector("[name='Email']")).sendKeys(EMAIL);
        driver.findElement(By.cssSelector("[name='Password']")).clear();
        driver.findElement(By.cssSelector("[name='Password']")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("[name='ConfirmPassword']")).clear();
        driver.findElement(By.cssSelector("[name='ConfirmPassword']")).sendKeys(PASSWORD);


        driver.findElement(By.name("register-button")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/login']")));
// second part of test
        var loginLink = driver.findElement(By.cssSelector("[href='/login']"));
        highlightElement(loginLink);
        loginLink.click();
// autofocus
        driver.findElement(By.cssSelector("[name='Email']")).clear();
        driver.findElement(By.cssSelector("[name='Email']")).sendKeys(EMAIL);
        driver.findElement(By.cssSelector("[name='Password']")).clear();
        driver.findElement(By.cssSelector("[name='Password']")).sendKeys(PASSWORD);
        WebElement loginButton = driver.findElement(By.cssSelector("[value='Log in']"));
        highlightElement(loginButton);
        logInToAccountPositiveTest(loginButton);
    }
    public void logInToAccountPositiveTest(WebElement login) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            login.submit();
        var customerLink = driver.findElement(By.cssSelector("[href='/customer/info']"));
        highlightElement(customerLink);
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='"+EMAIL+"']")));
    }
}
