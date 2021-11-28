package week3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2CreateAccounts extends BaseClass{

	@Test
	public void createAccounts() {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Accounts']")));
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//label[text()='Account Name']/following::div[1]/input")).sendKeys("Sreeja");
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[text()='Ownership']/following::div[1]//input")));
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebElement msg = driver.findElement(By.xpath("//span[text()[contains(.,'was created.')]]"));
		System.out.println("The account was created:"+msg.isDisplayed());

	}

}
