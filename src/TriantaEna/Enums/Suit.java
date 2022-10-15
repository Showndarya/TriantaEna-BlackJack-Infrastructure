package TriantaEna.Enums;

public enum Suit {
    /*
     * Enum to represent the four suits of cards.
     */
    Heart("Hearts", "♥"),
    Spade("Spades","♠ "),
    Club("Clubs","♣"),
    Diamond("Diamonds","♦");

    private String name;
    private String display;

    private Suit(String name, String display) {
        this.name = name;
        this.display = display;
    }

    public String toString() {
        return name;
    }
    
    public String GetDisplay() {
        return display;
    }
}
