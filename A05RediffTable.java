package com.MyAssignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A05RediffTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		List<WebElement>currentPrice = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
		double[]cpArray = new double[currentPrice.size()];
		
		for(int i = 0; i < currentPrice.size(); i++)
		{
			String p = currentPrice.get(i).getText();
			p = p.replace(",", "");
			cpArray[i] = Double.parseDouble(p);
		}
		Arrays.sort(cpArray);
		
		System.out.println("Highest Price: " + cpArray[cpArray.length-1]);
		
		driver.close();
	}

}
