package karl.codes.springframework.config;

import org.junit.Test;
import test.model.WatchedByThingA;

import java.util.Collection;
import java.util.Map;

/**
 * Created by karl on 9/17/15.
 */
public class AnnotationScannerJ8Test {
    @Test
    public void testWatchedThing() {
        AnnotationScannerBuilder.AnnotationScanTask<Class<?>> scanner = AnnotationScannerFixture.newBuilder()
                .enableJava8Support()
                .build();

        Map<Class<?>, Collection<Class<?>>> models = scanner.toMap("test.scan.a");

        AnnotationScannerFixture.validateModels(models, 1, WatchedByThingA.class, 1);
    }
}
