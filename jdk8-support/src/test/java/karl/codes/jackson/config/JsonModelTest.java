package karl.codes.jackson.config;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
import org.junit.Test;
import test.model.ConcretePOJO1;
import test.model.ConcretePOJO2;
import test.scan.pojo1.ModelOne;
import test.scan.pojo1.ModelTwo;

import java.util.Arrays;
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
        assertThat(concrete, equalTo(Arrays.asList(ModelOne.class, ModelTwo.class)));
    }

    @Test
    @Ignore("need to implement Order, Priority comparator")
    public void testConcretePOJO2() {
        Map<Class<?>, Collection<Class<?>>> models = JsonConfigScanner.collectModels("test.scan.pojo2");
        Collection<Class<?>> concrete = models.get(ConcretePOJO2.class);

        assertThat(models.size(), is(1));
        assertThat(concrete, notNullValue());
        assertThat(concrete.size(), is(2));
        assertThat(concrete, equalTo(Arrays.asList(test.scan.pojo2.ModelTwo.class, test.scan.pojo2.ModelOne.class)));
    }
}
