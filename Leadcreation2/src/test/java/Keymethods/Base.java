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

		driver.get("https://qe.vakilsearch.com/");

		PageFactory.initElements(driver, LoginPageobjects.class);
		if (driver.getTitle() != "Online Legal Services for Startups & SMEs in India | Vakil Search") {
			screenshot.screenshot1(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date1 + "\\Screenshot1.png",
							"VakilSearchURL launched").build());

		} else {
			screenshot.screenshot1(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date1 + "\\Screenshot1.png",
							"VakilSearchURL").build());

		}

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@datainput='1']")));
		// Thread.sleep(2000);

	}

	public void GstFiling(WebDriver driver, String Username, String Mobilenumber, ExtentReports extentreport)
			throws IOException, InterruptedException, AWTException {
		test = extentreport.createTest("GSTReturnsFiling");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		HelpdeskPageobject.TaxCompliance.click();
		long start = System.currentTimeMillis();
		WebElement element3 = driver.findElement(By.xpath("//b[contains(text(),'GST Filing')]"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);
		screenshot.screenshot5(driver, extentreport);
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("MMddyyyy");
		String Date3 = dateFormat3.format(new Date());
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date3 + "\\Screenshot5.png",
						"Payment Cart PageTotal Time for page load " + totalTime + "ms").build());
		// HelpdeskPageobject.GSTRegistration.click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		if (LoginPageobjects.Email.isEnabled()) {

			test.log(Status.PASS, "Email Username clicked");
		} else {

			test.log(Status.FAIL, "Email Username notfound");
		}
		LoginPageobjects.Email.sendKeys("shakthi" + Date11 + "@yopmail.com");

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
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		Thread.sleep(2000);
		long start1 = System.currentTimeMillis();

		WebElement element3003 = driver.findElement(By.xpath("//button[@class='styles_actionBtn__xPQyU']"));
		JavascriptExecutor executor3003 = (JavascriptExecutor) driver;
		executor3003.executeScript("arguments[0].click();", element3003);

		System.out.println("succes1");

		long finish1 = System.currentTimeMillis();
		long totalTime1 = finish1 - start1;
		System.out.println("Total Time for page load - " + totalTime1);

		Thread.sleep(4500);

		driver.findElement(By.xpath("(//div[@class='nav-item'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='gpay']")).click();
		driver.findElement(By.xpath("//button[@id='btn-gpay']")).click();
		screenshot.screenshot10(driver, extentreport);
		SimpleDateFormat dateFormat4 = new SimpleDateFormat("MMddyyyy");
		String Date4 = dateFormat4.format(new Date());
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date4 + "\\Screenshot10.png",
						"Payment Cart PageTotal Time for page load " + totalTime1).build());
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
		Robot robot = new Robot();
		driver.get("https://vakilsearch.com/partners/meesho");
		test = extentreport.createTest("Meesho");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[1]")));

		driver.findElement(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[1]"))
				.sendKeys("shakthi" + Date11 + "@yopmail.com");
		driver.findElement(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='styles_input_wrap__VCQ5_']/child::input)[2]"))
				.sendKeys("9" + Date12);
		Thread.sleep(2000);
		WebElement element301 = driver
				.findElement(By.xpath("(//div[@class='styles_buttonWrapper__bjGeC']/child::button)[1]"));
		JavascriptExecutor executor301 = (JavascriptExecutor) driver;
		executor301.executeScript("arguments[0].click();", element301);
		// driver.findElement(By.xpath("(//div[@class='styles_buttonWrapper__bjGeC']/child::button)[1]")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//label[contains(text(),'No, I don’t have a company name')]")));

		LoginPageobjects.noidonthaveacompanyNameGSTRig.click();
		screenshot.screenshot49(driver, extentreport);
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMddyyyy");
		String Date2 = dateFormat2.format(new Date());
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date2 + "\\Screensho49.png",
						"Payment Cart PageTotal Time for page load ").build());
		Thread.sleep(2000);
		LoginPageobjects.Next.click();
		Thread.sleep(3000);

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
			long finish2 = System.currentTimeMillis();
			long totalTime2 = finish2 - start2;
			System.out.println("Total Time for page load - " + totalTime2);
			screenshot.screenshot10(driver, extentreport);
			SimpleDateFormat dateFormat4 = new SimpleDateFormat("MMddyyyy");
			String Date4 = dateFormat4.format(new Date());
			test.log(Status.PASS,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date4 + "\\Screenshot10.png",
							"Payment Cart PageTotal Time for page load " + totalTime2).build());
			driver.findElement(By.xpath("(//div[@class='nav-item'])[1]")).click();
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
			screenshot.screenshot10(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.PASS,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date1 + "\\Screenshot10.png",
							"Otp Validation / Payment Cart Page").build());
			System.out.println("MyIntrest1");
		}
		try {
			driver.switchTo().alert().accept();
		} catch (Exception Alert34) {
			System.out.println(Alert34);
		}
		Thread.sleep(3500);
	}

	public void TrademarkRegistration(WebDriver driver, String Username, String Mobilenumber,
			ExtentReports extentreport) throws InterruptedException, AWTException, IOException {
		test = extentreport.createTest("Trademark Registration");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		HelpdeskPageobject.TrademarkIP.click();

		long start = System.currentTimeMillis();
		WebElement element3 = driver.findElement(By.xpath("(//b[contains(text(),'Trademark Registration')])"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		System.out.println("Total Time for page load - " + totalTime);
		screenshot.screenshot7(driver, extentreport);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("MMddyyyy");
		String Date2 = dateFormat1.format(new Date());
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date2 + "\\Screenshot7.png",
						"Trademark Registration Time for page load " + totalTime + "ms").build());
		// HelpdeskPageobject.GSTRegistration.click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='service_form_primary_email']")));
		LoginPageobjects.Email.click();
		if (LoginPageobjects.Email.isEnabled()) {

			test.log(Status.PASS, "Email Username clicked");
		} else {

			test.log(Status.FAIL, "Email Username notfound");
		}
		LoginPageobjects.Email.sendKeys("shakthi" + Date11 + "@yopmail.com");

		LoginPageobjects.PhonenumberTrademarkIP.click();
		if (LoginPageobjects.PhonenumberTrademarkIP.isEnabled()) {

			test.log(Status.PASS, " Phonenumber field clicked");
		} else {

			test.log(Status.FAIL, "Phonenumber field notfound");
		}
		LoginPageobjects.PhonenumberTrademarkIP.sendKeys("9" + Date12);
		Thread.sleep(2000);
		LoginPageobjects.CityTrademark.click();
		LoginPageobjects.CityTrademark.sendKeys("chen");
		if (LoginPageobjects.CityTrademark.isEnabled()) {

			test.log(Status.PASS, "Select City clicked");
		} else {

			test.log(Status.FAIL, "Select City field notfound");
		}

		Thread.sleep(16000);
		WebElement findElement12 = driver.findElement(By.xpath("//div[contains(text(),'Chennai, Tamil Nadu')]"));
		wait.until(ExpectedConditions.elementToBeClickable(findElement12)).click();
		Robot robot = new Robot();

//		if (LoginPageobjects.whatsapptogleoff.isSelected()) {
//
//			test.log(Status.PASS, "whatsapptogle off");
//		} else {
//System.out.println("failed");
//			test.log(Status.FAIL, "whatsapptogleoff Failed");
//		}
		LoginPageobjects.toggleTrademark.click();
		Thread.sleep(2000);
		long start2 = System.currentTimeMillis();
		WebElement element501011 = driver.findElement(By.xpath("(//button[contains(text(),'Consult an Expert')])[1]"));
		JavascriptExecutor executor501011 = (JavascriptExecutor) driver;
		executor501011.executeScript("arguments[0].click();", element501011);
		// driver.findElement(By.xpath("(//button[contains(text(),'Consult an
		// Expert')])[1]")).click();
//System.out.println("succes1");

		long finish2 = System.currentTimeMillis();
		long totalTime2 = finish2 - start2;
		System.out.println("Total Time for page load - " + totalTime2);
		screenshot.screenshot8(driver, extentreport);
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("MMddyyyy");
		String Date3 = dateFormat2.format(new Date());
		test.log(Status.PASS,
				MediaEntityBuilder.createScreenCaptureFromPath(
						"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date3 + "\\Screenshot8.png",
						"After Consult an Expert Click page load " + totalTime2 + "ms").build());
		Thread.sleep(1500);

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='styles_content__g4N5_'])[4]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//p[contains(text(),'Next')]")).click();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
			long start3 = System.currentTimeMillis();
			driver.findElement(By.xpath("//div[@class='styles_btnCta__Vt6zM']")).click();
			long finish3 = System.currentTimeMillis();
			long totalTime3 = finish3 - start3;
			System.out.println("Total Time for page load - " + totalTime2);
			screenshot.screenshot9(driver, extentreport);
			SimpleDateFormat dateFormat4 = new SimpleDateFormat("MMddyyyy");
			String Date4 = dateFormat4.format(new Date());
			test.log(Status.PASS,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date4 + "\\Screenshot9.png",
							"Payment Cart Page  Time for load " + totalTime2 + "ms").build());

			driver.findElement(By.xpath("(//div[@class='nav-item'])[1]")).click();
			driver.findElement(By.xpath("//input[@id='gpay']")).click();
			driver.findElement(By.xpath("//button[@id='btn-gpay']")).click();

			try {

				driver.findElement(By.xpath("//i[@class='back']")).click();
				try {
					driver.switchTo().alert().accept();
				} catch (Exception Z) {
					System.out.println(Z);
				}
				// driver.findElement(By.xpath("//i[@class='back']")).click();
				driver.findElement(By.xpath("//button[contains(text(),'YES, CANCEL')]")).click();
				driver.switchTo().alert().accept();

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception MyIntrest1) {
			screenshot.screenshot9(driver, extentreport);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			String Date1 = dateFormat.format(new Date());
			test.log(Status.FAIL,
					MediaEntityBuilder.createScreenCaptureFromPath(
							"\\\\14.140.167.188\\Vakilsearch\\AutomatonLeadCreation2\\" + Date1 + "\\Screenshot9.png",
							"Payment Cart Page").build());
			System.out.println(MyIntrest1);
		}
		try {
			driver.switchTo().alert().accept();
		} catch (Exception Alert34) {
			System.out.println(Alert34);
		}
		Thread.sleep(4500);
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
			String ticket3 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[3]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 51);
			String ticket2 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[2]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 49);
			String ticket1 = driver
					.findElement(
							By.xpath("(//tr[@class='ticket_index_tr'])[1]//child::td/child::div/child::ul/child::li"))
					.getText().substring(0, 39);
			String ticket02 = "Need Help with : Goods & Service Tax Registration";
			String ticket03 = "Need Help with : Private Limited Company Registration";
			String ticket01 = "Need Help with : Trademark Registration";

			if (ticket3.contains(ticket03)) {

				test.log(Status.PASS, "Private Limited Company Registration lead verified");
			} else {
				test.log(Status.FAIL, "Private Limited Company Registration lead Failed");
			}

			if (ticket2.contains(ticket02)) {

				test.log(Status.PASS, "Need Help with : Goods & Service Tax Registration lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Goods & Service Tax Registration lead Failed");
			}

			if (ticket1.contains(ticket01)) {

				test.log(Status.PASS, "Need Help with : Trademark Registration lead verified");
			} else {
				test.log(Status.FAIL, "Need Help with : Trademark Registration lead Failed");
			}

		} catch (Exception Search) {
			System.out.println(Search);

		}
		// TODO Auto-generated method stub

	}

}
