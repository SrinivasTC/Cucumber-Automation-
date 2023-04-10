package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logindemo {
	
static WebDriver driver;
	
	@Given("open browser")
		public void open_browser() {
			
			System.out.println("Inside Step - browser is open");
			
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);
			
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
		
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			
		}
	
	@And("user navigates to login page")
		public void user_navigates_to_login_page() {
			
			driver.get("https://example.testproject.io/web/");
			
	}
	
	@When("^user entering (.*) and (.*)$")
	public void user_entering_username_and_password(String username, String password) throws InterruptedException  {
		
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		Thread.sleep(2000);
	}
		
	@And("user clicking on login")
	public void user_clicking_on_login() {
		
			driver.findElement(By.id("login")).click();	
	
	}
		@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
			
			driver.findElement(By.id("logout")).isDisplayed();
		
			Thread.sleep(2000);
		driver.close();
			driver.quit();
		
		}
}
