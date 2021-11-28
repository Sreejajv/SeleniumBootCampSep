package week3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.sun.tools.javac.parser.ReferenceParser.ParseException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006SortingbyCloseDateOppr extends BaseClass {

	@Test
	public void sortingByDate() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//span/p[text()='Sales']")).click();
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Opportunities']/parent::a")));
		//span[text()='Close Date']/ancestor::table/tbody/tr[17]/td[6]//span[@class='uiOutputDate']
		Thread.sleep(6000);
		boolean nextElement = true;
		int i=0;
		ArrayList<String> closeDates = new ArrayList();
		while(nextElement) {
			List<WebElement> lists = driver.findElements(By.xpath("//span[text()='Close Date']/ancestor::table/tbody/tr["+(i+1)+"]/td[6]//span[@class='uiOutputDate']"));
			if(lists.size()==0) {
				nextElement=false;
			}
			if(lists.size()>0) {
				driver.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[text()='Close Date']/ancestor::table/tbody/tr["+(i+1)+"]/td[6]//span[@class='uiOutputDate']")));
				closeDates.add(i, driver.findElement(By.xpath("//span[text()='Close Date']/ancestor::table/tbody/tr["+(i+1)+"]/td[6]//span[@class='uiOutputDate']")).getText());
				i=i+1;
			}
		}
		System.out.println("BeforeSorting:");
		for (String sortedlist : closeDates) {
			System.out.print(sortedlist+";");
		}
		Collections.sort(closeDates, new Comparator<String>() {

			public int compare(String string1, String string2) {
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date date1 = null;
				Date date2 = null;
				try {
					date1=format.parse(string1);
					//System.out.println(date1);
					date2=format.parse(string2);
					//System.out.println(date1);
				}
				 catch (java.text.ParseException e) {
					e.printStackTrace();
				}
				return date2.compareTo(date1);
			}});
		
		
		driver.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//span[text()='Close Date']/parent::a")));
		driver.findElement(By.xpath("//span[text()='Close Date']/parent::a")).click();
		
		Thread.sleep(6000);
		boolean sortedNextElement = true;
		int j=0;
		ArrayList<String> sortedCloseDates = new ArrayList();
		while(sortedNextElement) {
			List<WebElement> lists = driver.findElements(By.xpath("//span[text()='Close Date']/ancestor::table/tbody/tr["+(j+1)+"]/td[6]//span[@class='uiOutputDate']"));
			if(lists.size()==0) {
				sortedNextElement=false;
			}
			if(lists.size()>0) {
				driver.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[text()='Close Date']/ancestor::table/tbody/tr["+(j+1)+"]/td[6]//span[@class='uiOutputDate']")));
				sortedCloseDates.add(j, driver.findElement(By.xpath("//span[text()='Close Date']/ancestor::table/tbody/tr["+(j+1)+"]/td[6]//span[@class='uiOutputDate']")).getText());
				j=j+1;
			}
		}
		
		boolean sorted = true;
		if(!closeDates.equals(sortedCloseDates)) {
			sorted=false;
		}
		/*
		 * for(int k=0;k<sortedCloseDates.size();k++) {
		 * if(!(closeDates.size()==sortedCloseDates.size())){ System.out.
		 * println("The size of list is not same.Before sorting the size was:"
		 * +closeDates.size()+"and after sorting, the size is:"+sortedCloseDates.size())
		 * ; sorted=false; break; }
		 * if(!closeDates.get(k).equalsIgnoreCase(sortedCloseDates.get(k))) {
		 * System.out.println(i+"closeDates"+closeDates.get(k)+"sortedCloseDates"+
		 * sortedCloseDates.get(k)); sorted=false; break; } }
		 */
		System.out.println("");
		for (String sortedlist : closeDates) {
			System.out.print(sortedlist+";");
		}
		System.out.println("");
		System.out.println("From Screen");
		for (String sortedlist : sortedCloseDates) {
			System.out.print(sortedlist+";");
		}
		System.out.println("");
		System.out.println("The Page is sorted by AccountName:"+sorted);

	
	}
	

}
