package orm.Attributes;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ForeingKey {
    String table();
    String instruction() default "CONSTRAINT $ FOREIGN KEY $ REFERENCES $ ($)";
}
