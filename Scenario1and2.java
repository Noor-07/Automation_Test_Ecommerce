package packageEcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Scenario1 {
	WebDriver driver;
 @BeforeClass
 public void launchBrowser() {
	 System.setProperty("webdriver.chrome.driver", "F:\\Alvee\\Selenium\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
 }
 @Test(priority = 1)
	public void startApp() throws InterruptedException {
	 	driver.get("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		String currentURL=driver.getCurrentUrl();
		Assert.isTrue(currentURL.contains("http://automationpractice.com/index.php"), currentURL, null);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)","");      //scroll down 700 pixel
		
}
 @Test (priority = 2, description = "Mike will click product and click plus button")
 public void clickproduct() throws InterruptedException {
	 Thread.sleep(1000);
	 driver.findElement(By.className("blockbestsellers")).click(); //Mike selects the category "Bestseller"
	 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[1]/ul[2]/li[1]/div/div[2]/h5/a\r\n"
	 		+ "")).click();                                 //Click a product
	 JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 js1.executeScript("window.scrollBy(0,400)","");
	  driver.findElement(By.className("icon-plus")).click(); //clicking the + icon
 }
 @Test (priority = 3, description = "Mike will Select size")
 public void selectsize() {
	 WebElement element = driver.findElement(By.id("group_1"));
	 Select sel = new Select(element);
	   sel.selectByVisibleText("L");
	   WebElement firstEle = sel.getFirstSelectedOption();
	   System.out.println("First element = "+firstEle.getText());    //it will print the product size
 }
 @Test (priority = 4, description = "Mike click this product add to cart")
 public void addtocart() throws InterruptedException {
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div/p/button/span\r\n"
	 		+ "")).click();
	 Thread.sleep(3000);
 }
 @Test (priority = 5, description = "Verify if the product is in cart")
 public void verifycart() throws InterruptedException {
	 String text1 = "There are 2 items in your cart.";
	 String text2 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/h2\r\n"
	 		+ "")).getText();
	 System.out.println(text2);
	 if (text1.contains(text2)) {
		 System.out.println("Test case Passed");
	 }
	 else {
		 System.out.println("Test case Failed");
	 }
	 Thread.sleep(8000);
	 driver.navigate().to("http://automationpractice.com/index.php");
 }
 
 
 //Scenario 2
 
 @Test (priority = 6, description = "Mike will click cart icon and click checkout button")
 public void checkout() throws InterruptedException {
	 WebElement cart=driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[3]/div/a/b"));
		Actions act = new Actions(driver);
		
		act.moveToElement(cart).perform();  //it will hover over cart icon
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[3]/div/div/div/div/p[2]/a/span\r\n"
				+ "")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span\r\n"
				+ "")).click();
		
 }
 @Test (priority = 7, description = "Mike will fill up the billing details")
 public void billingdetails() throws InterruptedException {
	 
	 driver.findElement(By.id("email_create")).sendKeys("lkm112io@gmail.com");
	 
	 driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span\r\n"
	 		+ "")).click();
	 Thread.sleep(15000);
	 
	 driver.findElement(By.xpath("//*[@id=\"id_gender1\"]\r\n"
	 		+ "")).click();
	 driver.findElement(By.name("customer_firstname")).sendKeys("Shamsul");
	 driver.findElement(By.name("customer_lastname")).sendKeys("Arefin");
	 driver.findElement(By.id("passwd")).sendKeys("111-222");
	 //day
	Select date = new Select(driver.findElement(By.name("days")));
	date.selectByIndex(12);
	//month
	Select month = new Select(driver.findElement(By.name("months")));
	month.selectByIndex(6);
	//year
	Select year = new Select(driver.findElement(By.name("years")));
	year.selectByValue("1994");
	//address
	driver.findElement(By.xpath("//*[@id=\"company\"]\r\n"
			+ "")).sendKeys("xyz");                     //company
	driver.findElement(By.xpath("//*[@id=\"address1\"]\r\n"
			+ "")).sendKeys("abc");                     //address
	driver.findElement(By.xpath("//*[@id=\"city\"]\r\n"
			+ "")).sendKeys("Dhaka");                   //city
	Select state = new Select(driver.findElement(By.name("id_state")));
	state.selectByIndex(12);                            //state
	driver.findElement(By.xpath("//*[@id=\"postcode\"]\r\n"
			+ "")).sendKeys("12345");                   //postcode
	
	driver.findElement(By.id("phone_mobile")).sendKeys("01312312312");
	
	driver.findElement(By.xpath("//*[@id=\"alias\"]\r\n"
			+ "")).sendKeys("xyz");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"submitAccount\"]\r\n"
			+ "")).click();
	
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span\r\n"
			+ "")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"cgv\"]\r\n"
			+ "")).click();
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span\r\n"
			+ "")).click();
	
 }
 
 @Test (priority = 8, description = "Payment")
	public void payment() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span\r\n"
				+ "")).click();
		
	}
 }

