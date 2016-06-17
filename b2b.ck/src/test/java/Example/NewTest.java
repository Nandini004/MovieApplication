package Example;

import java.util.concurrent.TimeUnit;


import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {		
    private WebDriver driver;	
    StopWatch pageLoad = new StopWatch();

	private WebDriverWait wait;
			
	@Test (priority=0)
	public void login() throws InterruptedException {
		//User Login
		driver.findElement(By.id("ember314")).sendKeys("user_1@st.ciscoknowledgesuite-poc.com");
		driver.findElement(By.xpath("//button[text()='Next']")).click();

		driver.findElement(By.id("IDToken2")).sendKeys("Cisco@000");
		driver.findElement(By.id("Button1")).click();
		System.out.println("Logged in successfully");
	}
	@Test (priority=1)
	public void  HomePage() {
		// Home Page
		pageLoad.start();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@class,'spinner')]")));
		System.out.println("Spinner available");
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[contains(@class,'spinner')]")));
		System.out.println("Spinner not available");
		
		pageLoad.stop();
		System.out.println("Time taken to load home page : "+pageLoad.getTime()/1000.0+"seconds");
		pageLoad.reset();
	}

	
	
	@BeforeTest
	public void beforeTest() {	
	    driver = new FirefoxDriver();  
	    driver.get("http://st.ciscoknowledgesuite-poc.com");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    wait = new WebDriverWait(driver, 60);
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}		
}	