/**
 * @author markl
 */
package stuff;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * @author markl
 *
 */
public class RecordArtifactRule extends TestWatcher {

    //TOOD: use with https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin

    //TODO: check that everything in the class that uses the CaptureFile annotation is set to public, fail the test otherwise.

//    /**
//    * A logger... so if you use System.out, or System.err... you will be shot!
//    */
//    private static transient final Logger logger = LoggerFactory.getLogger(RecordArtifactRule.class);

    Object testObject;

    /**
     *
     */
    public RecordArtifactRule(final Object testObject) {
        super();
        this.testObject = testObject;
    }

    @Override
    protected void starting(final Description description) {
        //description.
        description.getTestClass().getMethods();
    }

    @Override
    protected void failed(final Throwable e, final Description description) {

        Map<String, byte[]> fileOut = new HashMap<String, byte[]>();
        Map<String, String> textfileOut = new HashMap<String, String>();//TODO: possible name overlapping: shareed keys
        //TODO: null checks and such
        //TODO: tostring the objects, and such

        for (Method m : description.getTestClass().getMethods()) {

            //System.out.println(m.getName());
            CaptureFile cf = m.getAnnotation(CaptureFile.class);
            if (cf != null) {
                //                cf.extention();
                try {

                    if (String.class.equals(m.getReturnType())) {
                        String str = (String) m.invoke(testObject);
                        if (str != null) {
                            textfileOut.put(m.getName() + "." + cf.extention(), str);
                        }
                    } else {
                        byte[] byt = (byte[]) m.invoke(testObject);
                        if (byt != null) {
                            fileOut.put(m.getName() + "." + cf.extention(), byt);
                        }
                    }
                    //                    }else{
                    //                        //TODO:???
                    //                    }

                } catch (IllegalAccessException e1) {
//                    logger.error(e1.getMessage(), e1); // TODO Auto-generated catch block
                } catch (IllegalArgumentException e1) {
//                    logger.error(e1.getMessage(), e1); // TODO Auto-generated catch block
                } catch (InvocationTargetException e1) {
//                    logger.error(e1.getMessage(), e1); // TODO Auto-generated catch block
                }
            }

        }

        for (Field f : description.getTestClass().getFields()) {

            //System.out.println(m.getName());
            CaptureFile cf = f.getAnnotation(CaptureFile.class);
            if (cf != null) {

                try {
                    if (String.class.equals(f.getType())) {

                        textfileOut.put(f.getName() + "." + cf.extention(), (String) f.get(testObject));//TODO: string
                    } else {
                        fileOut.put(f.getName() + "." + cf.extention(), (byte[]) f.get(testObject));
                    }

                } catch (IllegalArgumentException e1) {
//                    logger.error(e1.getMessage(), e1); // TODO Auto-generated catch block
                } catch (IllegalAccessException e1) {
//                    logger.error(e1.getMessage(), e1); // TODO Auto-generated catch block
                }

            }

        }

        //TODO: first clean this directory

        //        String relpath = "target/surefire-reports/";
        String relpath = "target/testArtifacts/";

        //TODO: system var for maven target?
        (new File(relpath)).mkdirs();//+ System.getProperty("user.dir");
        String root = relpath + testObject.getClass().getName();// + "." + description.getMethodName();
        (new File(root)).mkdirs();
        //TODO: new file error checks and stuff
        
        //becuase the plugin is class based not test based
        String pre = description.getMethodName()+".";

        if (fileOut.size() > 0) {

            for (Entry<String, byte[]> p : fileOut.entrySet()) {
                try {
                    File path = new File(root + "/" + pre+p.getKey());
                    FileUtils.writeByteArrayToFile(path, p.getValue());

                    System.out.println();
                    //                                        System.out.println("[[ATTACHMENT|" + path.getAbsolutePath() + "]]"); //according to https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin
                    System.out.println("[[ATTACHMENT|" + path + "]]"); //according to https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin
                    System.out.println();

                    System.out.println("record: " + path.getAbsolutePath()); //according to https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin
                    System.out.println();
                } catch (IOException e1) {
//                    logger.error(e1.getMessage(), e1); // TODO Auto-generated catch block
                }
            }
        }

        if (textfileOut.size() > 0) {

            for (Entry<String, String> p : textfileOut.entrySet()) {
                try {
                    File path = new File(root + "/" + pre+p.getKey());
                    FileUtils.writeStringToFile(path, p.getValue());

                    System.out.println();
                    //                                        System.out.println("[[ATTACHMENT|" + path.getAbsolutePath() + "]]"); //according to https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin
                    System.out.println("[[ATTACHMENT|" + path + "]]"); //according to https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin
                    System.out.println();

                    System.out.println("record: " + path.getAbsolutePath()); //according to https://wiki.jenkins-ci.org/display/JENKINS/JUnit+Attachments+Plugin
                    System.out.println();
                } catch (IOException e1) {
//                    logger.error(e1.getMessage(), e1); // TODO Auto-generated catch block
                }
            }
        }

        //description.getTestClass().getDeclaringClass();
    }

    //TODO: handle Content
}
