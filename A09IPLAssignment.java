package com.MyAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A09IPLAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.iplt20.com/points-table/men/2024");
	    
	    List<WebElement>teams = driver.findElements(By.xpath("//*[@id=\"pointsdata\"]/tr/td[3]/div/h2"));
	    for(int i = 0; i < teams.size();i++)
	    {
	    	int n = 0, w = 0, l = 0;
	    	System.out.print(driver.findElement(By.xpath("//*[@id=\"pointsdata\"]/tr["+(i+1)+"]/td[3]/div/h2")).getText());
	    	System.out.print("\t");
	    	List<WebElement>result = driver.findElements(By.xpath("//*[@id=\"pointsdata\"]/tr["+(i+1)+"]/td[12]/div/span"));
	    	for(WebElement r : result)
	    	{
	    		System.out.print(r.getText());
	    		if(r.getText().equals("N"))
	    			n++;
	    		else if(r.getText().equals("W"))
	    			w++;
	    		else if(r.getText().equals("L"))
	    			l++;
	    	}
	    	
	    	System.out.println("\tN: " + n + " W: " + w + " L " + l);
	    		
	    	
	    	System.out.println("------------------------------------------------------");
	    }
	    
	    //List<WebElement> result = driver.findElements(By.xpath("//*[@id=\"pointsdata\"]/tr/td[12]/div/span"));
	    //for(WebElement r : result)
	    	//System.out.println(r.getText());
	    
	    driver.close();
	}

}
