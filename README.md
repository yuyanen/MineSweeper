# Minesweeper Game


## Design and Assumptions
- **Cell Class**: Represents each cell on the grid, including whether it contains a mine, the number of adjacent mines, and its revealed status.
- **Minesweeper Class**: Manages the game grid, placing mines, and calculating adjacent mines. Handles uncovering cells and checking win conditions.
- **MinesweeperApp Class**: Provides the user interface for interacting with the game, including input handling and displaying the game state.

## Instructions to Run
1. Ensure you have Java Development Kit (JDK) 17 or higher installed.
2. Navigate to the `src` directory.
3. Open CMD and Compile the Java files using the following command:
   javac -d bin main\java\org\example\*.java
4. Run java -cp bin org.example.MinesweeperApp
