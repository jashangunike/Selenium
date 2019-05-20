package screen_shots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import base.OpenBrowser3;

/**
 * @author Dinesh Reddy
 *         About Class : - take screen shot
 *         - We can give .png or .jpg filename to scerrnshot image name,
 *         based on this image format will be created
 *         - you can create the method and reuse it again and again when you require
 *
 */
public class TakeScreenShot extends OpenBrowser3 {

	@Test
	public void takeScreenShot() {

		d.get("https://www.google.com");

		// Take Screen shot
		File screenshot = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./ScreenShots/google1.png"));
			// Here . represents my current project location
			// or
			// FileUtils.copyFile(screenshot, new File( "X:\imagename.jpg or imagename.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void takeScreenShot2() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)d;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		// throwing IOException - you can throw or use try catch 
		FileUtils.copyFile(source, new File ("./ScreenShots/google2.png"));
				
	}

}
