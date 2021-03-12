package main.java.Selenium_Docker.Selenium_Docker;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ExecutionListener.class)
public class SampleTest {
	
	private WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		
	}

    @Test(description = "Google Search of Selenium")
    public void search(){
    	
    	driver.get("https://www.google.com/");
    	WebElement search = driver.findElement(By.name("q"));
    	search.sendKeys("Selenium");
    	search.sendKeys(Keys.ENTER);   	
   
    }

    @Test(description = "Search for flights- Making Trips")
    public void bookflight(){
    	
    	driver.get("https://www.makemytrip.com/");
    	System.out.println(driver.getTitle());

    }

   
    
    @AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}