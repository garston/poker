package poker.evaluator;

import poker.domain.Card;
import poker.domain.Num;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public class ThreeOfAKindEvaluator implements Evaluator {
    @Override
    public List<Card> evaluate(Card... cards) {
        Map<Num, List<Card>> seen = newHashMap();
        for (Card card : cards) {
            List<Card> sameNumCards = seen.get(card.getNum());
            if(sameNumCards == null){
                sameNumCards = newArrayList();
                seen.put(card.getNum(), sameNumCards);
            }

            sameNumCards.add(card);

            if (sameNumCards.size() == 3) {
                return sameNumCards;
            }
        }

        return newArrayList();
    }
}
