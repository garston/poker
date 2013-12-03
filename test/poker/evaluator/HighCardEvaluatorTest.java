package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.*;
import static poker.helpers.IterableContainsOnly.containsOnly;

@Test
public class HighCardEvaluatorTest {
    private HighCardEvaluator evaluator;

    @BeforeMethod
    public void setUp() {
        evaluator = new HighCardEvaluator();
    }

    public void shouldReturnHighestCard() {
        assertThat(evaluator.evaluate(H8, D10, KH, D2), containsOnly(KH));
    }
}
