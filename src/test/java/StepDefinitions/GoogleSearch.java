package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {
	static WebDriver driver;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("browser opened");
		String projectPath=System.getProperty("user.dir");
		System.out.println("project path is:"+projectPath);
		System.setProperty("webdriver.chrome.driver","C:\\\\drivers files\\\\chromedriver_win32\\\\chromedriver_win32\\\\chromedriver.exe");

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(opt);
	}
	

	@And("user is on google search page")
	public void user_is_on_google_search_page() {

		System.out.println("Inside Step - user is on goolge search page");

		driver.navigate().to("https://google.com");


	}
	@When("user enters text on google search page")
	public void user_enters_text_on_google_search_page() throws InterruptedException {
		System.out.println("Entered text displayed successfully");


		WebElement element=driver.findElement(By.name("q"));
		element.click();
		element.sendKeys("java with selenium automation");
		driver.manage().window().maximize();


		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		System.out.println("google search page opened");

		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Then("user navigated to search results page")
	public void user_navigated_to_search_results_page() {

		driver.getPageSource().contains("Online Courses");
		System.out.println("Inside Step - user is navigated to search results");
		
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[1]/div/a/h3")).click();


	}

}
