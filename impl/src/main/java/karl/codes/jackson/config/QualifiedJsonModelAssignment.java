package karl.codes.jackson.config;

import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.security.access.annotation.Secured;

/**
 * @see JsonModel#where()
 */
@Deprecated
public class QualifiedJsonModelAssignment {
    private Class<?> jsonMixin;
    private int order;
    private JsonModel model;
    private QualifiedJsonModelAssignment orElse;

    public QualifiedJsonModelAssignment(Class<?> annotatedClass) {
        model = annotatedClass.getAnnotation(JsonModel.class);
        jsonMixin = annotatedClass;
        orElse = model==null?null : new QualifiedJsonModelAssignment(model.orElse());

        assert model == null || this.matches(model.value());
    }

    public Where[] getWhere() {
        return model==null?new Where[0] : model.where();
    }

    public boolean matches(Class<?> target) {
//        if (!concrete.isAssignableFrom(target)) {
//            return false;
//        }
        if(model == null) return true;

        BeanDefinition targetBean = new AnnotatedGenericBeanDefinition(target);
        // TODO set qualifiers

        nextWhere:
        for(Where orWhere : getWhere()) {
            GenericBeanDefinition definition = new GenericBeanDefinition();

            for(Qualifier andQualifier : orWhere.value()) {
                definition.addQualifier(new AutowireCandidateQualifier(
                        andQualifier.getClass(),
                        andQualifier.value()));
            }

            // assign class without assigning qualifiers
            definition.setBeanClass(target);
            if( !definition.equals(targetBean) )
                continue nextWhere;

            for(Class<?> andPrototype : orWhere.prototype()) {
                AnnotatedGenericBeanDefinition protoBean = new AnnotatedGenericBeanDefinition(andPrototype);
                protoBean.setBeanClass(target);

                if( !protoBean.equals(targetBean) )
                    continue nextWhere;
            }

            return true;
        }

        return false;

    }

    public QualifiedJsonModelAssignment next() {
        return orElse;
    }
}
