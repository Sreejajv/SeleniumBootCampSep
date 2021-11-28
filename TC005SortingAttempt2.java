package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005SortingAttempt2 extends BaseClass{

	@Test
	public void sortingByName() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Accounts']")));
		Thread.sleep(6000);
		boolean nextElement = true;
		int i=0;
		ArrayList<String> accountNames = new ArrayList<String>();
		while (nextElement) {
			List<WebElement> list = driver.findElements(By.xpath("//span[text()='Account Name']/ancestor::table/tbody/tr["+(i+1)+"]/th//a"));
			System.out.println(i+":"+list.size());
			if(list.size()==0) {
				nextElement = false;
			}
			if (list.size()>0) {
			driver.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//span[text()='Account Name']/ancestor::table/tbody/tr["+(i+1)+"]/th//a")));
			accountNames.add(i,driver.findElement(By.xpath("//span[text()='Account Name']/ancestor::table/tbody/tr["+(i+1)+"]/th//a")).getText().toLowerCase());
			i=i+1;
		}
		}
		System.out.println("The size of list before Sorting is:"+accountNames.size());
		Collections.sort(accountNames);
		
		driver.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//span[text()='Account Name']/parent::a")));
		driver.findElement(By.xpath("//span[text()='Account Name']/parent::a")).click();
		Thread.sleep(6000);
		int j =0;
		ArrayList<String> sortedOutputList = new ArrayList<String>();
		boolean nextElementfromScreen = true;
		while (nextElementfromScreen) {
			List<WebElement> sortedList = driver.findElements(By.xpath("//span[text()='Account Name']/ancestor::table/tbody/tr["+(j+1)+"]/th//a"));
			if(sortedList.size()==0) {
				nextElementfromScreen = false;
			}
			if (sortedList.size()>0) {
			driver.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//span[text()='Account Name']/ancestor::table/tbody/tr["+(j+1)+"]/th//a")));
			sortedOutputList.add(driver.findElement(By.xpath("//span[text()='Account Name']/ancestor::table/tbody/tr["+(j+1)+"]/th//a")).getText());
			j=j+1;
		}
		}
		System.out.println("The Output List of Screen size is:"+sortedOutputList.size());
		
		boolean sorted = true;
		for(int k=0;k<sortedOutputList.size();k++) {
			if(!(accountNames.size()==sortedOutputList.size())){
				System.out.println("The size of list is not same.Before sorting the size was:"+accountNames.size()+"and after sorting, the size is:"+sortedOutputList.size());
				sorted=false;
				break;
			}
			if(!accountNames.get(k).equalsIgnoreCase(sortedOutputList.get(k))) {
				System.out.println(i+"accountNames"+accountNames.get(k)+"accountNamesAfterSort"+sortedOutputList.get(k));
				sorted=false;
				break;
			}
		}
		for (String sortedlist : accountNames) {
			System.out.print(sortedlist+";");
		}
		System.out.println("");
		System.out.println("From Screen");
		for (String sortedlist : sortedOutputList) {
			System.out.print(sortedlist+";");
		}
		System.out.println("");
		System.out.println("The Page is sorted by AccountName:"+sorted);

	}

}
