# Minesweeper Game


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
     
     Open a terminal or command prompt and run:
      mvn -v
     
 **Setup and Run**:
  1. Clone or download the project files.
     
  2. Compile the Code:
     Navigate into the minesweeper directory using the command line.
     
     Compile the project using Maven:
     mvn clean compile
     
  3. Run the Application:
     
     Once compiled, run the Minesweeper game with the following command:
     
     java -cp target/classes org.example.MinesweeperApp

## Running Tests with JUnit
Navigate into the minesweeper directory using the command line.

Compile and Run Tests: mvn test
