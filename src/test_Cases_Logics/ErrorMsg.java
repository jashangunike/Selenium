package test_Cases_Logics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ErrorMsg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier");
		driver.findElement(By.name("Email")).sendKeys("testing sjdhfkshf");
		driver.findElement(By.name("signIn")).click();
		Thread.sleep(2000);
		
		String url = driver.getCurrentUrl();
		if(url.contains("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier")){
			String errmsg = driver.findElement(By.xpath(".//*[@id='errormsg_0_Email']")).getText();
		
			if(errmsg.contains("Please enter a valid email address.")){
			System.out.println("Handling error msgs passed");
		}
		}
		else{
			System.out.println("Handling error msgs failed");
		}
		driver.close();
	
	}

}
