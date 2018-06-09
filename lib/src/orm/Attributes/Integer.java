package orm.Attributes;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Integer {
    String constrange() default "int(10)";
}
