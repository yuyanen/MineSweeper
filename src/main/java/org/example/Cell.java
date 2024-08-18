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

    // Indicates whether the cell contains a mine.
    private boolean hasMine;

    // Stores the number of mines adjacent to this cell.
    private int adjacentMines;

    // Indicates whether the cell has been revealed by the player.
    private boolean isRevealed;


    /**
     * Initializes a new Cell object.
     * By default, a cell does not contain a mine, has no adjacent mines, and is not revealed.
     */
    public Cell() {
        this.hasMine = false;
        this.adjacentMines = 0;
        this.isRevealed = false;
    }


    /**
     * Checks if the cell contains a mine.
     *
     * @return true if the cell contains a mine, false otherwise.
     */
    public boolean hasMine() {
        return hasMine;
    }

    /**
     * Sets the cell to contain a mine.
     * This method should be called only during grid initialization.
     */
    public void setMine() {
        this.hasMine = true;
    }

    /**
     * Gets the number of mines adjacent to this cell.
     *
     * @return the number of adjacent mines.
     */
    public int getAdjacentMines() {
        return adjacentMines;
    }

    /**
     * Sets the number of mines adjacent to this cell.
     * This method should be called only during grid initialization.
     *
     * @param count the number of adjacent mines.
     */
    public void setAdjacentMines(int count) {
        this.adjacentMines = count;
    }

    /**
     * Checks if the cell has been revealed by the player.
     *
     * @return true if the cell has been revealed, false otherwise.
     */
    public boolean isRevealed() {
        return isRevealed;
    }

    /**
     * Marks the cell as revealed.
     * This method should be called when the player uncovers the cell.
     */
    public void reveal() {
        this.isRevealed = true;
    }
}
