package TriantaEna.Enums;

public enum Suit {
    Heart("Hearts"),
    Spade("Spades"),
    Club("Clubs"),
    Diamond("Diamonds");

    private String name;

    private Suit(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
