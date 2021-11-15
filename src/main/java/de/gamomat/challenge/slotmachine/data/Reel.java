package de.gamomat.challenge.slotmachine.data;

import java.util.LinkedList;

public class Reel {
    private String id;
    private LinkedList<Symbol> symbols;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public LinkedList<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(final LinkedList<Symbol> symbols) {
        this.symbols = symbols;
    }
}
