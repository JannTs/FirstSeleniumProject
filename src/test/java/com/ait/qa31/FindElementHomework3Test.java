package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementHomework3Test {
    WebDriver driver;



    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelector() {
        // by CSS selector
        System.out.println("Finding five elements by CSS selector:");
        System.out.println("===============================================");
        WebElement searchBox = driver.findElement(By.cssSelector("input[id='small-searchterms']"));
        System.out.println("Search box found: " + searchBox.getAttribute("outerHTML"));

        WebElement loginLink = driver.findElement(By.cssSelector("a.ico-login"));
        System.out.println("Login link found: " + loginLink.getAttribute("outerHTML"));

        WebElement registerLink = driver.findElement(By.cssSelector("a.ico-register"));
        System.out.println("Register link found: " + registerLink.getAttribute("outerHTML"));

        WebElement searchButton = driver.findElement(By.cssSelector("input.button-1.search-box-button[type='submit']"));
        System.out.println("Search button found: " + searchButton.getAttribute("outerHTML"));

        WebElement subscribeButton = driver.findElement(By.cssSelector("input.button-1.newsletter-subscribe-button[type='button']"));
        System.out.println("Subscribe button found: " + subscribeButton.getAttribute("outerHTML"));

        // Some web-elements from block named "POPULAR TAGS" from site   (By cssSelector)
        System.out.println("====================================================================");
        System.out.println("The remaining similar five elements found by CSS-selector");
        System.out.println("====================================================================");

        WebElement apparelLink = driver.findElement(By.cssSelector("a[href*='/producttag/'][href*='apparel']"));
        System.out.println(apparelLink.getAttribute("outerHTML"));

        WebElement awesomeLink = driver.findElement(By.cssSelector("a[href*='/producttag/'][href*='awesome']"));
        System.out.println(awesomeLink.getAttribute("outerHTML"));

        WebElement bookLink = driver.findElement(By.cssSelector("a[href*='/producttag/'][href*='book']"));
        System.out.println(bookLink.getAttribute("outerHTML"));

        WebElement cameraLink = driver.findElement(By.cssSelector("a[href*='/producttag/'][href*='camera']"));
        System.out.println(cameraLink.getAttribute("outerHTML"));

        WebElement cellLink = driver.findElement(By.cssSelector("a[href*='/producttag/'][href*='cell']"));
        System.out.println(cellLink.getAttribute("outerHTML"));



    }

    @Test
    public void findElementByXpath() {
        System.out.println("Finding elements by XPath:");
        System.out.println("===============================================");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Search box found: " + searchBox.getAttribute("outerHTML"));

        WebElement loginLink = driver.findElement(By.xpath("//a[@class='ico-login']"));
        System.out.println("Login link found: " + loginLink.getAttribute("outerHTML"));

        WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));
        System.out.println("Register link found: " + registerLink.getAttribute("outerHTML"));

        WebElement searchButton = driver.findElement(By.xpath(
                "//input[@class='button-1 search-box-button' and @type='submit']")
        );
        System.out.println("Search button found: " + searchButton.getAttribute("outerHTML"));

        WebElement subscribeButton = driver.findElement(By.xpath(
                "//input[@class='button-1 newsletter-subscribe-button' and @type='button']")
        );
        System.out.println("Subscribe button found: " + subscribeButton.getAttribute("outerHTML"));

        // Some web-elements from "POPULAR TAGS"-block from site   (By XPath)
        System.out.println("====================================================================");
        System.out.println("The same five remaining elements, but found by the XPath-selector.");
        System.out.println("====================================================================");
        WebElement apparelLink = driver.findElement(By.xpath("//a[text()='apparel']"));
        System.out.println(apparelLink.getAttribute("outerHTML"));
        highlightElement(apparelLink);
        WebElement awesomeLink = driver.findElement(By.xpath("//a[text()='awesome']"));
        highlightElement(awesomeLink);
        WebElement bookLink = driver.findElement(By.xpath("//a[text()='book']"));
        highlightElement(bookLink);
        WebElement cameraLink = driver.findElement(By.xpath("//a[text()='camera']"));
        highlightElement(cameraLink);
        WebElement cellLink = driver.findElement(By.xpath("//a[text()='cell']"));
        highlightElement(cellLink);

    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        js.executeScript("arguments[0].style.backgroundColor='yellow'", element);
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}