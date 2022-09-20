package flipcart.addtocart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedmiPhone {
	
	@Test
	public void RedmiPhoneTest02() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		driver.findElement(By.name("q")).sendKeys("redmi");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM')]/../../../div[1]"));
		for(WebElement ele:list)
		{
			Reporter.log(ele.getText(),true);
		}
		driver.quit();
	}

}
