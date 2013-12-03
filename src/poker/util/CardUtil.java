package poker.util;

import com.google.common.base.Predicate;
import poker.domain.Card;
import poker.domain.Num;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

public class CardUtil {
    public static List<Card> findSameNumberedCards(final int minNumberRequired, Card... cards) {
        try {
            return find(partitionByNumber(cards).values(), new Predicate<List<Card>>() {
                @Override
                public boolean apply(List<Card> cards) {
                    return cards.size() >= minNumberRequired;
                }
            });
        } catch (NoSuchElementException e) {
            return newArrayList();
        }
    }

    public static Map<Num, List<Card>> partitionByNumber(Card... cards) {
        Map<Num, List<Card>> map = newHashMap();
        for (Card card : cards) {
            List<Card> sameNumCards = map.get(card.getNum());
            if (sameNumCards == null) {
                sameNumCards = newArrayList();
                map.put(card.getNum(), sameNumCards);
            }

            sameNumCards.add(card);
        }
        return map;
    }
}
