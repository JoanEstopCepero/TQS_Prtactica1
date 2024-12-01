package ViewTests;

import Controller.GameController;
import View.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MainTest {

    private GameController mockGameController;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        mockGameController = mock(GameController.class);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testGameStartAndExit() {

        String simulatedInput = "0 1 2 3\nexit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{});

        verify(mockGameController).startGame();

        String output = outputStream.toString();
        assertTrue(output.contains("White's turn.") || output.contains("Black's turn."),
                "sortida no indica torn jugadors");
    }

    @Test
    void testInvalidInputHandling() {
        String simulatedInput = "invalid_input\nexit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid input") || output.contains("try again"),
                "sortida no indica que ha estat un input incorrecte");
    }

    @Test
    void testInteractionWithController() {
        String simulatedInput = "0 1 2 3\n1 1 3 3\nexit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Main.main(new String[]{});

        verify(mockGameController, times(1)).startGame();

        String output = outputStream.toString();
        assertTrue(output.contains("White's turn.") && output.contains("Black's turn."),
                "no canviem de torn");
    }
}
