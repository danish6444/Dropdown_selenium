package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws Exception {
		// setting the property of chrome browser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver","D:\\Training Materials\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(@id,'u_0')]")).click();
		Thread.sleep(2000);
		
		//1st way
		List<WebElement> birthMonth = driver.findElements(By.xpath("//select[@id='month']/option"));
		System.out.println("Total Dropdown Values :- " + birthMonth.size());
        birthMonth.get(8).click();// sep
        
        //2nd way
        WebElement bm = driver.findElement(By.xpath("//select[@id='month']"));
        Select month = new Select(bm);
        Thread.sleep(2000);
        month.selectByVisibleText("Apr");//apr
        Thread.sleep(2000);
        month.selectByValue("12");//dec
        Thread.sleep(2000);
        month.selectByIndex(2);//aug
        System.out.println(month.getFirstSelectedOption().getText());//aug
        
        //3rd way
        List<WebElement> dropdown = month.getOptions();
        for (int i=0; i<dropdown.size(); i++) {
        	if (dropdown.get(i).getText().equalsIgnoreCase("sep")) {
        		dropdown.get(i).click();
        	}}
        
        //4thway
        bm.sendKeys("jun");
        
        //5th way
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='month']")).sendKeys("march");
        
        //check if dropdown support multi selection
        System.out.println(month.isMultiple());//false
        month.selectByVisibleText("apr");//apr
        month.selectByValue("12");//dec
        month.selectByIndex(7);//aug
        
        //deselect the multi selected values
        month.deselectByVisibleText("apr");//apr
        month.deselectByValue("12");//dec
        month.deselectByIndex(7);//aug
        month.deselectAll(); // deselect all selected values
        
        	}
        }
        
	


