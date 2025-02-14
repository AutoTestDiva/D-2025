package org.nat.qa2025;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {
    WebDriver driver;
@BeforeMethod
    public void setUp(){
    driver = new ChromeDriver();
    //driver.get("https://www.google.com/");
    driver.navigate().to("https://www.google.com/");
}
@Test
    public void openGoogleTest(){
    System.out.println("Site opened");
}
@AfterMethod
    public void tearDown(){
    driver.quit();
    //driver.close();
}

}
