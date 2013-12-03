package poker.evaluator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.*;
import static poker.helpers.IterableContainsOnly.containsOnly;

public class PairEvaluatorTest extends EvaluatorTest {
    public PairEvaluatorTest() {
        super(new PairEvaluator());
    }

    public void shouldFindWhenNumbersAreSame() {
        assertThat(evaluator.evaluate(AH, AD), containsOnly(AH, AD));
    }

    public void shouldNotFindWhenNumbersAreDifferent() {
        assertThat(evaluator.evaluate(AH, KH).size(), is(0));
    }

    public void shouldFindAmongstCards() {
        assertThat(evaluator.evaluate(AH, KH, AD), containsOnly(AH, AD));
    }
}
