package karl.codes.jackson.config;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;
import karl.codes.springframework.config.AnnotationScannerBuilder;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.Collection;
import java.util.Map;

/**
 * Uses AnnotationScanner to
 */
public class JsonConfigScanner {
    private static final AnnotationScannerBuilder<Class<?>> scanner =
            new AnnotationScannerBuilder<Class<?>>()
            .enableJava8Support()
            .map(JsonModel.class, JsonModel.GET_VALUE, JsonModel.VALUE_NOT_NULL)
            .orderBy(Ordering.from(AnnotationAwareOrderComparator.INSTANCE)
                    .thenComparing(Ordering.arbitrary()))
            ;

//    private static final AnnotationScannerBuilder<QualifiedJsonModelAssignment> qualifiedScanner =
//            new AnnotationScannerBuilder<QualifiedJsonModelAssignment>()
//            .enableJava8Support()
//            .enableMetaAnnotation()
//            .map(JsonModel.class, it -> it.)
//
    public static Map<Class<?>, Collection<Class<?>>>
    collectModels(String basePackage) {
        return scanner.build().toMap(basePackage);
    }
}
