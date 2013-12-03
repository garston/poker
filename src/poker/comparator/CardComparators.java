package poker.comparator;

import poker.domain.Card;

import java.util.Comparator;

public class CardComparators {
    public static Comparator<Card> byNumber() {
        return new Comparator<Card>() {
            @Override
            public int compare(Card card, Card card2) {
                return card.getNum().ordinal() - card2.getNum().ordinal();
            }
        };
    }
}
