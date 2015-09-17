package karl.codes.springframework.config;

import test.annotations.A;
import test.model.WatchedByThingA;

import java.util.Collection;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by karl on 9/17/15.
 */
public class AnnotationScannerFixture {
    public static AnnotationScannerBuilder<Class<?>> newBuilder() {
        return new AnnotationScannerBuilder<Class<?>>()
                .map(A.class,A.GET_VALUE,A.VALUE_NOT_NULL);
    }

    public static void validateModels(Map<Class<?>, Collection<Class<?>>> models,
                                      int mapSize, Class<?> key, int valueSize) {
        Collection<Class<?>> concrete = models.get(key);

        assertThat(models.size(), is(1));
        assertThat(concrete, notNullValue());
        assertThat(concrete.size(), is(1));
    }
}
