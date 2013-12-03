package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.*;
import static poker.helpers.IterableContainsOnly.containsOnly;

@Test
public class StraightEvaluatorTest {
    private StraightEvaluator evaluator;

    @BeforeMethod
    public void setUp() {
        evaluator = new StraightEvaluator();
    }

    public void shouldFindFiveCardsInARow() {
        assertThat(evaluator.evaluate(H3, D10, D5, C4, H7, S6), containsOnly(H7, S6, D5, C4, H3));
    }

    public void shouldFindFiveCardsInARowEvenIfTheresMultipleOfSameNumber() {
        assertThat(evaluator.evaluate(H3, H5, D5, C4, H7, S6), containsOnly(H7, S6, H5, C4, H3));
    }

    public void shouldFindHighestStraight() {
        assertThat(evaluator.evaluate(H3, C2, D5, C4, H7, S6), containsOnly(H7, S6, D5, C4, H3));
    }

    public void shouldFindWheelStraight() {
        assertThat(evaluator.evaluate(H3, C2, D5, C4, AD), containsOnly(D5, C4, H3, C2, AD));
    }
}
