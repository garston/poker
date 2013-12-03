package poker.evaluator;

import poker.domain.Card;

import java.util.List;

public interface Evaluator {
    List<Card> evaluate(Card... cards);
}
