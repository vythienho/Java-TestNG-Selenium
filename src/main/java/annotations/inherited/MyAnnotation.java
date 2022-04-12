package annotations.inherited;

import java.lang.annotation.Inherited;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target ({ElementType.TYPE, ElementType.METHOD})
@Retention (RetentionPolicy.RUNTIME)

public @interface MyAnnotation
{
    String name () default "unknown";
    String code () default " ";
}