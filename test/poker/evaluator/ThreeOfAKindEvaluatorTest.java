package poker.evaluator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.*;
import static poker.helpers.IterableContainsOnly.containsOnly;

public class ThreeOfAKindEvaluatorTest extends EvaluatorTest {
    public ThreeOfAKindEvaluatorTest() {
        super(new ThreeOfAKindEvaluator());
    }

    public void shouldFindWhenThreeNumbersAreSame() {
        assertThat(evaluator.evaluate(AH, AD, AS), containsOnly(AH, AD, AS));
    }

    public void shouldNotFindWhenNumbersAreDifferent() {
        assertThat(evaluator.evaluate(AH, AD, KH).size(), is(0));
    }

    public void shouldFindAmongstCards() {
        assertThat(evaluator.evaluate(AH, KH, AD, AS), containsOnly(AH, AD, AS));
    }
}
