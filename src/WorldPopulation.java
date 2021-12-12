/*
 Keep getting the count of: 
- Current World Population
- Today:  Births, Deaths and population growth today
- This Year:  Births, Deaths and population growth today
while(true){

 keep getting the element text using selenium
 print it on console

 //break the loop after few secs (20 secs)
}
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Libs_Workshop\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://www.worldometers.info/world-population/");
//		List<String> param=new List<>({"Current World Population","Today Births", 
//				"Today Deaths","Population growth today","This Year Births", 
//				"This Year Deaths","Population growth this year"});
		List<WebElement> ele = wd.findElements(By.xpath("//span[@class='rts-counter']"));
		int count = 1;
		while (count < 21) {
			System.out.println("Count " + count + " secs");
			for (int i = 0; i < 7; i++) {
				System.out.println(ele.get(i).getText());
				System.out.println("-----------------------------------------");
			}
			if (count == 20) {
				break;
			}
			count++;
		}
		wd.close();
	}

}
