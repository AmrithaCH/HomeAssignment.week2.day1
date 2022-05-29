package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadHWAssn1 {

	public static void main(String[] args) {

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
		//Edit Lead
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		//cleardescription and fill important note
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("Imp Note");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		System.out.println(driver.getTitle());
		driver.close();


	}

}
