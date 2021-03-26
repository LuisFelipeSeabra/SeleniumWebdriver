package br.df.lseabra.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;
	//Construtor
	private DriverFactory() {}

	public static WebDriver getDriver() {
		
		if(driver == null) {
			System.setProperty("webdriver.chrome.driver", "C:\\Automacao\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			driver.manage().window().maximize();
		}
		return driver;
	}
	public static void killDriver() {
		if(driver !=null) {
			driver.quit();
			driver = null;
			
		}
	}
	
}
