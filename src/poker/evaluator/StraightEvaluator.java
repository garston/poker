package poker.evaluator;

import com.google.common.collect.Iterables;
import poker.domain.Card;
import poker.domain.Num;
import poker.util.CardUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;
import static poker.domain.Num.ACE;
import static poker.util.CardUtil.partitionByNumber;

public class StraightEvaluator implements Evaluator {
    @Override
    public List<Card> evaluate(Card... cards) {
        Map<Num, List<Card>> cardsByNumber = partitionByNumber(cards);
        List<Card> straight = newArrayList();
        for (Num num : concat(asList(Num.values()), asList(ACE))) {
            if (cardsByNumber.get(num) == null) {
                straight = newArrayList();
            } else {
                straight.add(cardsByNumber.get(num).get(0));

                if (straight.size() == 5) {
                    return straight;
                }
            }
        }

        return newArrayList();
    }
}
