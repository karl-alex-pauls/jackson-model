package test.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by karl on 6/22/14.
 */
@Retention(RetentionPolicy.RUNTIME)
@A(AA.class)
public @interface AA {
}
