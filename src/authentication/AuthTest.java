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

public class AuthTest {

	WebDriver driver = new EdgeDriver();
	String url = "https://automationexercise.com/"; // the web_site
	
	
	//String nameV = "Shefa'"; --> using a random
	//String emailAddressV="shifa@gmail.com"; --> using a random
	
	String passWordV = "Sh12345!!6";
	String dayV = "31";
	String monthV = "10";
	String yearV = "2002";
	
	//String fNameV = "Shefa'";
	String lNameV = "Al";
	String companyV = "ShCompany";
	String address1V = "45 Al-Rashid St, Amman";
	String countV = "Canada";
	String stateV = "SH";
	String cityV = "Amman";
	String codeV = "SH1";
	String mobileV = "077456789";
	
	Random rand = new Random(); // for using random data
	int randNumForEmail = rand.nextInt(5477110); 
	 
	//String emailAddressV = "shifaa"+randNumForEmail+"@gmail.com"; 
	
	String [] username = {"shefa'", "bayan","Sara", "Leen"};
	int randomUserIndex = rand.nextInt(username.length);
	
	String emailAddressV = username[randomUserIndex]+randNumForEmail+"@gmail.com"; 
	String nameV = username[randomUserIndex]; // use random username
	
	String fNameV = username[randomUserIndex];
	
	@BeforeTest
	public void mySetup()
	{ 
		
		driver.get(url); // open the webSite
		driver.manage().window().maximize();
		
		
		// That line tells Selenium to wait up to 3 seconds for elements to appear before giving an error:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
		
		
		 
	}
	 
	
	@Test(priority = 1)
	public void clickToMove() // moving for LogIn/SignUp page
	{
		WebElement signAndLog = driver.findElement(By.linkText("Signup / Login")); // <a> Element = link "anchor tag"
		signAndLog.click();
		
	}
	
	@Test(priority = 2) 
	public void signUp()
	{
		
		// WebElement nameFeild = driver.findElement(By.xpath("//input[@data-qa='signup-name']")); --> xPath locator in the correct way
		
		// by using cssSelector locator:
		WebElement nameFeild = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
    	nameFeild.sendKeys(nameV);
		
		WebElement emailAddress = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
		emailAddress.sendKeys(emailAddressV);
		
		
		WebElement signUpButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
		signUpButton.click();
		
		

	}
	
	@Test(priority = 3)
	public void signUpTitleInfo()
	{
		WebElement gender = driver.findElement(By.id("id_gender2"));
		gender.click();
		
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(passWordV);
		
		
		
		// Date of Birth: 
		
		WebElement day = driver.findElement(By.id("days"));
		day.sendKeys(dayV);
		
		WebElement month = driver.findElement(By.id("months"));
		month.sendKeys(monthV);
		
		WebElement year = driver.findElement(By.id("years"));
		year.sendKeys(yearV);

	}
	
	@Test(priority = 4)
	public void signUpAddressInfo()
	{
		WebElement fName = driver.findElement(By.id("first_name"));
		fName.sendKeys(fNameV);
		
		WebElement lName = driver.findElement(By.id("last_name"));
		lName.sendKeys(lNameV);
 		
		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys(companyV);
		
		WebElement address1 = driver.findElement(By.id("address1"));
		address1.sendKeys(address1V);
		
		WebElement count = driver.findElement(By.id("country"));
		count.sendKeys(countV);
		
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys(stateV);
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys(cityV);
		
		WebElement code = driver.findElement(By.id("zipcode"));
		code.sendKeys(codeV);
		
		WebElement mobile = driver.findElement(By.id("mobile_number"));
		mobile.sendKeys(mobileV);	
	}
	
	@Test(priority = 5) // account created 
	public void createProcess()
	{
	
	WebElement createBt = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
	createBt.click();
	
	WebElement continuButton = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
	continuButton.click();
	}
	
	@Test(priority = 6) // logout from your account
	public void logOut()
	{
		WebElement logOut = driver.findElement(By.cssSelector("a[href='/logout']"));
		logOut.click();
	}
	
	@Test(priority = 7) // logIn 
	public void logIn()
	{
		WebElement emailLog = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        emailLog.sendKeys(emailAddressV);
        
        WebElement passLog = driver.findElement(By.cssSelector("input[data-qa='login-password']"));
        passLog.sendKeys(passWordV);
        
        WebElement logInBt = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        logInBt.click();   
	}
	
	@Test(priority = 8) // delete your account - account deleted
	public void deleteAccount()
	{
		WebElement delete = driver.findElement(By.cssSelector("a[href='/delete_account']"));
		delete.click();   
		
		WebElement continuD = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
		continuD.click();   
		
	
	}
	@AfterTest
	public void myAfterTest()
	{
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
