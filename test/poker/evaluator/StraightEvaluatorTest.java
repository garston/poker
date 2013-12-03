package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poker.domain.Card;

import static org.hamcrest.MatcherAssert.assertThat;
import static poker.domain.Num.*;
import static poker.domain.Suit.*;
import static poker.matchers.IterableContainsOnly.containsOnly;

@Test
public class StraightEvaluatorTest {
    private StraightEvaluator evaluator;
    private Card h7;
    private Card s6;
    private Card d5;
    private Card c4;
    private Card h3;
    private Card d10;
    private Card h5;
    private Card c2;
    private Card ad;

    @BeforeMethod
    public void setUp() {
        evaluator = new StraightEvaluator();
        ad = new Card(ACE, DIAMONDS);
        h7 = new Card(SEVEN, HEARTS);
        s6 = new Card(SIX, SPADES);
        d5 = new Card(FIVE, DIAMONDS);
        h5 = new Card(FIVE, HEARTS);
        c4 = new Card(FOUR, CLUBS);
        h3 = new Card(THREE, HEARTS);
        c2 = new Card(TWO, CLUBS);
        d10 = new Card(TEN, DIAMONDS);
    }

    public void shouldFindFiveCardsInARow() {
        assertThat(evaluator.evaluate(h3, d10, d5, c4, h7, s6), containsOnly(h7, s6, d5, c4, h3));
    }

    public void shouldFindFiveCardsInARowEvenIfTheresMultipleOfSameNumber() {
        assertThat(evaluator.evaluate(h3, h5, d5, c4, h7, s6), containsOnly(h7, s6, h5, c4, h3));
    }

    public void shouldFindHighestStraight() {
        assertThat(evaluator.evaluate(h3, c2, d5, c4, h7, s6), containsOnly(h7, s6, d5, c4, h3));
    }

    public void shouldFindWheelStraight() {
        assertThat(evaluator.evaluate(h3, c2, d5, c4, ad), containsOnly(d5, c4, h3, c2, ad));
    }
}
