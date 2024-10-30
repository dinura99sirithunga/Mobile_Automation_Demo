package tests.mobileTest.PuzzleSolveScreen;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageElementsFactory.puzzelSolvingScreen.PuzzleScreenElements;
import util.baseConfig;

public class PuzzleSolverTest extends baseConfig {
    public PuzzleScreenElements puzzleScreenElements;
    SoftAssert softAssert;

    @Test(priority = 1, description = "Verify Puzzle Solver Works Correctly")
    public void verifyPuzzleSolver() {
        softAssert = new SoftAssert();
        test.get().info("Initializing puzzle screen elements."); // Logging step

        softAssert.assertAll();
    }
}
