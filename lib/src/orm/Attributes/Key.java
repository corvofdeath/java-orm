package orm.Attributes;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Key {
    String instruction() default "PRIMARY KEY('id')";
    String constrange() default  "int(10) NOT NULL";
}
