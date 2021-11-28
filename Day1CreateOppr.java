package week3;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1CreateOppr extends BaseClass {

	@Test
	public void createOppr() throws InterruptedException {
				
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Opportunities']/following::a[1]//*[name()='svg'][@class='slds-icon slds-icon-text-default slds-icon_xx-small']")).click();
		WebElement newOppr = driver.findElement(By.xpath("//span[text()='New Opportunity']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", newOppr);
		driver.findElement(By.xpath("//input[@name='Name']")).clear();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Sreeja");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("11/2/2021");
		WebElement dropopp = driver.findElement(By.xpath("//label[text()='Stage']/following::div[1]//input[@class='slds-input slds-combobox__input']"));
		executor.executeScript("arguments[0].click();", dropopp);
		driver.findElement(By.xpath("//span[text()='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement msg = driver.findElement(By.xpath("//span[text()[contains(.,'was created.')]]"));
		System.out.println(msg.isDisplayed());
		
		
		
		
	}

}
