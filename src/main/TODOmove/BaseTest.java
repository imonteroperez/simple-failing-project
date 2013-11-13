/**
 * @author markl
 */
package TODOmove;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatchman;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//import com.ifactory.arachne.core.test.TapestryIoCTestCase;

/**
 * @author markl
 *
 */
public class BaseTest{// extends TapestryIoCTestCase {

	
	@Rule public RecordArtifactRule watchman = new RecordArtifactRule(this);

}
