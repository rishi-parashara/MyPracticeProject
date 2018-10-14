package script;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.Utility;

public class KeywordDriver {
	static{	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	}
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com");
		
		for(int i=1; i<=4; i++) {
			String k1 = Utility.getKeyword("LoginTest01", i, 0);
			String k2 = Utility.getKeyword("LoginTest01", i, 1);
			String k3 = Utility.getKeyword("LoginTest01", i, 2);
			
			String xp = Utility.getProperty(k2);
//			System.out.println(k1);
//			System.out.println(k2);
//			System.out.println(k3);
			
			if(k1.equals("enter")) {
				driver.findElement(By.xpath(xp)).sendKeys(k3);
				System.out.println("Successfully entered " + k3 + " on " + k2);
			}else if(k1.equals("click")) {
				driver.findElement(By.xpath(xp)).click();
				System.out.println("Successfully clicked on " + k2);
			}
			else {
				System.out.println("No keywords...");
			}
			
		}
		driver.close();
	}
}
