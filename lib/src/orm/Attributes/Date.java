package orm.Attributes;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Date {
    String constrange() default "datetime";
}
