package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadHWAssn1 {

	public static void main(String[] args)
	{
		//setup chromedriver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//load the webpage url
		driver.get("http://leaftaps.com/opentaps/control/main");
		//maximise the window
		driver.manage().window().maximize();
		//login page
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		//CRM/SFA page
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Leads Page click
		driver.findElement(By.linkText("Leads")).click();
		//Create lead page click
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName' and @class='inputBox']")).sendKeys("Amr123");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName' and @class='inputBox']")).sendKeys("Sri123");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("AmrLocal");
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Amrdept");
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("Description is bigger");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("amr@gmail.com");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
		Select dd = new Select(dropdown);
		dd.selectByVisibleText("Alabama");
		//CreateLead
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		Assert.assertEquals("View Lead | opentaps CRM", title);
		driver.close();
	}
}
