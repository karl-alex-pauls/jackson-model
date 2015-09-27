package karl.codes.jackson.config;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @see JsonModel#where()
 */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface Where {
    /**
     * @return the set of all required Qualifiers
     */
    Qualifier[] value() default {};
    Class<?>[] prototype() default {};
}
