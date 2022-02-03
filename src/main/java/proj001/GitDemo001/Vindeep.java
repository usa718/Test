package proj001.GitDemo001;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Vindeep {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\SelWorkspaces\\Sel@10PM\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://vindeep.com/Calculators/FDCalc.aspx");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		System.out.println("Title="+title);
		if(title.equals("Fixed Deposit Calculator | Calculate FD Interest, Maturity value"))
		{
			System.out.println("Title Matched");
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).clear();
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FDAmount")).sendKeys("200000");
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).clear();
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_Period")).sendKeys("70");
			//List box
			WebElement ele=driver.findElement(By.id("ContentPlaceHolder1_cphCentre_PeriodDropDown"));
			Select opts=new Select(ele);
			opts.selectByVisibleText("Days");
			//Fetch elements 
			List<WebElement> allItems=opts.getOptions();
			System.out.println("total elements in a List box="+allItems.size());
			for(int i=0;i<allItems.size();i++)
			{
				System.out.println(allItems.get(i).getText());
			}
			
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).clear();
			driver.findElement(By.id("ContentPlaceHolder1_cphCentre_InterestRate")).sendKeys("5.50");
			Select opts1=new Select(driver.findElement(By.id("ContentPlaceHolder1_cphCentre_FrequencyDropDown")));
			opts1.selectByValue("Annual");
			
			List<WebElement> allItems1=opts1.getOptions();
			System.out.println("Total Elements in a List box="+allItems1.size());
			for(int i=0;i<allItems1.size();i++)
			{
				System.out.println(allItems1.get(i).getText());
			}
			driver.findElement(By.name("ctl00$ContentPlaceHolder1$cphCentre$btnFDMAmount")).click();
			Thread.sleep(5000);
			String FD_Amount=driver.findElement(By.id("ContentPlaceHolder1_cphCentre_MaturityAmountTextBox")).getAttribute("value");
			System.out.println("FD Amount="+FD_Amount);
			
		}
		else
		{
			System.out.println("Title not Matched");
		}
		driver.quit();
		
	}

}
