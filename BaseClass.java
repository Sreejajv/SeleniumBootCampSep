package week3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;

@BeforeMethod
public void launchBrowserAndUrl() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver = new ChromeDriver(options);
	driver.get("https://login.salesforce.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("SelBootcamp$1234");
	driver.findElement(By.id("Login")).click();
}

@AfterMethod
public void closeBrowser() {
	driver.quit();
}
}
