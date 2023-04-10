package StepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Reusablemethod {
	static WebDriver driver;
	static WebElement dta;
	
	@Given("when user signed into amazon website")
	public void when_user_signed_into_amazon_website() {
	   
		System.setProperty("webdriver.chrome.driver","C:\\\\drivers files\\\\chromedriver_win32\\\\chromedriver_win32\\\\chromedriver.exe");

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);

		driver.get("https://www.amazon.in/");	
		driver.manage().window().maximize();
		
	   
	}

	@When("user serarch for products in search field")
	public void user_serarch_for_products_in_search_field() {
		
		driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click();
		WebElement username=driver.findElement(By.xpath("//*[@id='ap_email']"))	;
		username.click();
		username.sendKeys("7416371109");
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		WebElement password=driver.findElement(By.xpath("//*[@id='ap_password']"));
		password.click();
		password.sendKeys("Srinu6699@");
		driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
	    
	  
	}

	@Then("user navigated to the product display page")
	public void user_navigated_to_the_product_display_page() {
		
		 String productName="hp laptop";
		
		
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(productName);
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    
	}

	@When("user selects one product from products display page")
	public void user_selects_one_product_from_products_display_page() {
	    
		WebElement productLink = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-medium a-color-base a-text-normal']"));


		productLink.click();

	
	}

	@Then("user navigates to the selected product details page")
	public void user_navigates_to_the_selected_product_details_page() throws InterruptedException {
		
		Set<String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator(); // Iterate all windows 
		String p = it.next();
		String c= it.next();
		driver.switchTo().window(c);

		Thread.sleep(6000);
	   
	   
	}

	@When("user adds products to cart")
	public void user_adds_products_to_cart() {
		WebElement cartIcon = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
		cartIcon.click();
	    
	}

	@When("user navigates to the cart")
	public void user_navigates_to_the_cart() {
	    
		WebElement cart = driver.findElement(By.xpath("//*[@id='attach-sidesheet-view-cart-button']"));
        cart.click();	
}

	@When("user clicks on proceed button")
	public void user_clicks_on_proceed_button() throws InterruptedException {
		WebElement ptb=driver.findElement(By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input"));

		ptb.click();
		Thread.sleep(6000);

	   
	}

	@Then("user navigates to the delivert to this address page")
	public void user_navigates_to_the_delivert_to_this_address_page() throws InterruptedException {
	    
		WebElement dta=driver.findElement(By.xpath("//*[@id='shipToThisAddressButton']"));
		dta.click();
		Thread.sleep(5000);	 
	}

	@When("user clicks on deliver to this address button")
	public void user_clicks_on_deliver_to_this_address_button() {
		
		dta.click();
		
	}

	@Then("user navigated to the payment method page")
	public void user_navigated_to_the_payment_method_page() throws InterruptedException {
	
		WebElement ptm=driver.findElement(By.xpath("//input[@id='pp-UQJQgn-100']"));

		ptm.click();
		
		
	
	WebElement element2=driver.findElement(By.xpath("//span[contains(text(),'Choose an Option')]"));

	element2.click();
	driver.findElement(By.xpath("//a[@id='pp-UQJQgn-103_2']")).click();
	driver.findElement(By.xpath("//span[@class='a-button-inner']//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']"));
		
		driver.findElement(By.xpath("//*[@id='bottomSubmitOrderButtonId-announce']")).click();
		Thread.sleep(8000);
		WebElement elemnt23=driver.findElement(By.xpath("//*[@class='form-control text-muted']"));
		
		elemnt23.click();
		elemnt23.sendKeys("6584266");
		driver.findElement(By.xpath("//*[@class='btn btn-primary login-btn']")).click();

}}
