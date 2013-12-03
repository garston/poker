package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poker.domain.Card;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.domain.Num.ACE;
import static poker.domain.Num.KING;
import static poker.domain.Suit.*;
import static poker.matchers.IterableContainsOnly.containsOnly;

@Test
public class ThreeOfAKindEvaluatorTest {
    private ThreeOfAKindEvaluator evaluator;
    private Card ah;
    private Card ad;
    private Card kh;
    private Card as;

    @BeforeMethod
    public void setUp() {
        evaluator = new ThreeOfAKindEvaluator();
        ah = new Card(ACE, HEARTS);
        ad = new Card(ACE, DIAMONDS);
        as = new Card(ACE, SPADES);
        kh = new Card(KING, HEARTS);
    }

    public void shouldFindWhenThreeNumbersAreSame() {
        assertThat(evaluator.evaluate(ah, ad, as), containsOnly(ah, ad, as));
    }

    public void shouldNotFindWhenNumbersAreDifferent() {
        assertThat(evaluator.evaluate(ah, ad, kh).size(), is(0));
    }

    public void shouldFindAmongstCards() {
        assertThat(evaluator.evaluate(ah, kh, ad, as), containsOnly(ah, ad, as));
    }
}
