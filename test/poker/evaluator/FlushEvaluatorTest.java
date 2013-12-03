package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poker.domain.Card;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.domain.Num.*;
import static poker.domain.Suit.DIAMONDS;
import static poker.domain.Suit.HEARTS;
import static poker.matchers.IterableContainsOnly.containsOnly;

@Test
public class FlushEvaluatorTest {
    private FlushEvaluator evaluator;
    private Card kh;
    private Card jh;
    private Card h9;
    private Card h7;
    private Card h5;
    private Card h3;
    private Card d8;

    @BeforeMethod
    public void setUp() {
        evaluator = new FlushEvaluator();
        kh = new Card(KING, HEARTS);
        jh = new Card(JACK, HEARTS);
        h9 = new Card(NINE, HEARTS);
        h7 = new Card(SEVEN, HEARTS);
        h5 = new Card(FIVE, HEARTS);
        h3 = new Card(THREE, HEARTS);
        d8 = new Card(EIGHT, DIAMONDS);
    }

    public void shouldFindFiveCardsOfSameSuit() {
        assertThat(evaluator.evaluate(jh, h9, h5, d8, h3, kh), containsOnly(kh, jh, h9, h5, h3));
    }

    public void shouldFindHighestFlush() {
        assertThat(evaluator.evaluate(jh, h9, h5, h7, h3, kh), containsOnly(kh, jh, h9, h7, h5));
    }

    public void shouldNotFindFourCardFlush() {
        assertThat(evaluator.evaluate(jh, h9, h5, h7).size(), is(0));
    }
}
