package org.example;

public class Cell {
    private boolean hasMine;
    private int adjacentMines;
    private boolean isRevealed;

    public Cell() {
        this.hasMine = false;
        this.adjacentMines = 0;
        this.isRevealed = false;
    }

    public boolean hasMine() {
        return hasMine;
    }

    public void setMine() {
        this.hasMine = true;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int count) {
        this.adjacentMines = count;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        this.isRevealed = true;
    }
}
