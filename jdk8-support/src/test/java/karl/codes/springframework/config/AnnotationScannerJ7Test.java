package karl.codes.springframework.config;

import org.junit.Test;
import test.annotations.A;
import test.model.WatchedByThingA;

import java.util.Collection;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by karl on 9/17/15.
 */
public class AnnotationScannerJ7Test {
    @Test
    public void testWatchedThing() {
        AnnotationScannerBuilder.AnnotationScanTask scanner = AnnotationScannerFixture.newBuilder()
                .build();

        Map<Class<?>, Collection<Class<?>>> models = scanner.toMap("test.scan.a");

        AnnotationScannerFixture.validateModels(models, 1, WatchedByThingA.class, 1);
    }
}
