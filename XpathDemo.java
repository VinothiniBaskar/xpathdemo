package string.methods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathDemo {
@Test
	public  void Login() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//parent to child
		//xpath of parent and child tag name
		driver.findElement(By.xpath("//p[@class='top']//input")).sendKeys("demosalesmanager");
		//Younger sibling
		//x path for elder and younger tag name
		driver.findElement(By.xpath("//label[@for='password']//following::input[1]")).sendKeys("crmsfa");
		
		//Grand parent to grand child
		//xpath of grand parent and grandchild tag name
		driver.findElement(By.xpath("//div[@id='form']//p[3]/input")).click();
		
		//child to parent 
		//xpath of child and parent::parent tagname
		String text = driver.findElement(By.xpath("//input[@class='decorativeSubmit']//parent::form")).getAttribute("id");
        System.out.println("Parent text value is :"+text);
        
        driver.navigate().back();
		driver.findElement(By.xpath("//p[@class='top']//input")).clear();
		driver.findElement(By.xpath("//label[@for='password']//following::input[1]")).clear();
		
        //Grand child to grandparent
        //xpath of grandchild -->ancestor::grandparent tag name
		String login = driver.findElement(By.xpath("//input[@id='username']//ancestor::form")).getAttribute("id");
		System.out.println("Grand parent text value is"+login);
		
        //younger to elder 
		//xpath of younger and preceding::elder tag name
		String text2 = driver.findElement(By.xpath("//input[@id='username']//preceding::label")).getText();
		System.out.println("elder tag text is "+text2);
		
		//find by elder cousin
		//xpath for younger cousin and preceding tag name 
		//uncle's daughter
	    driver.findElement(By.xpath("//input[@id='password']//preceding::input")).sendKeys("demosalesmanager");
	    
	    //find by younger
	    //xpath of elder and following younger tag name
	    driver.findElement(By.xpath("//label[@for='username']//following::input[2]")).sendKeys("crmsfa");
	    
	    driver.findElement(By.xpath("//div[@id='form']//p[3]//input")).click();
		
	}

}
