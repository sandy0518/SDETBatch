package genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation extends BaseClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
//		Execution Starts from Here
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"------> Test Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"----> PASSED");
		Reporter.log(methodName+"------> TestScript Execution Successfull");
	}

	public void onTestFailure(ITestResult result) {
		String CurrentDate = new Date().toString().replace(":", "_").replace(" ", "_");
		String FailedTestScript = result.getMethod().getMethodName();
		String FailedScript = FailedTestScript+CurrentDate;
		EventFiringWebDriver ef=new EventFiringWebDriver(sdriver);
		File srcImg = ef.getScreenshotAs(OutputType.FILE);
		File destImg = new File("./ErrorShot/"+FailedScript+".png");
		try {
			FileUtils.copyFile(srcImg, destImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(FailedScript);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("Test Execution Failed");
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"----> skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("TestScript Execution Skipped");
	}

	public void onStart(ITestContext context) {
//		Create html Report
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("SDET BATCH");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", "https://localhost:8888");
		report.setSystemInfo("Reporter Name", "K Sai Sandeep");
	}

	public void onFinish(ITestContext context) {
//		Consolidate the Report
		report.flush();
	}

}
