package org.example;


import java.util.Random;

/**
 * Manages the Minesweeper game logic including grid initialization, mine placement,
 * adjacent mine counting, cell uncovering, and win condition checking.
 *
 * Design Overview:
 * - The `Minesweeper` class handles the core game logic. It manages a grid of `Cell` objects, placing mines,
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
    private final Cell[][] grid;
    private final int size;
    private int remainingCells;

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

    private void placeMines(int mineCount) {
        Random rand = new Random();
        int placedMines = 0;

        while (placedMines < mineCount) {
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);
            if (!grid[row][col].hasMine()) {
                grid[row][col].setMine();
                placedMines++;
            }
        }
    }

    private void calculateAdjacentMines() {
        int[] directions = {-1, 0, 1};

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col].hasMine()) {
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
            // Recursively uncover adjacent cells
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    uncoverCell(row + dr, col + dc);
                }
            }
        }

        return true;
    }

    public boolean isGameWon() {
        return remainingCells == countMines();
    }

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

    public Cell[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }
}


