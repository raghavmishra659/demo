package vtiger_crm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CRM_Project {

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
	
		driver.findElement(By.linkText("Organizations")).click();
	
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		String orgName = "qspider_" + (int)(Math.random()*9999);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);
	//	Thread.sleep(3000);
		String emp = "123"; //+ (int)(Math.random()*999);
		WebElement empField = driver.findElement(By.id("employees"));
		empField.sendKeys(emp);
		Thread.sleep(3000);
		WebElement industry = driver.findElement(By.name("industry"));
//		industry.click();
		Select select = new Select(industry);
		select.selectByValue("Engineering");
		
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
//		Verification
		
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully!!!");
		}else {
			System.out.println("Organization could not be created successfully!!!");
		}

	//	Thread.sleep(3000);
//		Logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		

	}

}
