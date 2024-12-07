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
        // Crea un mock de GameController
        GameController mockGameController = mock(GameController.class);

        // Simular la entrada como una secuencia válida con "exit" para salir
        String simulatedInput = "0\n0\n0\n1\nexit\n"; // Agregar exit para salir
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Evitar la ejecución real de startGame en el mock
        doNothing().when(mockGameController).startGame();

        // Invocar main que debería llamar a startGame
        Main.main(new String[]{});

        // Asegurarse de que la salida contiene el turno de los jugadores
        String output = outputStream.toString();
        assertTrue(output.contains("White's turn.") || output.contains("Black's turn."),
                "Output no contiene el turno de los jugadores");
    }

    @Test
    void testInvalidInputHandling() {
        String simulatedInput = "invalid_input\nexit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        doNothing().when(mockGameController).startGame();

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid input") || output.contains("try again"),
                "sortida no indica que ha estat un input incorrecte");
    }

    @Test
    void testInteractionWithController() {
        String simulatedInput = "0 0 0 1\n8 8 8 7\nexit\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        doNothing().when(mockGameController).startGame();

        Main.main(new String[]{});

        String output = outputStream.toString();
        assertTrue(output.contains("White's turn.") && output.contains("Black's turn."),
                "no canviem de torn");
    }
}
