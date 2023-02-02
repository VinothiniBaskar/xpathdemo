package servicenow.app;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// FindElement
		// It returns a web element object on a specific search criteria
		WebElement prime = driver.findElement(By.xpath("//span[text()='Prime']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(prime).perform();

		// FindElements
		// It returns the list of web elements on matching search criteria

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplusPro",Keys.ENTER);
		List<WebElement> oneplus=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		

				// create a for loop for getting the items and store it to the list

	
	          for (WebElement each : oneplus) {
	        	  String text = each.getText();
				System.out.println(text);
			}
		

	}
}
