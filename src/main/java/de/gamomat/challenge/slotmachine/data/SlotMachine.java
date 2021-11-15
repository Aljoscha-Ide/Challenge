package de.gamomat.challenge.slotmachine.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SlotMachine {
    private String id;
    // Not sure what to name this (number of rows the "result"-matrix has)
    private Integer resultSize;
    private HashMap<Integer, Reel> reels;
    private ArrayList<WinLine> WinLines;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Integer getResultSize() {
        return resultSize;
    }

    public void setResultSize(final Integer resultSize) {
        this.resultSize = resultSize;
    }

    public HashMap<Integer, Reel> getReels() {
        return reels;
    }

    public void setReels(final HashMap<Integer, Reel> reels) {
        this.reels = reels;
    }

    public ArrayList<WinLine> getWinLines() {
        return WinLines;
    }

    public void setWinLines(final ArrayList<WinLine> winLines) {
        WinLines = winLines;
    }
}
