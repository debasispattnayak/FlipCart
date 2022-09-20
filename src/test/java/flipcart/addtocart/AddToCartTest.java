package flipcart.addtocart;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCartTest {
	
	
	@Test
	public void addToCartTest01(){
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		driver.findElement(By.name("q")).sendKeys("winter heater");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement product = driver.findElement(By.xpath("//a[text()='DARSHANAM WORLD 220v 500w Portable Electric Heater Mini...']"));
		product.click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while(it.hasNext())
		{
			String windowid=it.next();
			String currentTitle=driver.switchTo().window(windowid).getTitle();
			if(currentTitle.contains("darshanam"))
				{
					break;
				}
		}
		String pname = driver.findElement(By.xpath("//span[@class='B_NuCI']")).getText();
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		String cname = driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
		Assert.assertEquals(pname,cname);
		driver.quit();
	}	
}
