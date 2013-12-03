package poker.evaluator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static poker.helpers.CardRepo.AD;
import static poker.helpers.CardRepo.AH;
import static poker.helpers.CardRepo.KH;
import static poker.helpers.IterableContainsOnly.containsOnly;

@Test
public class PairEvaluatorTest {
    private PairEvaluator evaluator;

    @BeforeMethod
    public void setUp() throws Exception {
        evaluator = new PairEvaluator();
    }

    public void shouldFindWhenNumbersAreSame() {
        assertThat(evaluator.evaluate(AH, AD), containsOnly(AH, AD));
    }

    public void shouldNotFindWhenNumbersAreDifferent() {
        assertThat(evaluator.evaluate(AH, KH).size(), is(0));
    }

    public void shouldFindAmongstCards() {
        assertThat(evaluator.evaluate(AH, KH, AD), containsOnly(AH, AD));
    }
}
