package webSelenium.Suite2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
    @Test
    public void testSelenium4(){
        System.out.println("abdo");
    }
}
