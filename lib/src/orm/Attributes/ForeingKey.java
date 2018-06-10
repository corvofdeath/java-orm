package orm.Attributes;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ForeingKey {
    String table();
    String constrange() default "int(10) NOT NULL";
    // % = generated-key / $ = property-name / & = table-name
    String instruction() default "\nKEY `%x` (`$`),\nCONSTRAINT `%x` FOREIGN KEY (`$`) REFERENCES `&` (`id`),";
}
