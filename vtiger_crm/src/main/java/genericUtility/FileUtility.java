package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	 public	String getDataFromProperties(String key ) throws IOException{
			FileInputStream fis = new FileInputStream("D:\\java e\\vtiger_crm\\src\\test\\resources\\CommonData.properties");
			
			Properties pObj = new Properties();
			pObj.load(fis);
			
			String BROWSER = pObj.getProperty("bro");
			String URL = pObj.getProperty("url");
			String USERNAME = pObj.getProperty("un");
			String PASSWORD = pObj.getProperty("pwd");
			String value = pObj.getProperty(key);	
			return value;
		
		}
		getDataFromExcelFile(){
			
			
		}

	public static String main(String[] args) {

	}

}
