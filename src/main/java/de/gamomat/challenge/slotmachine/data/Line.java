package de.gamomat.challenge.slotmachine.data;

public class Line {
    private Integer index;
    private Double winAmount;

    public Line(final Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(final Integer index) {
        this.index = index;
    }

    public Double getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(final Double winAmount) {
        this.winAmount = winAmount;
    }
}
