package genericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePageClass;
import objectRepository.LoginPageClass;

public class BaseClass {

	public ExcelFileUtility efu=new ExcelFileUtility();
	public PropertyFileUtility pfu=new PropertyFileUtility();
	public WebDriverUtility wdu=new WebDriverUtility();
	public JSONFileUtility jfu=new JSONFileUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
//	@BeforeSuite is used to create connection with Database
	@BeforeSuite (groups = {"smoke", "regression"})
	public void creConwithDataBase() {
		System.out.println("========== Creating Connection with DataBase===========");
	}
	
	@Parameters("Browser")
	@BeforeClass (groups = {"smoke", "regression"}) 
	public void openBrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		System.out.println("========== Openning Browser===========");
		String Browser = pfu.readDataFromPropertyFile("browser");
		if(Browser.equalsIgnoreCase("chrome")) {
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(co);
		}
		else {
			driver=new EdgeDriver();
		}
		
		wdu.maximizeWindow(driver);
		sdriver=driver;
		wdu.waitForPageLoad(driver);
	}
	
	@BeforeMethod (groups = {"smoke", "regression"})
	public void login() throws Throwable {
		System.out.println("========== Logging into the Application ============");
//		PropertyFileUtility pFU=new PropertyFileUtility();
		String uRL = pfu.readDataFromPropertyFile("url");
		String uN = pfu.readDataFromPropertyFile("username");
		String pwd = pfu.readDataFromPropertyFile("password");
		driver.get(uRL);
		LoginPageClass lpc=new LoginPageClass(driver);
		lpc.login(uN, pwd);
	}
	
	@AfterMethod (groups = {"smoke", "regression"})
	public void logout() throws Throwable {
		System.out.println("=========Logout from the Application===========");
		HomePageClass hpc=new HomePageClass(driver);
		hpc.logOut(driver);
	}
	
	@AfterClass (groups = {"smoke", "regression"})
	public void closeBroser() {
		System.out.println("============Browser hasbeen closed============");
		driver.close();
	}
	
	@AfterSuite (groups = {"smoke", "regression"})
	public void closeConnWithDB() {
		System.out.println("=========== Closing connection with DataBase ===========");
	}
}
