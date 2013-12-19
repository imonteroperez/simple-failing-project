/**
 * @author markl
 */
package stuff;

import static org.junit.Assert.fail;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.htmlunit.HtmlUnitWebElement;


/**
 * @author markl
 *
 */
//@Ignore("Ignored for obvious reasons")
public class IntentionalyFailingIntegrationTest extends IntegrationTest {

    /**
     * @param w
     */
    public IntentionalyFailingIntegrationTest() {
        super(new HtmlUnitDriver(false));
        // TODO Auto-generated constructor stub
    }

    @CaptureFile String otherDubugInformation = "";
    String impotantDubugInformation = "";


    @CaptureFile
    public String captureDebug() {
        return impotantDubugInformation;
    }

    @Test
    public void fails() {
        impotantDubugInformation = "dg is 'fun'";
        otherDubugInformation = "the problem is complicated";
        fail();
    }

    @Test
    public void failsinBrowser() {
        driver.get(baseDomain);
        impotantDubugInformation = "dg is 'fun'";
        otherDubugInformation = "hey!!!";

        HtmlUnitWebElement elem = (HtmlUnitWebElement) waiter.withMessage("regression for #3272").until(
                presenceOfElementLocated(By.partialLinkText("Title Thingy")));
    }


    @Test
    public void succeeds() {
    }
    

	@Test
	public void helloGoogle() {
		
		System.setProperty("webdriver.firefox.bin","/usr/bin/firefox");
		
    	FirefoxDriver driver =new FirefoxDriver();
    	driver.get("http://www.google.com/");

    	driver.close();
	}
	
	
	//TODO: don't record things that are set to null
	@Test
	public void failll() {
    	fail("nope");
	}
}
