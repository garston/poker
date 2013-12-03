package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static poker.domain.Card.card;
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
                card(EIGHT, HEARTS),
                card(TEN, DIAMONDS),
                card(KING, HEARTS),
                card(TWO, DIAMONDS)
        ), containsOnly(card(KING, HEARTS)));
    }
}
