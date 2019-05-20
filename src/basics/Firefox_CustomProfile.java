package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
/**
 * @author Dinesh Kumar Reddy
 * Test Flow : -  Launching the particular selected Firefox profile and run the script
 * 		 
 * Steps to Create Firefox Profile :-
 * 	 		- First you need to create the firefox profile like,
 * 			- Open Run ( windows button + R )
 * 			- Type "firefox.exe -p" , it will launch the firefox profile management
 *					Options are - Create Profile, rename Profile, Delete Profile.
 * 					OR you can select the existing profile and launch the profile. 
 * 			- here you can create the profile - by using, Create Profile option
 *			- After creating profile you will come to the code, and give that profile name here 
 * 			- for here the profile name which i created is - "SeleniumProfile"
 */
public class Firefox_CustomProfile {

	public WebDriver driver;

	
	//////////// Search for new code - Some classes are deprecated (OutDated)/////////////  
	@Test
	public void FirefoxProfileCreation() {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Lib\\geckodriver.exe");

		
		// This is a code to implement a profile, which can be embedded in the selenium code.
		ProfilesIni profile = new ProfilesIni();

		// this will create an object for the Firefox profile
		FirefoxProfile myprofile = profile.getProfile("SeleniumProfile");

		// this will Initialize the Firefox driver
//		driver = new FirefoxDriver(myprofile);

	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
		driver.close();
	}

}
