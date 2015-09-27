package karl.codes.jackson.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Ordering;
import karl.codes.springframework.config.AnnotationScannerBuilder;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.Collection;
import java.util.Collections;
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

    /**
     * @param basePackage
     * @return mapping of concrete types to a list of objects annotated with JsonModel
     */
    public static Map<Class<?>, Collection<Class<?>>>
    collectModels(String basePackage) {
        return scanner.build().toMap(basePackage);
    }

    /**
     * @param models see #collectModels
     * @return mapping of qualifier restrictions to related ObjectMappers containing
     * concrete -> model mappings
     */
    public static Map<QualifiedJsonModelAssignment, ObjectMapper>
    buildMappers(Map<Class<?>, Collection<Class<?>>> models) {
        return Collections.emptyMap();
    }
}
