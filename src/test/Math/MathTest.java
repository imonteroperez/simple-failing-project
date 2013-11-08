package Math;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class MathTest {

	@Test
	public void test1p1e2() throws Exception {
		
		//does file writing work?
        String relpath = "target/testArtifacts/";
		
        (new File(relpath)).mkdirs();
        String root = relpath + this.getClass().getName();
        (new File(root)).mkdirs();
        
        File path = new File(root + "/Insight.math");
        FileUtils.write(path, "things are getting SUbtracted!");

        //what I would think it would be:
        System.out.println();
        System.out.println("[[ATTACHMENT|" + path + "]]"); 
        System.out.println();
        
//        //with a stupidly absolute path
//        System.out.println();
//        System.out.println("[[ATTACHMENT|" + path.getAbsolutePath() + "]]");
//        System.out.println();
//        
//        
//        //In a syntax like the unit tests
//        System.out.println();
//        System.out.println("[exec] [[ATTACHMENT|" + path + "]]");
//        System.out.println();
//        
//        //all 3 again in std error for good measure
//        
//        //what I would think it would be:
//        System.err.println();
//        System.err.println("[[ATTACHMENT|" + path + "]]"); 
//        System.err.println();
//        
//        //with a stupidly absolute path
//        System.err.println();
//        System.err.println("[[ATTACHMENT|" + path.getAbsolutePath() + "]]");
//        System.err.println();
//        
//        
//        //In a syntax like the unit tests
//        System.err.println();
//        System.err.println("[exec] [[ATTACHMENT|" + path + "]]");
//        System.err.println();
        
        
        
		assertEquals(2, Math.add(1, 1));
	}

}
