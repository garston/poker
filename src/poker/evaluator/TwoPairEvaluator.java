package poker.evaluator;

import poker.domain.Card;
import poker.domain.Num;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Lists.newArrayList;
import static poker.util.CardUtil.partitionByNumber;

public class TwoPairEvaluator implements Evaluator {
    @Override
    public List<Card> evaluate(Card... cards) {
        Map<Num, List<Card>> cardsByNumber = partitionByNumber(cards);
        List<Card> firstPair = null;
        for (Num num : Num.values()) {
            List<Card> possiblePair = cardsByNumber.get(num);
            if (possiblePair != null && possiblePair.size() >= 2) {
                if (firstPair == null) {
                    firstPair = possiblePair;
                } else {
                    return newArrayList(concat(firstPair, possiblePair));
                }
            }
        }

        return newArrayList();
    }
}
