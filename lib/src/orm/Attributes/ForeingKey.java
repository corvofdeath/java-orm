package orm.Attributes;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ForeingKey {
    String table();
    String constrange() default "varchar(36) NOT NULL";
    // % = generated-key / $ = property-name / & = table-name
    String instruction() default "\nKEY `%x` (`$`),\nCONSTRAINT `%x` FOREIGN KEY (`$`) REFERENCES `&` (`id`),";
}
