package dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		username.sendKeys("admin");
		password.sendKeys("manager");
	
		driver.findElement(By.id("submitButton")).click();
	
		driver.findElement(By.linkText("Dashboard")).click();
		
		driver.findElement(By.name("dashordlists")).click();
		driver.findElement(By.cssSelector("option[value='leadsource']")).click();
	
		
//		Logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();

	}

}
