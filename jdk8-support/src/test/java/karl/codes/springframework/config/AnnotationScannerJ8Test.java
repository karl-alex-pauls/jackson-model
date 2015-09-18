package karl.codes.springframework.config;

import karl.codes.jackson.config.JsonModel;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import test.annotations.A;
import test.model.ConcretePOJO1;
import test.model.WatchedByThingA;

import java.util.Collection;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by karl on 9/17/15.
 */
public class AnnotationScannerJ8Test {
    @Test
    public void testWatchedThing() {
        AnnotationScannerBuilder.AnnotationScanTask scanner = new AnnotationScannerBuilder<Class<?>>()
                .map(A.class, A.GET_VALUE, A.VALUE_NOT_NULL)
                .enableJava8Support()
                .build();

        Map<Class<?>, Collection<Class<?>>> concrete = scanner.toMap("test.scan.a");

        Collection<Class<?>> models = concrete.get(WatchedByThingA.class);

        assertThat(concrete.size(), is(1));
        assertThat(models, notNullValue());
        assertThat(models.size(), is(1));
    }

    @Test
    public void setCollapsesEquivalentValues() {
        AnnotationScannerBuilder.AnnotationScanTask<Class<?>> scanner = new AnnotationScannerBuilder<Class<?>>()
                .enableJava8Support()
                .map(JsonModel.class, JsonModel.GET_VALUE, JsonModel.VALUE_NOT_NULL)
                .orderBy(AnnotationAwareOrderComparator.INSTANCE)
                .build();

        Map<Class<?>, Collection<Class<?>>> concrete = scanner.toMap("test.scan.pojo1");

        Collection<Class<?>> models = concrete.get(ConcretePOJO1.class);

        assertThat(concrete.size(), is(1));
        assertThat(models, notNullValue());
        assertThat("Set failed to remove equal values", models.size(), is(1));
    }
}
