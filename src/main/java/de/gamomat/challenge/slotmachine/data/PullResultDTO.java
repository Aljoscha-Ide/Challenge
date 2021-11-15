package de.gamomat.challenge.slotmachine.data;

import com.google.common.collect.TreeBasedTable;

import java.util.ArrayList;


public class PullResultDTO {

    private TreeBasedTable<Integer, Integer, Symbol> resultMatrix;
    private ArrayList<WinLineDTO> winLines;
    private Double totalWinAmount;

    public PullResultDTO(final TreeBasedTable<Integer, Integer, Symbol> resultMatrix) {
        this.resultMatrix = resultMatrix;
    }

    public TreeBasedTable<Integer, Integer, Symbol> getResultMatrix() {
        return resultMatrix;
    }

    public void setResultMatrix(final TreeBasedTable<Integer, Integer, Symbol> resultMatrix) {
        this.resultMatrix = resultMatrix;
    }

    public ArrayList<WinLineDTO> getWinLines() {
        return winLines;
    }

    public void setWinLines(final ArrayList<WinLineDTO> winLines) {
        this.winLines = winLines;
    }

    public Double getTotalWinAmount() {
        return totalWinAmount;
    }

    public void setTotalWinAmount(final Double totalWinAmount) {
        this.totalWinAmount = totalWinAmount;
    }
}
