package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poker.domain.Card;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.domain.Num.*;
import static poker.domain.Suit.*;
import static poker.matchers.IterableContainsOnly.containsOnly;

@Test
public class TwoPairEvaluatorTest {
    private TwoPairEvaluator evaluator;
    private Card kh;
    private Card kd;
    private Card s10;
    private Card c10;
    private Card d2;
    private Card h2;
    private Card s4;
    private Card c4;

    @BeforeMethod
    public void setUp() {
        evaluator = new TwoPairEvaluator();
        kh = new Card(KING, HEARTS);
        kd = new Card(KING, DIAMONDS);
        s10 = new Card(TEN, SPADES);
        c10 = new Card(TEN, CLUBS);
        s4 = new Card(FOUR, SPADES);
        c4 = new Card(FOUR, CLUBS);
        d2 = new Card(TWO, DIAMONDS);
        h2 = new Card(TWO, HEARTS);
    }

    public void shouldFindTwoPair() {
        assertThat(evaluator.evaluate(kh, d2, c10, h2, kd), containsOnly(kh, kd, d2, h2));
    }

    public void shouldNotFindOnePair() {
        assertThat(evaluator.evaluate(kh, d2, kd).size(), is(0));
    }

    public void shouldNotLookForSecondPairIfNoFirstPair() {
        assertThat(evaluator.evaluate(kh, d2, c10).size(), is(0));
    }

    public void shouldFindHighestTwoPair() {
        assertThat(evaluator.evaluate(kh, d2, c10, h2, c4, kd, s4, s10), containsOnly(kh, kd, s10, c10));
    }
}
