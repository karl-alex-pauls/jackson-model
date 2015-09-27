package test.scan.sorted.priority;

import karl.codes.jackson.config.JsonModel;
import test.model.ConcretePOJO2;

import javax.annotation.Priority;

/**
 * Created by karl on 9/17/15.
 */
@JsonModel(ConcretePOJO2.class)
@Priority(2)
public class ModelTwo {
}
