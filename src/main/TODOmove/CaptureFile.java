/**
 * @author markl
 */
package TODOmove;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author markl
 *
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
//TODO: have this work Only with public members
//TODO: having this work on local variable would be awesome, mabe in java 8 :-(
@Retention(RetentionPolicy.RUNTIME)
public @interface CaptureFile {//TODO: capture String, just record a bunch of string paramiters

    String extention() default "txt";

    String name() default "";//TODO: defult to the method's name

    //TODO: make to work with binary function types
}
