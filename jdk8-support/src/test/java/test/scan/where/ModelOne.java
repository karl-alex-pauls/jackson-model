package test.scan.where;

import karl.codes.jackson.config.JsonModel;
import karl.codes.jackson.config.Where;
import org.springframework.beans.factory.annotation.Qualifier;
import test.model.ConcretePOJO1;

/**
 * Created by karl on 9/23/15.
 */
@JsonModel(value = ConcretePOJO1.class,
    where = @Where(@Qualifier("one")),
    orElse = ModelTwo.class)
public class ModelOne {
}
