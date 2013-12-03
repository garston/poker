package poker.util;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import poker.domain.Card;
import poker.domain.Num;
import poker.domain.Suit;

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
        return partitionBy(cards, new Function<Card, Num>() {
            @Override
            public Num apply(Card card) {
                return card.getNum();
            }
        });
    }

    public static Map<Suit, List<Card>> partitionBySuit(Card... cards) {
        return partitionBy(cards, new Function<Card, Suit>() {
            @Override
            public Suit apply(Card card) {
                return card.getSuit();
            }
        });
    }

    private static <T> Map<T, List<Card>> partitionBy(Card[] cards, Function<Card, T> f) {
        Map<T, List<Card>> map = newHashMap();
        for (Card card : cards) {
            List<Card> sameCards = map.get(f.apply(card));
            if (sameCards == null) {
                sameCards = newArrayList();
                map.put(f.apply(card), sameCards);
            }

            sameCards.add(card);
        }
        return map;
    }
}
