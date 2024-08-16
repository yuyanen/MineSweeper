package org.example;


/**
 * Represents a single cell in the Minesweeper grid.
 * Manages whether the cell contains a mine, the count of adjacent mines, and its revealed state.
 *
 * Design Overview:
 * - The Cell class encapsulates the state and behavior of an individual cell within the Minesweeper grid.
 * - Each cell tracks whether it contains a mine, the number of adjacent mines, and whether it has been revealed.
 *
 * Assumptions:
 * - A cell can either contain a mine or not, and its state remains consistent throughout the game.
 * - The number of adjacent mines is calculated once during grid initialization and does not change.
 */
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
