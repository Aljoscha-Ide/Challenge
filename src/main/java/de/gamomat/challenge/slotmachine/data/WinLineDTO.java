package de.gamomat.challenge.slotmachine.data;

import java.util.ArrayList;

// In this case it's the same as the WinLine, but is used for the frontend.
public class WinLineDTO {
    //TODO: Use proper currency formatting for the frontend...
    private Double winAmount;
    private ArrayList<WinSymbol> winSymbols;

    public WinLineDTO(WinLine winLine) {
        this.winAmount = winLine.getWinAmount();
        this.winSymbols = winLine.getWinSymbols();
    }

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
