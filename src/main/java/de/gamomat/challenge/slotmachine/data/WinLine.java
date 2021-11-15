package de.gamomat.challenge.slotmachine.data;

import java.util.ArrayList;

public class WinLine {
    private Double winAmount;
    private ArrayList<WinSymbol> winSymbols;

    public Double getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(final Double winAmount) {
        this.winAmount = winAmount;
    }

    public ArrayList<WinSymbol> getWinSymbols() {
        return winSymbols;
    }

    public void setWinSymbols(final ArrayList<WinSymbol> winSymbols) {
        this.winSymbols = winSymbols;
    }
}
