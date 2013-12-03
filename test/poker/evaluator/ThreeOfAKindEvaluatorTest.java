package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.*;
import static poker.helpers.IterableContainsOnly.containsOnly;

@Test
public class ThreeOfAKindEvaluatorTest {
    private ThreeOfAKindEvaluator evaluator;

    @BeforeMethod
    public void setUp() {
        evaluator = new ThreeOfAKindEvaluator();
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
