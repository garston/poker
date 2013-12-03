package poker.evaluator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.*;
import static poker.helpers.IterableContainsOnly.containsOnly;

public class TwoPairEvaluatorTest extends EvaluatorTest {
    public TwoPairEvaluatorTest() {
        super(new TwoPairEvaluator());
    }

    public void shouldFindTwoPair() {
        assertThat(evaluator.evaluate(KH, D2, C10, H2, KD), containsOnly(KH, KD, D2, H2));
    }

    public void shouldNotFindOnePair() {
        assertThat(evaluator.evaluate(KH, D2, KD).size(), is(0));
    }

    public void shouldNotLookForSecondPairIfNoFirstPair() {
        assertThat(evaluator.evaluate(KH, D2, C10).size(), is(0));
    }

    public void shouldFindHighestTwoPair() {
        assertThat(evaluator.evaluate(KH, D2, C10, H2, C4, KD, S4, S10), containsOnly(KH, KD, S10, C10));
    }
}
