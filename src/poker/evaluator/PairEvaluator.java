package poker.evaluator;

import poker.domain.Card;

import java.util.List;

import static poker.util.CardUtil.findSameNumberedCards;

public class PairEvaluator implements Evaluator {
    @Override
    public List<Card> evaluate(Card... cards) {
        return findSameNumberedCards(2, cards);
    }
}
