package com.qualitystream.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearchTest {
	
	private WebDriver driver;
	String strCapacities="*//div[@class='elementor-image-box-wrapper']//figure//a[@href='#capacidades']";
	String strHowDoWeDoIt="*//div[@class='elementor-image-box-wrapper']//figure//a[@href='#hacemos']";
	String strSolutionsPortfolio="*//div[@class='elementor-image-box-wrapper']//figure//a[@href='#portafolio']";
	By ServiciosLinkLocator = By.linkText("Servicios");

	@Before
	public void setUp() {
	   System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.choucairtesting.com/");
       
       }
	@Test
	public void ServiciosChoucairPage () throws InterruptedException {
		driver.findElement(ServiciosLinkLocator).click();
		Thread.sleep(500);
		enterCapacityModule();
		enterHowDoWeDoItModule();
		enterSolutionsPortfolioModule();

	}
	
	@After
	public void tearDown() throws Exception  {
		 driver.quit();
	}

	public void enterCapacityModule() throws InterruptedException{
		waitTime();
		posicionarElementoString(strCapacities);
		driver.findElement(By.xpath("*//div//a[contains(text(),'Capacidades')]")).click();

	}
	public void enterHowDoWeDoItModule() throws InterruptedException{
		waitTime();
		posicionarElementoString(strHowDoWeDoIt);
		waitTime();
		driver.findElement(By.xpath("*//div//a[contains(text(),'Cómo lo hacemos')]")).click();
	}
	public void enterSolutionsPortfolioModule() throws InterruptedException{
		waitTime();
		posicionarElementoString(strSolutionsPortfolio);
		waitTime();
		driver.findElement(By.xpath("*//div//a[contains(text(),'Portafolio de Soluciones')]")).click();
		waitTime();
	}
	public void waitTime()throws InterruptedException{
		Thread.sleep(5000);
	}


	public void posicionarElementoString(String Element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true); arguments[0].style.border='1px dashed red';",
				driver.findElements(By.xpath(Element)).get(0));
	}
}
 