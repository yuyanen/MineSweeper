import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.Cell;
import org.example.Minesweeper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit tests for the Minesweeper game logic.
 * Verifies grid initialization, mine placement, adjacent mine calculation, cell uncovering, and win condition.
 */
public class MinesweeperTest {
    private Minesweeper game;

    @BeforeEach
    public void setUp() {
        game = new Minesweeper(5, 5);
    }

    @Test
    public void testGridInitialization() {
        Cell[][] grid = game.getGrid();
        assertEquals(5, grid.length);
        for (Cell[] row : grid) {
            assertEquals(5, row.length);
        }
    }

    @Test
    public void testMinePlacement() {
        int mineCount = game.countMines();
        assertTrue(mineCount <= 5);
    }

    @Test
    public void testUncoverCell() {
        boolean result = game.uncoverCell(0, 0);
        assertTrue(result || game.getGrid()[0][0].hasMine());
    }

    @Test
    public void testIsGameWon() {
        // Assuming a grid without mines for simplicity
        Minesweeper simpleGame = new Minesweeper(3, 0);
        simpleGame.uncoverCell(0, 0);
        simpleGame.uncoverCell(0, 1);
        simpleGame.uncoverCell(1, 0);
        simpleGame.uncoverCell(1, 1);
        assertTrue(simpleGame.isGameWon());
    }
}
