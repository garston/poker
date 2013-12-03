package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.*;
import static poker.helpers.IterableContainsOnly.containsOnly;

@Test
public class FlushEvaluatorTest {
    private FlushEvaluator evaluator;

    @BeforeMethod
    public void setUp() {
        evaluator = new FlushEvaluator();
    }

    public void shouldFindFiveCardsOfSameSuit() {
        assertThat(evaluator.evaluate(JH, H9, H5, D8, H3, KH), containsOnly(KH, JH, H9, H5, H3));
    }

    public void shouldFindHighestFlush() {
        assertThat(evaluator.evaluate(JH, H9, H5, H7, H3, KH), containsOnly(KH, JH, H9, H7, H5));
    }

    public void shouldNotFindFourCardFlush() {
        assertThat(evaluator.evaluate(JH, H9, H5, H7).size(), is(0));
    }
}
