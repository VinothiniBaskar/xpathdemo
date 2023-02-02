package servicenow.app;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.ginesys.in/?gclid=EAIaIQobChMI1_2jsLP2_AIV0H0rCh3Vow-1EAAYASAAEgKfs_D_BwE");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement product = driver.findElement(By.linkText("Products"));
		Actions builder=new Actions(driver);
		builder.moveToElement(product).perform();
		
		WebElement cloud = driver.findElement(By.linkText("Cloud POS"));
		builder.moveToElement(cloud).click().perform();
		
		WebElement connect = driver.findElement(By.xpath("//h2[@class='block-title']//span"));
		builder.scrollToElement(connect).perform();
		String text = connect.getText();

		System.out.println("The text of the element is :"+text);

		
	}
	
}
