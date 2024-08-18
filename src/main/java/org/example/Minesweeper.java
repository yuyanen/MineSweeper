package org.example;


import java.util.Random;

/**
 * Manages the Minesweeper game logic including grid initialization, mine placement,
 * adjacent mine counting, cell uncovering, and win condition checking.
 *
 * Design Overview:
 * - The Minesweeper class handles the core game logic. It manages a grid of `Cell` objects, placing mines,
 *   calculating adjacent mine counts, and processing user input.
 * - The game board is represented as a 2D array of `Cell` objects, where each cell knows if it contains a mine
 *   and how many mines are adjacent to it.
 *
 * Assumptions:
 * - The grid size and number of mines are determined at the start of the game.
 * - Mines are placed randomly on the grid, and the number of mines is capped at 35% of the total grid squares.
 * - The game continues until the player either uncovers all non-mine cells or uncovers a mine.
 */
public class Minesweeper {

    /** The grid representing the Minesweeper board. Each cell is a `Cell` object. */
    private final Cell[][] grid;

    /** The size of the grid. */
    private final int size;

    /** The number of cells remaining to be uncovered. */
    private int remainingCells;

    /**
     * Constructs a Minesweeper game with a specified grid size and number of mines.
     *
     * @param size The size of the grid
     * @param mineCount The number of mines to place on the grid.
     */
    public Minesweeper(int size, int mineCount) {
        this.size = size;
        this.grid = new Cell[size][size];
        this.remainingCells = size * size;

        // Initialize the grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }

        // Place mines
        placeMines(mineCount);
        // Calculate adjacent mines
        calculateAdjacentMines();
    }


    /**
     * Randomly places the specified number of mines on the grid.
     *
     * @param mineCount The number of mines to place.
     */
    private void placeMines(int mineCount) {
        Random rand = new Random();
        int placedMines = 0;

        // Continue placing mines until the required number of mines is placed.
        while (placedMines < mineCount) {
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);
            if (!grid[row][col].hasMine()) {
                grid[row][col].setMine();
                placedMines++;
            }
        }
    }

    /**
     * Calculates the number of adjacent mines for each cell on the grid.
     */
    private void calculateAdjacentMines() {
        int[] directions = {-1, 0, 1};

        // Iterate through each cell on the grid.
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col].hasMine()) {
                    // Update adjacent cells for each mine found.
                    for (int dr : directions) {
                        for (int dc : directions) {
                            if (dr == 0 && dc == 0) continue;
                            int r = row + dr;
                            int c = col + dc;
                            if (r >= 0 && r < size && c >= 0 && c < size && !grid[r][c].hasMine()) {
                                grid[r][c].setAdjacentMines(grid[r][c].getAdjacentMines() + 1);
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * Uncovers the cell at the specified row and column.
     * If the cell contains a mine, the game ends.
     * If the cell has no adjacent mines, adjacent cells are also uncovered recursively.
     *
     * @param row The row of the cell to uncover.
     * @param col The column of the cell to uncover.
     * @return {@code true} if the cell was successfully uncovered, {@code false} if a mine was uncovered.
     */
    public boolean uncoverCell(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size || grid[row][col].isRevealed()) {
            return true;
        }

        grid[row][col].reveal();
        remainingCells--;

        if (grid[row][col].hasMine()) {
            return false;
        }

        if (grid[row][col].getAdjacentMines() == 0) {
            // Recursively uncover adjacent cells if no adjacent mines are found.
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    uncoverCell(row + dr, col + dc);
                }
            }
        }

        return true;
    }


    /**
     * Checks if the player has won the game by uncovering all non-mine cells.
     *
     * @return {@code true} if all non-mine cells are uncovered, otherwise {@code false}.
     */
    public boolean isGameWon() {
        return remainingCells == countMines();
    }


    /**
     * Counts the total number of mines on the grid.
     *
     * @return The total number of mines on the grid.
     */
    public int countMines() {
        int mineCount = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col].hasMine()) {
                    mineCount++;
                }
            }
        }
        return mineCount;
    }


    /**
     * Gets the grid representing the Minesweeper board.
     *
     * @return The 2D array of `Cell` objects representing the grid.
     */
    public Cell[][] getGrid() {
        return grid;
    }


    /**
     * Gets the size of the grid.
     *
     * @return The size of the grid (i.e., grid is size x size).
     */
    public int getSize() {
        return size;
    }
}


