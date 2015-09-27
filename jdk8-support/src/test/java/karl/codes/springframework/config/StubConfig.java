package karl.codes.springframework.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.model.ConcretePOJO1;

/**
 * Created by karl on 9/23/15.
 */
@Configuration
public class StubConfig {
    @Bean
    @Qualifier("one")
    public ConcretePOJO1 beanPOJO1QualifiedOne() {
        return new ConcretePOJO1();
    }
}
