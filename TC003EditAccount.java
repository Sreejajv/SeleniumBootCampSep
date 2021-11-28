package week3;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003EditAccount extends BaseClass{

	@Test
	public void editAccounts() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Accounts']")));
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Sreeja"+Keys.RETURN);
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//a[text()='Sreeja']/ancestor::tr/td[6]//a")));
		Thread.sleep(5000);
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Sreeja']/ancestor::tr/td[6]//a")));
		driver.findElement(By.xpath("//div[text()='Edit']/parent::a")).click();
		driver.findElement(By.xpath("//label[text()='Type']/following::div[1]//input")).click();
		driver.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//span[text()='Technology Partner']")));
		driver.findElement(By.xpath("//span[text()='Technology Partner']")).click();
		driver.findElement(By.xpath("//label[text()='Industry']/following::div[1]//input")).click();
		driver.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//span[text()='Healthcare']")));
		driver.findElement(By.xpath("//span[text()='Healthcare']")).click();
		driver.findElement(By.xpath("//label[text()='Billing Street']/following::div/textarea")).sendKeys("Billing Street");
		driver.findElement(By.xpath("//label[text()='Shipping Street']/following::div/textarea")).sendKeys("Shipping Street");
		driver.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//label[text()='Customer Priority']/following::div[1]//input")));
		driver.findElement(By.xpath("//label[text()='Customer Priority']/following::div[1]//input")).click();
		driver.findElement(By.xpath("//span[text()='Low']")).click();
		driver.findElement(By.xpath("//label[text()='SLA']/following::div[1]//input")).click();
		driver.findElement(By.xpath("//span[text()='Silver']")).click();
		driver.findElement(By.xpath("//label[text()='Active']/following::div[1]//input")).click();
		driver.findElement(By.xpath("//span[text()='No']")).click();
		String enteredPhone = "088888888";
		driver.findElement(By.xpath("//label[text()='Phone']/following-sibling::div/input")).sendKeys(enteredPhone);
		driver.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following-sibling::div//input")));
		driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following-sibling::div//input")).click();
		driver.findElement(By.xpath("//label[text()='Upsell Opportunity']/following-sibling::div//span[text()='No']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(3000);
		String phoneNumber = driver.findElement(By.xpath("//a[text()='Sreeja']/ancestor::tr/td[4]/span/span")).getText();
		if(enteredPhone.equalsIgnoreCase(phoneNumber)) {
			System.out.println("The entered Phone number is successfully Verified:"+enteredPhone);
		}
		System.out.println(enteredPhone);
		System.out.println(phoneNumber);
	}

}
