package authentication;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Invocations { // I create this class just for understand the way of ivnocationCount
	

	WebDriver driver = new EdgeDriver();
	String url = "https://automationexercise.com/"; 
	
	
	String signupUrl = "https://automationexercise.com/signup";
	String loginUrl = "https://automationexercise.com/login";
	
    String publicEmail;
	
	@BeforeTest
	public void setup() 
	{
		driver.get(url); 
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
		
	// instead InvocationCount, by using testng.xml file I repeat the test 3 times. through name of class inside the <test tag:	
	}
	
	@Test(priority =1 /*, invocationCount = 3*/)
	public void signup()
	{
		Random rand = new Random(); 
		int randNumForEmail = rand.nextInt(5477110); 
		
		String [] username = {"shefa'", "bayan","Sara", "Leen"};
		int randomUserIndex = rand.nextInt(username.length);
		
		String emailAddressV = username[randomUserIndex]+randNumForEmail+"@gmail.com"; 
		String nameV = username[randomUserIndex];

		publicEmail = emailAddressV;
		
		//===================================================================
		
		driver.navigate().to(signupUrl);
		
		WebElement nameFeild = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
    	nameFeild.sendKeys(nameV);
		
		WebElement emailAddress = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
		emailAddress.sendKeys(emailAddressV);
		
		
		WebElement signUpButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
		signUpButton.click();
		
		
	}
	
	@Test(priority = 2 /*, invocationCount = 3*/)
	public void login()
	{
		driver.navigate().to(loginUrl);
		   
		WebElement emailLog = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        emailLog.sendKeys(publicEmail);
        
         
	}
	
	@AfterTest
	public void cleanup()
	{
		
	}
}
