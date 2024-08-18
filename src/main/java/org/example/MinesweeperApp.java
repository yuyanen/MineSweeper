package org.example;


import java.io.IOException;
import java.util.Scanner;


/**
 * Main class for the Minesweeper application.
 * Provides the user interface to interact with the game through the command line.
 *
 * Design Overview:
 * - The MinesweeperApp class provides a simple command-line interface for the user to play the Minesweeper game.
 * - It prompts the user for input, processes game actions, and displays the current state of the grid after each move.
 *
 * Assumptions:
 * - The user inputs valid grid coordinates in the form of a letter (row) followed by a number (column).
 * - The game grid is square-shaped, and the number of mines is a valid input within the specified limits.
 */
public class MinesweeperApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Minesweeper!");

        // Prompt user for grid size and number of mines
        System.out.print("Enter the size of the grid (e.g. 4 for a 4x4 grid): ");
        int size = scanner.nextInt();

        System.out.print("Enter the number of mines to place on the grid (maximum is 35% of the total squares): ");
        int totalCells = size * size;
        int maxMines = (int) (totalCells * 0.35);
        int mines = scanner.nextInt();
        if (mines > maxMines) {
            System.out.println("Number of mines exceeds the maximum allowed. Setting to maximum.");
            mines = maxMines;
        }

        // Initialize the game
        Minesweeper game = new Minesweeper(size, mines);
        boolean gameRunning = true;

        while (gameRunning) {
            // Print the current state of the grid
            printGrid(game);

            // Prompt user for cell to reveal
            System.out.print("Select a square to reveal (e.g. A1): ");
            String input = scanner.next().toUpperCase();
            int row = input.charAt(0) - 'A';
            int col = Integer.parseInt(input.substring(1)) - 1;

            if (!game.uncoverCell(row, col)) {
                System.out.println("Oh no, you detonated a mine! Game over.");
                printGrid(game);
                break;
            }

            // Provide feedback on the cell revealed
            Cell cell = game.getGrid()[row][col];
            if (cell.getAdjacentMines() == 0) {
                System.out.println("This square contains 0 adjacent mines.");
            } else {
                System.out.println("This square contains " + cell.getAdjacentMines() + " adjacent mines.");
            }

            // Check for win condition
            if (game.isGameWon()) {
                System.out.println("Congratulations, you have won the game!");
                printGrid(game);
                break;
            }
        }

        System.out.println("Press any key to play again...");
        try {
            System.in.read(); // Wait for user to press any key
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Prints the current state of the Minesweeper grid.
     * Revealed cells show the number of adjacent mines or a mine symbol, while unrevealed cells are hidden.
     *
     * @param game the Minesweeper game instance to retrieve the grid from.
     */
    private static void printGrid(Minesweeper game) {
        Cell[][] grid = game.getGrid();
        int size = game.getSize();

        // Print column numbers
        System.out.print("  ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Print grid rows
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < size; j++) {
                Cell cell = grid[i][j];
                if (cell.isRevealed()) {
                    if (cell.hasMine()) {
                        System.out.print("* ");  // Print mine
                    } else {
                        System.out.print(cell.getAdjacentMines() + " ");  // Print number of adjacent mines
                    }
                } else {
                    System.out.print("_ ");   // Print hidden cell
                }
            }
            System.out.println();
        }
    }
}

