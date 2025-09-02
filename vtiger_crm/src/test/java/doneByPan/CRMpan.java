package doneByPan;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CRMpan {

	public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("D:\\java e\\vtiger_crm\\src\\test\\resources\\CommonData.properties");
	FileInputStream fis1 = new FileInputStream("D:\\java e\\vtiger_crm\\src\\test\\resources\\Vtiger.xlsx");
	
	Workbook wb=WorkbookFactory.create(fis1);
	Sheet sh=wb.getSheet("Raa1");
	int  MobNum = (int) sh.getRow(1).getCell(1).getNumericCellValue();
		
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");
		
//		System.out.println(BROWSER);
//		System.out.println(URL);
//		System.out.println(USERNAME);
//		System.out.println(PASSWORD);
		
		WebDriver driver = null;
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
	
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		String orgName = "qspider_" + (int)(Math.random()*9999);
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);
		WebElement num = driver.findElement(By.id("phone"));
		num.sendKeys(String.valueOf(MobNum));

	}

}
