package demo43Annotation;

import java.lang.annotation.*;

@Target ({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention (RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Annotation01 {
	
}
