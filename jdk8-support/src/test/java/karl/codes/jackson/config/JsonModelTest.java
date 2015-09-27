package karl.codes.jackson.config;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import test.model.ConcretePOJO1;
import test.model.ConcretePOJO2;
import test.scan.pojo1.ModelOne;
import test.scan.pojo1.ModelTwo;

import java.util.Collection;
import java.util.Map;

/**
 * Created by karl on 9/17/15.
 */
public class JsonModelTest {
    @Test
    public void testConcretePOJO1() {
        Map<Class<?>, Collection<Class<?>>> models = JsonConfigScanner.collectModels("test.scan.pojo1");
        Collection<Class<?>> concrete = models.get(ConcretePOJO1.class);

        assertThat(models.size(), is(1));
        assertThat(concrete, notNullValue());
        assertThat(concrete.size(), is(2));
        assertThat(concrete, containsInAnyOrder(ModelOne.class, ModelTwo.class));
    }

    @Test
    public void testConcreteSortedByOrder() {
        Map<Class<?>, Collection<Class<?>>> models = JsonConfigScanner.collectModels("test.scan.sorted.order");
        Collection<Class<?>> concrete = models.get(ConcretePOJO2.class);

        assertThat(models.size(), is(1));
        assertThat(concrete, notNullValue());
        assertThat(concrete.size(), is(2));
        assertThat(concrete, contains(
                test.scan.sorted.order.ModelTwo.class,
                test.scan.sorted.order.ModelOne.class));
    }

    @Test
    public void testConcreteSortedByPriority() {
        Map<Class<?>, Collection<Class<?>>> models = JsonConfigScanner.collectModels("test.scan.sorted.priority");
        Collection<Class<?>> concrete = models.get(ConcretePOJO2.class);

        assertThat(models.size(), is(1));
        assertThat(concrete, notNullValue());
        assertThat(concrete.size(), is(2));
        assertThat(concrete, contains(
                test.scan.sorted.priority.ModelTwo.class,
                test.scan.sorted.priority.ModelOne.class));
    }

    @Test
    public void testConcreteSortedMixed() {
        Map<Class<?>, Collection<Class<?>>> models = JsonConfigScanner.collectModels("test.scan.sorted");
        Collection<Class<?>> concrete = models.get(ConcretePOJO2.class);

        assertThat(models.size(), is(1));
        assertThat(concrete, notNullValue());
        assertThat(concrete.size(), is(4));
        assertThat(concrete, contains(
                test.scan.sorted.order.ModelTwo.class,
                test.scan.sorted.priority.ModelTwo.class,
                test.scan.sorted.order.ModelOne.class,
                test.scan.sorted.priority.ModelOne.class));
    }
}
