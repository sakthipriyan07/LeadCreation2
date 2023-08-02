package Keymethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import PageFactory.HelpdeskPageobject;
import PageFactory.HomescreenPageobject;
import PageFactory.LoginPageobjects;

public class Base extends HelpdeskPageobject {

	ExtentTest test;

	ScreenShot screenshot = new ScreenShot();
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMddyyyyHHMMSS");
	String Date11 = dateFormat1.format(new Date());
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMyyMMSS");
	String Date12 = dateFormat2.format(new Date());

	public void Base1(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		test = extentreport.createTest("Vakilsearch Test");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		long startVK = System.currentTimeMillis();
		driver.get("https://vakilsearch.com/");
		long finishVK = System.currentTimeMillis();
		long totalTimeVK = finishVK - startVK;
		System.out.println("Total Time for page load - " + totalTimeVK);
		test.log(Status.PASS,"Vakilsearch Page Time for load " + totalTimeVK + "ms");
		PageFactory.initElements(driver, LoginPageobjects.class);
		

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@datainput='1']")));
		// Thread.sleep(2000);

	}

	public void GstFiling(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws IOException, InterruptedException, AWTException {
		SimpleDateFormat dateFormatGstFiling = new SimpleDateFormat("MMddyyMMS");
		String DateGstFiling = dateFormatGstFiling.format(new Date());
		test = extentreport.createTest("GSTReturnsFiling");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		HelpdeskPageobject.TaxCompliance.click();
		long start = System.currentTimeMillis();
		WebElement element3 = driver.findElement(By.xpath("//b[contains(text(),'GST Filing')]"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);
		test.log(Status.PASS,"Lead Creation " + totalTime + "ms");
		// HelpdeskPageobject.GSTRegistration.click();
		LoginPageobjects.Email.sendKeys("shakthi" + DateGstFiling + "@yopmail.com");

		WebElement findElement = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
		findElement.click();
		findElement.sendKeys("9789955331");

		Thread.sleep(2000);

		WebElement element3001 = driver.findElement(By.xpath("//input[@placeholder='City']"));
		JavascriptExecutor executor3001 = (JavascriptExecutor) driver;
		executor3001.executeScript("arguments[0].click();", element3001);

		element3001.sendKeys("chen");

		Thread.sleep(16000);
		WebElement element3002 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		JavascriptExecutor executor3002 = (JavascriptExecutor) driver;
		executor3002.executeScript("arguments[0].click();", element3002);
		Robot robot = new Robot();

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//      System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		Thread.sleep(2000);
		long start1 = System.currentTimeMillis();

		WebElement element3003 = driver.findElement(By.xpath("//button[@class='styles_actionBtn__xPQyU']"));
		JavascriptExecutor executor3003 = (JavascriptExecutor) driver;
		executor3003.executeScript("arguments[0].click();", element3003);

		
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='nav-item'])[1]")));
		driver.findElement(By.xpath("(//div[@class='nav-item'])[1]")).click();
		System.out.println("succes1");

		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		System.out.println("Total Time for page load - " + totalTime1);

		
		driver.findElement(By.xpath("//input[@id='gpay']")).click();
		driver.findElement(By.xpath("//button[@id='btn-gpay']")).click();
		
		test.log(Status.PASS,"Payment Cart PageTotal Time for page load " + totalTime1);
		Thread.sleep(3000);
		try {

			driver.findElement(By.xpath("//i[@class='back']")).click();
			driver.findElement(By.xpath("//button[contains(text(),'YES, CANCEL')]")).click();

		} catch (Exception e) {
			driver.switchTo().alert().accept();
			driver.findElement(By.xpath("//button[contains(text(),'YES, CANCEL')]")).click();
			System.out.println(e);
		}

		// driver.findElement(By.xpath("//button[contains(text(),'View
		// account')]")).click();

//		} catch (Exception MyIntrest1) {
//			screenshot.screenshot10(driver, extentreport);
//			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
//			String Date1 = dateFormat.format(new Date());
//			test.log(Status.PASS,
//					MediaEntityBuilder.createScreenCaptureFromPath(
//							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date1 + "\\Screenshot10.png",
//							"Otp Validation / Payment Cart Page").build());
//			System.out.println("MyIntrest1");
//		}
//		try {
//			driver.switchTo().alert().accept();
//		} catch (Exception Alert34) {
//			System.out.println(Alert34);
//		}
//		Thread.sleep(3500);
	}

	public void Meesho(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws InterruptedException, AWTException, IOException {
		SimpleDateFormat dateMeesho = new SimpleDateFormat("MMddyyMMS");
		String DateMeesho = dateMeesho.format(new Date());
		Robot robot = new Robot();
		long start21 = System.currentTimeMillis();
		driver.get("https://vakilsearch.com/partners/meesho");
		screenshot.screenshot46(driver, extentreport);
		test = extentreport.createTest("Meesho");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		long finish21 = System.currentTimeMillis();
		long totalTime21 = finish21 - start21;
		SimpleDateFormat dateFormat21 = new SimpleDateFormat("MMddyyyy");
		String Date21 = dateFormat21.format(new Date());
		
		test.log(Status.PASS,"Meesho Lead Creation "+totalTime21+"ms");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[1]")));

		driver.findElement(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[1]"))
				.sendKeys("shakthi" + DateMeesho + "@yopmail.com");
		driver.findElement(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[2]"))
				.sendKeys("9" + DateMeesho);
		Thread.sleep(2000);
		WebElement element301 = driver
				.findElement(By.xpath("(//div[@class='styles_buttonWrapper__bjGeC']/child::button)[1]"));
		JavascriptExecutor executor301 = (JavascriptExecutor) driver;
		executor301.executeScript("arguments[0].click();", element301);
		// driver.findElement(By.xpath("(//div[@class='styles_buttonWrapper__bjGeC']/child::button)[1]")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//label[contains(text(),'No, I don’t have a company name')]")));

		LoginPageobjects.noidonthaveacompanyNameGSTRig.click();
		
		
		Thread.sleep(2000);
		LoginPageobjects.Next.click();
		
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='mantine-Input-wrapper mantine-Select-wrapper mantine-12sbrde']/child::input")));
		driver.findElement(
				By.xpath("//div[@class='mantine-Input-wrapper mantine-Select-wrapper mantine-12sbrde']/child::input"))
				.click();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		LoginPageobjects.Next.click();

//			Thread.sleep(2000);
//			LoginPageobjects.Ageofbusiness.click();
//			robot.keyPress(KeyEvent.VK_DOWN);
//			robot.keyRelease(KeyEvent.VK_DOWN);
//
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//			Thread.sleep(3000);
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//input[@class='styles_otpInput__5bXLj']")).click();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_DELETE);
			robot.keyRelease(KeyEvent.VK_DELETE);
			driver.findElement(By.xpath("//input[@class='styles_otpInput__5bXLj']")).sendKeys("9789955331");
			driver.findElement(By.xpath("//button[contains(text(),'Send OTP')]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[1]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[2]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[3]"))
					.sendKeys("0");
			driver.findElement(By.xpath("(//div[@class='styles_boxes__yq8YR false false']/child::input)[4]"))
					.sendKeys("0");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//p[contains(text(),'Next')]")).click();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
			long start2 = System.currentTimeMillis();
			WebElement element39 = driver.findElement(By.xpath("//div[@class='styles_btnContainer__Rl3WA']"));
			JavascriptExecutor executor39 = (JavascriptExecutor) driver;
			executor39.executeScript("arguments[0].click();", element39);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//div[@class='nav-item'])[1]")));
			driver.findElement(By.xpath("(//div[@class='nav-item'])[1]")).click();
			
			long finish2 = System.currentTimeMillis();
			long totalTime2 = finish2 - start2;
			System.out.println("Total Time for page load - " + totalTime2);
			
			test.log(Status.PASS,"Payment Cart Page " + totalTime2+"ms");
			
			driver.findElement(By.xpath("//input[@id='gpay']")).click();
			driver.findElement(By.xpath("//button[@id='btn-gpay']")).click();
			Thread.sleep(3000);
			try {

				driver.findElement(By.xpath("//i[@class='back']")).click();

				try {
					driver.switchTo().alert().accept();
				} catch (Exception Z) {
					System.out.println(Z);
				}
				driver.findElement(By.xpath("//i[@class='back']")).click();

			} catch (Exception e) {
				System.out.println(e);
			}
			driver.findElement(By.xpath("//button[contains(text(),'YES, CANCEL')]")).click();
			// driver.findElement(By.xpath("//button[contains(text(),'View
			// account')]")).click();

		} catch (Exception MyIntrest1) {
			
			test.log(Status.PASS,"Otp Validation / Payment Cart Page");
			System.out.println("MyIntrest1");
		}
		try {
			driver.switchTo().alert().accept();
		} catch (Exception Alert34) {
			System.out.println(Alert34);
		}
		Thread.sleep(3500);
	}

	

	public void helpdesk(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport,
			String Helpdeskuserid, String helpdeskpassword) throws InterruptedException {
		test = extentreport.createTest("HelpDesk lead Verification Result");
		driver.get("https://helpdesk.vakilsearch.com/login");

		Thread.sleep(10000);
		Username1.sendKeys(Helpdeskuserid);
		String text1 = Username1.getText();
		String text2 = "testingsa_2_2020@vakilsearch.com";
		System.out.println(text1);
//		if (text1.contains(text2)) {
//			test.log(Status.PASS, "Yes");
//		} else {
//
//			test.log(Status.FAIL, "Username Not same");
//		}

		Password.sendKeys(helpdeskpassword);
		Signin.click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Helpdesk.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Tickets.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(8000);
		try {
			WebElement element501011 = driver.findElement(By.xpath("//input[@id='search']"));
			JavascriptExecutor executor501011 = (JavascriptExecutor) driver;
			executor501011.executeScript("arguments[0].click();", element501011);
			element501011.sendKeys("9789955331");
			driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
			
			String ticket2 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[2]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 27);
			String ticket1 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[1]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 48);
			String ticket02 = "Need Help with : GST Filings";
			String ticket01 = "Need Help with : Goods & Service Tax Registration";

			if (ticket02.contains(ticket2)) {

				test.log(Status.PASS, "Need Help with : GST Filings lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : GST Filings lead Failed");
			}

			if (ticket01.contains(ticket1)) {

				test.log(Status.PASS, "Need Help with : Goods & Service Tax Registration verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Goods & Service Tax Registration Failed");
			}

		} catch (Exception Search) {
			System.out.println(Search);

		}
		// TODO Auto-generated method stub

	}

}
