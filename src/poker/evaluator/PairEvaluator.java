package poker.evaluator;

import poker.domain.Card;
import poker.domain.Num;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public class PairEvaluator implements Evaluator {
    @Override
    public List<Card> evaluate(Card... cards) {
        Map<Num, Card> seen = newHashMap();
        for (Card card : cards) {
            Card sameNumCard = seen.get(card.getNum());
            if (sameNumCard != null) {
                return newArrayList(sameNumCard, card);
            }

            seen.put(card.getNum(), card);
        }

        return newArrayList();
    }
}
