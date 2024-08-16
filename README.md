# Minesweeper Game


### Design Overview

- **Cell Class**: Manages the state of individual cells including whether they contain a mine and their adjacent mine count.
- **Minesweeper Class**: Manages the game logic such as mine placement, counting adjacent mines, and uncovering cells.
- **MinesweeperApp Class**: Provides a command-line interface for user interaction.

### Assumptions

1. **Grid Size and Mines**: 
   - Grid size ranges from 2 to 26.
   - Mines count ranges from 0 to 35% of the total grid cells.

2. **Input Validation**:
   - Basic validation for grid size, number of mines, and cell references.

3. **Game State**:
   - Game ends if a mine is uncovered or if all non-mine cells are revealed.

## Installation and Setup

1. **Environment Requirements**:
   - **Operating System**: Windows,or macOS.
   - **Java Development Kit (JDK)**: JDK 8 or higher.
2. Ensure you have Java Development Kit (JDK) 17 or higher installed.
3. Navigate to the `src` directory.
4. Open CMD Run Command: java -cp bin org.example.MinesweeperApp
