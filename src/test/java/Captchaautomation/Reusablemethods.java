package Captchaautomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;





public class Reusablemethods {


	// TODO Auto-generated method stub



	static WebDriver driver; // it can be used anywhere 
	private static TimeUnit SECONDS;

	public static void main(String[] args) throws Exception {
		
		
		initializeDriver();
		login();
		searchProduct("hp laptop");
		selectProduct("hp laptop for office use");
		windowshandle();
		addToCart();
		navigateToCart();
		prcoeedbutton();
		delivertothisaddress();
	
		
		paymentmethod();

		String cartTotal = getCartTotal();
		System.out.println("Cart total: " + cartTotal);

	}


	private static void initializeDriver() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\\\drivers files\\\\chromedriver_win32\\\\chromedriver_win32\\\\chromedriver.exe");

		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);

		driver.get("https://www.amazon.in/");	
		driver.manage().window().maximize();


	}
	
	


	public static void login() {

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
	public static void searchProduct(String productName) {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(productName);
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}


	public static void selectProduct(String productText) {
		WebElement productLink = driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-medium a-color-base a-text-normal']"));


		productLink.click();


	}

	public static void windowshandle() throws InterruptedException {

		Set<String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator(); // Iterate all windows 
		String p = it.next();
		String c= it.next();
		driver.switchTo().window(c);

		Thread.sleep(6000);

	}

	public static void addToCart() {



		WebElement addToCartButton =  driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
		addToCartButton.click();
	}


	public static void navigateToCart() {
		WebElement cartIcon = driver.findElement(By.xpath("//*[@id='attach-sidesheet-view-cart-button']"));
		cartIcon.click();
		
	}


	public static String getCartTotal() {
		WebElement cartTotal = driver.findElement(By.xpath("//*[@id='sc-subtotal-label-buybox']"));
		return cartTotal.getText();
	
		
	}

	public static void prcoeedbutton() throws InterruptedException {
		
		

		WebElement ptb=driver.findElement(By.xpath("//*[@id='sc-buy-box-ptc-button']/span/input"));
		

		ptb.click();
		Thread.sleep(6000);
		

	}


	

	 public static void delivertothisaddress() throws InterruptedException {

		WebElement dta=driver.findElement(By.xpath("//*[@id='shipToThisAddressButton']"));
		dta.click();
		Thread.sleep(8000);	
	   }


	
	
	

	public static void paymentmethod() throws InterruptedException {
		
		
		
		driver.findElement(By.id("pp-eAEdUu-98")).click();
		
		driver.findElement(By.cssSelector("#pp-eAEdUu-102 .a-dropdown-prompt")).click();
		driver.findElement(By.id("pp-eAEdUu-101_2")).click();
		
		driver.findElement(By.cssSelector("#orderSummaryPrimaryActionBtn .a-button-input")).click();
		
		WebElement element = driver.findElement(By.cssSelector("#orderSummaryPrimaryActionBtn .a-button-input"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	      
	      WebElement element1 = driver.findElement(By.tagName("body"));
	      Actions builder1 = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	      
	      WebElement element3 = driver.findElement(By.cssSelector("#gcApplyButtonId .a-button-input"));
	      Actions builder3 = new Actions(driver);
	      builder.moveToElement(element).perform();
	      
	      WebElement elemen4 = driver.findElement(By.tagName("body"));
	      Actions builder4 = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	      
	      driver.findElement(By.name("placeYourOrder1")).click();
	      
	      driver.switchTo().frame(0);
	      
	      driver.findElement(By.name("fldLoginUserId")).sendKeys("158445375");
	      
	      driver.findElement(By.linkText("CONTINUE")).click();
		

		
	
		
	}

}




