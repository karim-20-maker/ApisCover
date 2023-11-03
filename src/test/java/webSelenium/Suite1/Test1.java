package webSelenium.Suite1;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Test1 {

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
        System.out.println("karim");
    }
}
