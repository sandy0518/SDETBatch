package sampleScripts;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibrary.BaseClass;

public class AllLinks extends BaseClass{

	@Test
	public void allLinks() {
		List<WebElement> listOfAllLinks = driver.findElements(By.xpath("//a"));
		List<String> listOfLinks=new ArrayList<String>();
		List<String> BrokenLinks=new ArrayList<String>();
		for(WebElement webElement:listOfAllLinks) {
			String link = webElement.getAttribute("href");
			if(link!=null) {
				if(link.contains("http")) {
					listOfLinks.add(link);
				}
				else {
					BrokenLinks.add(link+" ===> Not Having HTTP Protocol");
				}
			}
			else {
				BrokenLinks.add(link+" ===> Null");
			}
		}
		for(String links:listOfLinks) {
			try {
				URL url=new URL(links);
				URLConnection urlCon = url.openConnection();
				HttpURLConnection httpUrlCon = (HttpURLConnection)urlCon;
				int statusCode = httpUrlCon.getResponseCode();
				String responseMsg = httpUrlCon.getResponseMessage();
				if(statusCode>=400) {
					System.out.println(links+" ==> StatusCode : "+statusCode+" ==> Response Message : "+responseMsg);
				}
			}
			catch (Exception e) {
				BrokenLinks.add(links+" ===> Not Connected to server");
			}
		}
//		System.out.println(BrokenLinks.size());
//		for(String bs:BrokenLinks) {
//			System.out.println(bs);
//		}
		System.out.println(listOfLinks.size());
		for(String bs:listOfLinks) {
			System.out.println(bs);
		}
	}
}
