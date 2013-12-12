/**
 * @author markl
 */
package stuff;

import org.junit.Rule;

import stuff.RecordArtifactRule;

//import com.ifactory.arachne.core.test.TapestryIoCTestCase;

/**
 * @author markl
 *
 */
public class BaseTest{// extends TapestryIoCTestCase {

	
	@Rule public RecordArtifactRule watchman = new RecordArtifactRule(this);

}
