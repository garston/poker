package poker.domain;

public class Card {
    private Num num;

    private Suit suit;
    public Card(Num num, Suit suit) {
        this.num = num;
        this.suit = suit;
    }

    public Num getNum() {
        return num;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (num != card.num) return false;
        if (suit != card.suit) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }
}
