package Resources;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public void ScreenShotTaker(WebDriver d,String name) throws IOException, AWTException, InterruptedException {
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	TakesScreenshot ts=(TakesScreenshot)d;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File("C:\\Users\\2304038\\eclipse-workspace\\HACKATHON\\HACKATHON\\Screenshots"+name+".png");
	FileUtils.copyFile(src,trg);
	}

	
}
