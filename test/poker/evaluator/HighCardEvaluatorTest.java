package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poker.domain.Card;

import static org.hamcrest.MatcherAssert.assertThat;
import static poker.domain.Num.*;
import static poker.domain.Suit.DIAMONDS;
import static poker.domain.Suit.HEARTS;
import static poker.matchers.IterableContainsOnly.containsOnly;

@Test
public class HighCardEvaluatorTest {
    private HighCardEvaluator evaluator;

    @BeforeMethod
    public void setUp() {
        evaluator = new HighCardEvaluator();
    }

    public void shouldReturnHighestCard() {
        assertThat(evaluator.evaluate(
                new Card(EIGHT, HEARTS),
                new Card(TEN, DIAMONDS),
                new Card(KING, HEARTS),
                new Card(TWO, DIAMONDS)
        ), containsOnly(new Card(KING, HEARTS)));
    }
}
