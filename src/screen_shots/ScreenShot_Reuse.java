package screen_shots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Dinesh Reddy
 *  About this class - you can reuse this class 
 *
 */
public class ScreenShot_Reuse {

	public static void takeScreenShot(WebDriver driver, String ScreenshotName) {
		
	TakesScreenshot ts = (TakesScreenshot)driver; 
	File source = ts.getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFile(source, new File ("./ScreenShots/"+ScreenshotName+".png"));
		System.out.println("Screen shot taken ");
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}

}
