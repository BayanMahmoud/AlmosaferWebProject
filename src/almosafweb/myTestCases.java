package almosafweb;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class myTestCases extends Parameters {

	@BeforeTest
	public void SetUp() {
	openWebSite();
	}

	@Test(priority = 1,description = " this is happy Scenario test",enabled =false)
	public void ChecklanguageEN() {

		
		ChecklanguageFunction("en");
		 softassert.assertAll();
	}
	
	
	
	@Test(priority = 2 ,description = " this is Sad Scenario test",enabled =false)
	public void ChecklanguageAR() throws InterruptedException {

		
		ChecklanguageFunction("ar");
		 softassert.assertAll();
	}
	
	
	
	

	@Test(priority = 3,description = "this is to check the currency is SAR")
	public void CheckTheCurrency() throws InterruptedException {
		checkCurrencyFunction("SAR");
		 softassert.assertAll();
		
	}
	
	
	

	@Test(priority = 4)
	public void checkContactNumber() {
	     contactNumberFunction("+966554400000");
		 softassert.assertAll();
	}

	
	
	@Test(priority = 5,enabled =true)
	public void CheckLogoQitaf() {
	 logoFunction(driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']//*[name()='svg']")));
	 softassert.assertAll();
	}
	
	@Test(priority =6)
	public void logoApple() {
		logoFunction(driver.findElement(By.className("sc-ghsgMZ")));
		 softassert.assertAll();
	}

	@Test(priority = 7)
	public void cheakNOTSelectHotels() {
		WebElement hotelsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String actualSelect = hotelsTab.getDomAttribute("aria-selected");
		String expectedSelect = "false";
		softassert.assertEquals(actualSelect, expectedSelect);
		 softassert.assertAll();
	}

	@Test(priority = 6)
	public void flightsDate() {

		WebElement deptuerDate = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"));
		WebElement returnDate = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"));

		String actualDeptureDate = deptuerDate.getText();
		int actualDeptureDateValue = Integer.parseInt(actualDeptureDate);

		String actualReturnDate = returnDate.getText();
		int actualReturnDateValue = Integer.parseInt(actualReturnDate);

		LocalDate today = LocalDate.now();

		int expectedDeptureDateValue = today.plusDays(1).getDayOfMonth();

		int expectedReturnDateValue = today.plusDays(2).getDayOfMonth();

		Assert.assertEquals(actualDeptureDateValue, expectedDeptureDateValue, "This is check of the depture date ");
		Assert.assertEquals(actualReturnDateValue, expectedReturnDateValue, "This is check of the Return date ");

	}

	@Test(priority = 7, enabled = false)
	public void flightDAY() throws InterruptedException {
		Thread.sleep(1000);
		WebElement dayDepture1 = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-hvvHee cuAEQj']"));
		WebElement dayReturn = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-hvvHee cuAEQj']"));
		String actualDeptureDay = dayDepture1.getText().toUpperCase();
		String ACtualReturnDay = dayReturn.getText().toUpperCase();

		LocalDate today = LocalDate.now();

		String expectedDeptureDay = today.plusDays(1).getDayOfWeek().toString();
		String expectedReturnDay = today.plusDays(2).getDayOfWeek().toString();
		Assert.assertEquals(actualDeptureDay, expectedDeptureDay);
		Assert.assertEquals(ACtualReturnDay, expectedReturnDay);

	}

	@Test(priority = 8)
	public void flightDAY2() throws InterruptedException {
		Thread.sleep(1000);
		WebElement dayDepture = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-hvvHee cuAEQj']"));
		WebElement dayReturn = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-hvvHee cuAEQj']"));
		String actualDeptureDay = dayDepture.getText();
		String ACtualReturnDay = dayReturn.getText();

		LocalDate today = LocalDate.now();

		String expectedDeptureDay = today.plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
				.toString();
		String expectedReturnDay = today.plusDays(2).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
				.toString();
		Assert.assertEquals(actualDeptureDay, expectedDeptureDay);
		Assert.assertEquals(ACtualReturnDay, expectedReturnDay);
	}

	@Test(priority = 9)
	public void flighMonth() throws InterruptedException {
		Thread.sleep(3000);
		WebElement MonthDepture = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-bYnzgO doqpRk']"));
		WebElement MonthReturn = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-bYnzgO doqpRk']"));
		String actualDeptureMonth = MonthDepture.getText();
		String ACtualReturnMonth = MonthReturn.getText();

		LocalDate today = LocalDate.now();

		String expectedDeptureMonth = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toString();
		String expectedReturnMonth = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toString();

		Assert.assertEquals(actualDeptureMonth, expectedDeptureMonth);

		Assert.assertEquals(ACtualReturnMonth, expectedReturnMonth);
	}

	@Test(priority = 10)
	public void switchLangWeb() throws InterruptedException {
		Thread.sleep(1000);
	

		// acces the website en or ar randomly
		String[] myUrls = { "https://global.almosafer.com/en", "https://global.almosafer.com/ar" };
		int indexMyUrls = rand.nextInt(myUrls.length);
		driver.get(myUrls[indexMyUrls]);

		// this is click the hotel Tab
		WebElement hotelsTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelsTab.click();
		Thread.sleep(2000);

		// inside Hotels tab we will send keys either Arabic cities or English cities

		WebElement InputHotle = driver.findElement(By.className("phbroq-2"));

		String actualUrl = driver.findElement(By.tagName("html")).getAttribute("lang");

		if (driver.getCurrentUrl().contains("en")) {

			Assert.assertEquals(actualUrl, "en");

			InputHotle.sendKeys(countryEN[indexcountryEN]);

			Thread.sleep(1000);
			WebElement listCity = driver.findElement(By.className("phbroq-4"));
			List<WebElement> optionsList = listCity.findElements(By.tagName("li"));
			Thread.sleep(1000);
			optionsList.get(3).click();
			
			Thread.sleep(2000);

			// myselect.selectByVisibleText("1 Room, 1 Adult, 0 Children");;

		} else {
			Assert.assertEquals(actualUrl, "ar");
			InputHotle.sendKeys(countryAR[indexcountryAR]);
			Thread.sleep(1000);
			WebElement listCity = driver.findElement(By.className("phbroq-4"));
			List<WebElement> optionsList = listCity.findElements(By.tagName("li"));

			optionsList.get(3).click();

			Thread.sleep(1000);

			// myselect.selectByVisibleText("غرفة واحدة، 2 بالغون، 0 أطفال");

		}
		WebElement VisitorSelect = driver.findElement(By.className("tln3e3-1"));

		Select myselect = new Select(VisitorSelect);
		int indexSelect = rand.nextInt(2);

		myselect.selectByIndex(indexSelect);
		Thread.sleep(1000);
		WebElement searchHotelButton = driver.findElement(By.className("iKBWgG"));

		searchHotelButton.click();

		Thread.sleep(22000);
		String actualResultSearch = driver.findElement(By.className("klWOBA")).getText();

		// one way assert is search result page
		// Assert.assertEquals((actualResultSearch.contains("found")||
		// actualResultSearch.contains("وجدنا")),true
		// ,"the cheack loading fully compleated is search Result Page");

		// or this way assert is search result page //
		if (driver.getCurrentUrl().contains("en")) {

			Assert.assertEquals(actualResultSearch.contains("found"), true,
					"the cheack loading fully compleated is search Result Page");
			Thread.sleep(9000);

			WebElement LowestPriceButton = driver.findElement(By.className("hcjHpm"));
			LowestPriceButton.click();
		} else {

			Assert.assertEquals(actualResultSearch.contains("وجدنا"), true);
			Thread.sleep(9000);

			WebElement LowestPriceButton = driver.findElement(By.className("jyUtIz"));
			LowestPriceButton.click();
		}

		Thread.sleep(9000);


		WebElement SectionResult = driver.findElement(By.cssSelector(
				"body > div:nth-child(2) > div:nth-child(5) > div:nth-child(2) > div:nth-child(2) > section:nth-child(2)"));
		List<WebElement> prices = SectionResult.findElements(By.className("Price__Value"));
		String lowerprice = prices.get(0).getText();
		int lowerPriceValue = Integer.parseInt(lowerprice);

		String heightprice = prices.get(prices.size() - 1).getText();
		int heigtPriceValue = Integer.parseInt(heightprice);

		Assert.assertEquals(lowerPriceValue < heigtPriceValue, true,
				"this check the result are sorted from lower to height Price");
  
		
	}

	@AfterTest()
	public void PostTesting() {
		
		

	}

}
