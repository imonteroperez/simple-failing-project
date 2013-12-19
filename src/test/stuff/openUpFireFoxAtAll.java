package stuff;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openUpFireFoxAtAll {
	
    @Test
	public void helloGoogle() {
    	FirefoxDriver driver =new FirefoxDriver();
    	driver.get("http://www.google.com/");

    	driver.close();
	}
}
