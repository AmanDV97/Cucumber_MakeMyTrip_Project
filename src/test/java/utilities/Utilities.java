package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	Properties properties;
	public String path;
	FileInputStream fin;
	
	public String getBrowserInfo(){
		path = System.getProperty("user.dir");
		System.out.println("Direct:"+path);
		try {
			fin = new FileInputStream(path+"//src//test//java//utilities//utils.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		properties = new Properties();
		try {
			properties.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(properties.getProperty("Browser"));
		return properties.getProperty("Browser");
	}
	
	public String getUrl() {
		try {
			properties.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties.getProperty("Url");
	}
	
	public void screenShot(WebDriver driver, int count) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dsn = new File(path+"//target//screenshot//screenshot"+count+".png");
		try {
			FileUtils.copyFile(src, dsn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
