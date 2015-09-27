package test.scan.sorted.order;

import karl.codes.jackson.config.JsonModel;
import org.springframework.core.annotation.Order;
import test.model.ConcretePOJO2;

/**
 * Created by karl on 9/17/15.
 */
@JsonModel(ConcretePOJO2.class)
@Order(1)
public class ModelTwo {
}
