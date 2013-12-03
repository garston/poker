package poker.helpers;

import poker.domain.Card;

import static poker.domain.Num.*;
import static poker.domain.Suit.*;

public class CardRepo {
    public static final Card KH = new Card(KING, HEARTS);
    public static final Card KD = new Card(KING, DIAMONDS);
    public static final Card S10 = new Card(TEN, SPADES);
    public static final Card C10 = new Card(TEN, CLUBS);
    public static final Card D2 = new Card(TWO, DIAMONDS);
    public static final Card H2 = new Card(TWO, HEARTS);
    public static final Card S4 = new Card(FOUR, SPADES);
    public static final Card C4 = new Card(FOUR, CLUBS);
    public static final Card AH = new Card(ACE, HEARTS);
    public static final Card AD = new Card(ACE, DIAMONDS);
    public static final Card AS = new Card(ACE, SPADES);
    public static final Card H7 = new Card(SEVEN, HEARTS);
    public static final Card S6 = new Card(SIX, SPADES);
    public static final Card D5 = new Card(FIVE, DIAMONDS);
    public static final Card H3 = new Card(THREE, HEARTS);
    public static final Card D10 = new Card(TEN, DIAMONDS);
    public static final Card H5 = new Card(FIVE, HEARTS);
    public static final Card C2 = new Card(TWO, CLUBS);
    public static final Card H8 = new Card(EIGHT, HEARTS);
    public static final Card JH = new Card(JACK, HEARTS);
    public static final Card H9 = new Card(NINE, HEARTS);
    public static final Card D8 = new Card(EIGHT, DIAMONDS);
}
