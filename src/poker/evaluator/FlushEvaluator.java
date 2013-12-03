package poker.evaluator;

import poker.domain.Card;
import poker.domain.Suit;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.sort;
import static poker.comparator.CardComparators.byNumber;
import static poker.util.CardUtil.partitionBySuit;

public class FlushEvaluator implements Evaluator {
    @Override
    public List<Card> evaluate(Card... cards) {
        Map<Suit, List<Card>> cardsBySuit = partitionBySuit(cards);
        for (Suit suit : Suit.values()) {
            List<Card> cardsInSuit = cardsBySuit.get(suit);
            if (cardsInSuit != null && cardsInSuit.size() >= 5) {
                sort(cardsInSuit, byNumber());
                return cardsInSuit.subList(0, 5);
            }
        }
        return newArrayList();
    }
}
