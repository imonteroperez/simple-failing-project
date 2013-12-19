/**
 * @author markl
 */
package stuff;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

////import org.apache.tapestry5.ioc.annotations.Inject;
////import org.apache.tapestry5.ioc.services.SymbolSource;
//import org.junit.Rule;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
//
////import com.ifactory.arachne.core.test.TapestryIoCTestCase;

/**
 * @author markl
 *
 */
public class IntegrationTest extends BaseTest {

//    /**
//    * A logger... so if you use System.out, or System.err... you will be shot!
//    */
//    private static transient final Logger logger = LoggerFactory.getLogger(IntegrationTest.class);

//    @Inject protected SymbolSource symbolSource;

    protected WebDriver driver;

    protected WebDriverWait waiter;

    protected String baseDomain;

    public IntegrationTest(final WebDriver w) {
        driver = w;
        waiter = (new WebDriverWait(driver, 10));

        baseDomain = "http://www.google.com/";
    }


    @CaptureFile(extention = "html")
    public String domHtml() {
    	
    	String source= driver.getPageSource();
    	if(StringUtils.isBlank(source)){
    		return null;
    	}
        return driver.getPageSource();
    }

    @CaptureFile(extention = "png")
    public byte[] page() {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return null;
    }

    @AfterClass
    public void affterClass() {
		if(driver!=null){
			driver.close();
		}
	}
}
