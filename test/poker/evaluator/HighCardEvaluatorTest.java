package poker.evaluator;

import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.*;
import static poker.helpers.IterableContainsOnly.containsOnly;

public class HighCardEvaluatorTest extends EvaluatorTest {
    public HighCardEvaluatorTest() {
        super(new HighCardEvaluator());
    }

    public void shouldReturnHighestCard() {
        assertThat(evaluator.evaluate(H8, D10, KH, D2), containsOnly(KH));
    }
}
