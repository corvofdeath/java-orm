package orm.Attributes;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ForeingKey {
    String table();
    String constrange() default "int(10) NOT NULL";
    String instruction() default "CONSTRAINT $ FOREIGN KEY $ REFERENCES $ ($)";
}
