package stuff;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class OpenUpFireFoxAtAll extends IntegrationTest {
	
    public OpenUpFireFoxAtAll() {
		super(new HtmlUnitDriver(false));
		// TODO Auto-generated constructor stub
	}

	@Test
	public void helloGoogle() {
    	FirefoxDriver driver =new FirefoxDriver();
    	driver.get("http://www.google.com/");

    	driver.close();
	}
	
	@Test
	public void fail() {
    	fail();
	}
}
