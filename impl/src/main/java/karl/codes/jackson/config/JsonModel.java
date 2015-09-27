package karl.codes.jackson.config;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import java.lang.annotation.*;

/**
 * Specifies a concrete class for the annotated class which defines Jackson Mix-In annotations. In
 * other words classes annotated with @JsonModel are the source of the annotations, the class specified
 * in value is the destination.
 *
 * Specify "orElse" or use @Order on the annotated class to specify the order in which @where conditions
 * are evaluated (If both strategies are mixed then types declaring @Order are sorted, "orElse" children
 * are evaluated and inserted into the list where order has been specified (excluding duplicates). Then
 * finally all models which remain orphaned are prepended to the ruleset. This means that "orElse" may
 * drastically alter a model's evaluation priority, tho it is more expressive.)
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonModel {
    Function<JsonModel, Class<?>> GET_VALUE = new Function<JsonModel, Class<?>>() {
        @Override
        public Class<?> apply(JsonModel annotation) {
            return annotation.value();
        }
    };

    Predicate<JsonModel> VALUE_NOT_NULL = new Predicate<JsonModel>() {
        @Override
        public boolean apply(JsonModel annotation) {
            return annotation.value() != null;
        }
    };

    /**
     * The concrete class which will benefit from the annotated class's type and field annotations
     */
    Class<?> value();

    /**
     * Sets of @Qualifiers and meta-annotation prototypes to limit the assignment of this mix-in. One of
     * the @Where clauses must be matched (logical OR) and all qualifiers and prototypes in a @Where
     * must match (logical AND).
     * <p>
     * For example a class annotated with @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')" would restrict
     * the mapping of the concrete data to JsonModel such that the requesting session would have the
     * ROLE_ADMINISTRATOR permission.
     *
     * @deprecated not ready
     */
    @Deprecated
    Where[] where() default @Where;

    /**
     * The model to evaluate next for the given concrete type if the where clause is not satisfied.
     *
     * @deprecated not ready
     */
    @Deprecated
    Class<?> orElse() default Object.class;
}
