import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class JeuTest {

	
	@BeforeSuite
	public void setup () throws InvalidFormatException, IOException{
	}

	@Test
	public void jeutest(){
		String mot = System.getProperty("str");
		assertEquals(mot, "OK");
		System.out.println("test1");
	}

	@Test
	public void test2 (){
		System.out.println("test2");
	}

	@Test
	public void test3 (){
		System.out.println("test3");
		String baseUrl = "http://newtours.demoaut.com/";
		String driverPath = "C:\\geckodriver.exe";
		WebDriver driver ; 
		System.out.println("launching firefox browser"); 
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\UFTFormation\\Downloads\\geckodriver-v0.15.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(baseUrl);
	}
/*
	@AfterSuite
	public void teardown(){

	}*/
}
