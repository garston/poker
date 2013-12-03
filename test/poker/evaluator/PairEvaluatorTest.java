package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import poker.domain.Card;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.domain.Num.ACE;
import static poker.domain.Num.KING;
import static poker.domain.Suit.DIAMONDS;
import static poker.domain.Suit.HEARTS;
import static poker.matchers.IterableContainsOnly.containsOnly;

@Test
public class PairEvaluatorTest {
    private PairEvaluator evaluator;
    private Card ah;
    private Card ad;
    private Card kh;

    @BeforeMethod
    public void setUp() throws Exception {
        evaluator = new PairEvaluator();
        ah = new Card(ACE, HEARTS);
        ad = new Card(ACE, DIAMONDS);
        kh = new Card(KING, HEARTS);
    }

    public void shouldFindWhenNumbersAreSame() {
        assertThat(evaluator.evaluate(ah, ad), containsOnly(ah, ad));
    }

    public void shouldNotFindWhenNumbersAreDifferent() {
        assertThat(evaluator.evaluate(ah, kh).size(), is(0));
    }

    public void shouldFindAmongstCards() {
        assertThat(evaluator.evaluate(ah, kh, ad), containsOnly(ah, ad));
    }
}
