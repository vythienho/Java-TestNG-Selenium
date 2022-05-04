package algorithm.annotations.inherited;

//https://www.educba.com/java-inherited/

import java.lang.annotation.Inherited;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** Option 1: use @Inherited
 */
@Inherited
@Target ({ElementType.TYPE, ElementType.METHOD})
@Retention (RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
    String name () default "unknown";
    String code () default " ";
}
/**
 * Output in Demo.java
 *
 * Finding annotations on java.lang.Class
 * Name of Annotation :interface annotations.inherited.MyAnnotation
 * State Name :Karnataka
 * State code :KA
 * @annotations.inherited.MyAnnotation(name="Karnataka", code="KA")
 * @annotations.inherited.MyAnnotation(name="Karnataka", code="KA")
 * Finding annotations on java.lang.reflect.Method
 */


/** Option 2: use @Target and @Retention
 */
//// no @Inherited
//@Target ({ElementType.TYPE, ElementType.METHOD})
//@Retention (RetentionPolicy.RUNTIME)
//public @interface MyAnnotation
//{
//    String name () default "unknown";
//    String code () default " ";
//}
/**
 * Output from Demo.java
 *
 * Finding annotations on java.lang.Class
 * Name of Annotation :interface annotations.inherited.MyAnnotation
 * State Name :Karnataka
 * State code :KA
 * null
 * @annotations.inherited.MyAnnotation(name="Karnataka", code="KA")
 * Finding annotations on java.lang.reflect.Method
 *
 * Note:  null
 *  that is the return value of the statement “new  Demo ().getClass ().getAnnotation (MyAnnotation.class)”,
 *  which means that the demo class is not inherited (or annotated) any MyAnnotation annotation from it Superclass,
 *  because the @Inherited annotation is not annotated to MyAnnotation to inherit it in the subclass.
 */