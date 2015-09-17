package test.annotations;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by karl on 6/22/14.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface A {
    Function<A, Class<?>> GET_VALUE = new Function<A, Class<?>>() {
        @Override
        public Class<?> apply(A annotation) {
            return annotation.value();
        }
    };

    Predicate<A> VALUE_NOT_NULL = new Predicate<A>() {
        @Override
        public boolean apply(A annotation) {
            return annotation.value() != null;
        }
    };

    Class<?> value();
}
