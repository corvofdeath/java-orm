package orm.Attributes;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {
    String instruction() default "\nUNIQUE KEY `$_UNIQUE` (`$`),";
}
