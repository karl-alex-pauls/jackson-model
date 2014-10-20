package kap.jackson.config;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import kap.springframework.config.AnnotationScannerBuilder;

import java.util.Collection;
import java.util.Map;

/**
 * Uses AnnotationScanner to
 */
public class JsonConfigScanner {
    private static final AnnotationScannerBuilder<Class<?>> scanner =
            new AnnotationScannerBuilder<Class<?>>()
            .enableJava8Support()
            .map(JsonModel.class,
                    new Function<JsonModel, Class<?>>() {
                        @Override
                        public Class<?> apply(JsonModel jsonModel) {
                            return jsonModel.value();
                        }
                    },
                    new Predicate<JsonModel>() {
                        @Override
                        public boolean apply(JsonModel jsonModel) {
                            return jsonModel.value() != null;
                        }
                    });

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
