package poker.domain;

import org.testng.annotations.Test;
import poker.domain.Card;

import static poker.domain.Num.ACE;
import static poker.domain.Suit.HEARTS;

@Test
public class CardTest {
    public void shouldHaveSuitAndNumber() {
        Card card = new Card(ACE, HEARTS);
    }
}
