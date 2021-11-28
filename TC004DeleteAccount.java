package week3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004DeleteAccount extends BaseClass{
	
	@Test
	public void deleteAccount() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Accounts']")));
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Sreeja"+Keys.RETURN);
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//a[text()='Sreeja']/ancestor::tr/td[6]//a")));
		Thread.sleep(3000);
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='Sreeja']/ancestor::tr/td[6]//a")));
		driver.findElement(By.xpath("//div[text()='Delete']/parent::a")).click();
		driver.findElement(By.xpath("//span[text()='Delete']/parent::button")).click();
		WebElement msg = driver.findElement(By.xpath("//span[text()[contains(.,'was deleted.')]]"));
		if (msg.isDisplayed()) {
			System.out.println("The Account was deleted");
		} else {
			System.out.println("Some error occured");
		}
	}

}
