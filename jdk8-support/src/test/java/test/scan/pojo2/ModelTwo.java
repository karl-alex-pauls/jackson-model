package test.scan.pojo2;

import karl.codes.jackson.config.JsonModel;
import org.springframework.core.annotation.Order;
import test.model.ConcretePOJO2;

import javax.annotation.Priority;

/**
 * Created by karl on 9/17/15.
 */
@JsonModel(ConcretePOJO2.class)
@Order(1)
@Priority(1)
public class ModelTwo {
}
