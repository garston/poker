package poker.evaluator;

import poker.domain.Card;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.sort;
import static poker.comparator.CardComparators.byNumber;

public class HighCardEvaluator implements Evaluator {
    @Override
    public List<Card> evaluate(Card... cards) {
        List<Card> cardList = newArrayList(cards);
        sort(cardList, byNumber());
        return newArrayList(cardList.get(0));
    }

}
