
/*
 * Get the carousel items from:
 Recommended For You
 Sports shoes under 199 AED
 Top picks in laptops
 Limited time offers
 Bestselling fragrances

You need to create a generic function, this will take the sectionName(String) as an input
 parameter and will return the collection of all the carousel items text in sorted order only.

You need to keep clicking on the next arrow icon until its disappeared and keep fetching the 
text of each item in carousel.
 * 
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CarousalHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver_win32_v96\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> itemElements = driver.findElements(
				By.xpath("(//h3[@class='sc-dlfnbm hRlTQS'])[1]/following :: div[contains(@class,'e3js0d-10')]"));
		WebElement carousalElement = driver
				.findElement(By.xpath("//div[@class='sc-eHEENL fnVrSf']//div[contains(@class,'swiper-button-next')]"));
		getCarousalItem(itemElements, carousalElement);
	}

	private static void getCarousalItem(List<WebElement> itemElements, WebElement carousalElement)
			throws InterruptedException {
		// TODO get carousal item

		List<String> itemText = new ArrayList<>();
		for (int i = 1; i < itemElements.size();) {
			try {
				itemText.add(itemElements.get(i).getAttribute("title"));
			} catch (StaleElementReferenceException e) {
				itemElements = driver.findElements(By
						.xpath("(//h3[@class='sc-dlfnbm hRlTQS'])[1]/following :: div[contains(@class,'e3js0d-10')]"));
				if (!itemElements.get(i).isDisplayed() && i == 1) {
					Thread.sleep(3000);
				} else if (!itemElements.get(i).isDisplayed() && i != 1) {
					System.out.println("Items are not visible");
					if (!carousalElement.isDisplayed()) {
						Thread.sleep(3000);
						System.out.println("Carousal is not visible yet");
					} else {
						carousalElement.click();
						System.out.println("Carousal clicked");
						// break;
					}
				}
				itemText.add(itemElements.get(i).getAttribute("title"));
			}

		}
		Collections.sort(itemText);
		System.out.println(itemText);
	}
}
