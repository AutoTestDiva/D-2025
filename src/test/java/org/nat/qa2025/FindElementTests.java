package org.nat.qa2025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        //max window
        driver.manage().window().maximize();
        //timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementTest() {
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

        driver.findElement(By.id("city"));
        driver.findElement(By.className("input-label"));
        driver.findElement(By.name("viewport"));
        driver.findElement(By.linkText("Let the car work"));
        driver.findElement(By.partialLinkText("work"));
    }
    @Test
    public void findElementByCssTest(){
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.cssSelector(".input-label"));
        driver.findElement(By.cssSelector("[name='viewport']"));
        driver.findElement(By.cssSelector("[class*='pristine']"));
        //^-start
        driver.findElement(By.cssSelector("[class^='ng']"));
        //end on $
        driver.findElement(By.cssSelector("[class$='input']"));
    }
    @Test
    public void findElementByXpathTest(){
        driver.findElement(By.xpath("//h1"));
        driver.findElement(By.xpath("//input[@id='city']"));
        driver.findElement(By.xpath("//label[@class='input-label']"));
        //text -> xpath //*[contains(.,'Type your data and hit Yalla!')]
        driver.findElement(By.xpath("//h2[contains(.,'Type your data and hit Yalla!')]"));
    //  //*[starts-with(@class,'sub')]
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
