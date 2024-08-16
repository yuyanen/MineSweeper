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

 **Environment Requirements**:
   - **Operating System**: Windows,or macOS.
   - **Java Development Kit (JDK)**: JDK 17 or higher.

 **Installing Maven**:
  1. Download Maven

  2. Install Maven:
     Windows: Unzip the archive and add the bin directory to your system's PATH environment variable.
     macOS/Linux: Unzip the archive, move it to a suitable directory (e.g., /usr/local/apache-maven), and add the bin 
     directory to your PATH.
     
  3. Verify Installation:
     Open a terminal or command prompt and run: mvn -v
 **Setup and Run**:
  1. Clone or download the project files.
     
  3. Compile the Code:
     Navigate into the minesweeper directory using the command line.
     Compile the project using Maven: mvn clean compile
     
  4. Run the Application:
     Once compiled, run the Minesweeper game with the following command:
     java -cp target/classes org.example.MinesweeperApp

## Running Tests with JUnit
Navigate into the minesweeper directory using the command line.

Compile and Run Tests: mvn test
