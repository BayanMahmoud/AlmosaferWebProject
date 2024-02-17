package almosafweb;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Parameters {

	

	String MyWebsite = "https://global.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();
	Random rand = new Random();
	

	String[] countryEN = { "Dubai", "Jeddah", "Riyadh" };
	String[] countryAR = { "دبي", "جدة" };
	int indexcountryEN = rand.nextInt(countryEN.length);
	int indexcountryAR = rand.nextInt(countryAR.length);
	
	
	
	public void openWebSite() {
		driver.manage().window().maximize();
		driver.get(MyWebsite);
		WebElement WelcomeScreen = driver
				.findElement(By.xpath("//button[normalize-space()='Kingdom of Saudi Arabia, SAR']"));
		WelcomeScreen.click();
	}
	
	
	
	
	public void ChecklanguageFunction(String lang) {
		String actualLang = driver.findElement(By.tagName("Html")).getAttribute("lang");
		String expectedLang = lang;
		softassert.assertEquals(actualLang, expectedLang, "This is check of the website use language english");
	
	}
	
	public void checkCurrencyFunction(String currencyType) {
		WebElement Curruncy = driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO"));
		String actualCurruncy = Curruncy.getText();
		String expectedcurruncy = currencyType;

		softassert.assertEquals(actualCurruncy, expectedcurruncy,"check of the currency");
		
	}
	
	public void  contactNumberFunction(String Num) {
		WebElement Number = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));
		String ActualNumber = Number.getText();

		String expectedNum = Num;

		softassert.assertEquals(ActualNumber, expectedNum);
		
	}
	
	
	
	
	public void logoFunction( WebElement LOGO) {
		
		
		WebElement logo = LOGO ;
		boolean actualTrue = logo.isDisplayed();
		softassert.assertEquals(actualTrue, true, "This is LOGO 'qitaf'is Displayed at footer");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
