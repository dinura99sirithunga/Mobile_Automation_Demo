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

        // Initialize Puzzle Screen Elements
        puzzleScreenElements = new PuzzleScreenElements(appiumDriver);

        //Tap On Drag button to navigate to correct screen
        puzzleScreenElements.tapOnDrag();

        // Start solving puzzle and assert success criteria
        puzzleScreenElements.dragAndDrop();

        test.get().info("Puzzle solved action executed.");

        // Add assertions based on success criteria
        softAssert.assertTrue(puzzleScreenElements.isPuzzleSolved(), "Puzzle was not solved as expected.");
        softAssert.assertAll();
    }
}
