package karl.codes.jackson.config;

import org.junit.Test;
import test.model.ConcretePOJO1QualifiedOne;
import test.scan.where.ModelOne;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by karl on 9/23/15.
 */
public class QualifiedJsonModelAssignmentTest {

    @Test
    public void testMatches() throws Exception {
        QualifiedJsonModelAssignment qualified = new QualifiedJsonModelAssignment(ModelOne.class);

        assertThat(qualified.matches(ConcretePOJO1QualifiedOne.class), is(true));
    }
}