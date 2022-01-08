package Practice;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateUser {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseURL = "https://opensource-demo.orangehrmlive.com";
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void test() {
		String userId = "Admin";
		String userPassword = "admin123";
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys(userId);
		
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys(userPassword);
		
		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
		
		WebElement adminLink = driver.findElement(By.id("menu_admin_viewAdminModule"));
		adminLink.click();
		
		WebElement addUserButton = driver.findElement(By.id("btnAdd"));
		addUserButton.click();
		
		String userType = "1";
		WebElement staticDropdown = driver.findElement(By.id("systemUser_userType"));
		Select dropdown1 = new Select(staticDropdown);
		dropdown1.selectByValue(userType);
		
		String employeeName = "Test Admin 2";
		String employeeUserName = "sysadmin";
		String employeePassword = "admin123";
		String employeeConfirmedPassword = "admin123";
		
		WebElement employeeNameTextBox = driver.findElement(By.id("systemUser_employeeName_empName"));
		employeeNameTextBox.sendKeys(employeeName);
		
		WebElement employeeUserNameTextBox = driver.findElement(By.id("systemUser_userName"));
		employeeUserNameTextBox.sendKeys(employeeUserName);
		
		WebElement employeePasswordTextBox = driver.findElement(By.id("systemUser_password"));
		employeePasswordTextBox.sendKeys(employeePassword);
		
		WebElement employeeConfirmedPasswordTextBox = driver.findElement(By.id("systemUser_confirmPassword"));
		employeeConfirmedPasswordTextBox.sendKeys(employeeConfirmedPassword);
		
		WebElement saveButton = driver.findElement(By.id("btnSave"));
		saveButton.click();
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
