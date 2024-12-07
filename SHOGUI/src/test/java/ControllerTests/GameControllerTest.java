package ControllerTests;

import Controller.GameController;
import Model.Board;
import Model.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {

    @Mock
    private Board mockBoard;

    @Mock
    private Piece mockPiece;

    private GameController gameController;

    // Inicializamos los mocks manualmente
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);  // Inicializa los mocks manualmente
        gameController = new GameController(mockBoard);
    }

    @Test
    public void testPieceIsNull() {
        // Simulamos que no hay pieza en la posición 0,0
        when(mockBoard.getPiece(0, 0)).thenReturn(null);

        // Usamos un Scanner para simular la entrada del usuario
        String simulatedInput = "0 0 0 1\nexit\n";


        // Establecemos el InputStream con los datos del Scanner
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Iniciamos el juego
        gameController.startGame();
    }

    @Test
    public void testInvalidMove() {
        // Configuramos un mock de una pieza en la posición 0,0
        when(mockBoard.getPiece(0, 0)).thenReturn(mockPiece);
        when(mockPiece.isWhite()).thenReturn(true);
        when(mockBoard.movePiece(0, 0, 1, 1)).thenReturn(false);

        // Usamos un Scanner para simular la entrada del usuario
        String simulatedInput = "0 0 0 1\nexit\n";


        // Establecemos el InputStream con los datos del Scanner
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Iniciamos el juego
        gameController.startGame();
    }

    @Test
    public void testKingInCheck() {
        // Configuramos un mock de una pieza en la posición 0,0
        when(mockBoard.getPiece(0, 0)).thenReturn(mockPiece);
        when(mockPiece.isWhite()).thenReturn(true);
        when(mockBoard.movePiece(0, 0, 1, 1)).thenReturn(true);
        when(mockBoard.isKingInCheck(false)).thenReturn(true);

        // Usamos un Scanner para simular la entrada del usuario
        String simulatedInput = "0 0 0 1\nexit\n";

        // Establecemos el InputStream con los datos del Scanner
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Iniciamos el juego
        gameController.startGame();
    }

    @Test
    public void testKingInCheckmate() {
        // Configuramos un mock de una pieza en la posición 0,0
        when(mockBoard.getPiece(0, 0)).thenReturn(mockPiece);
        when(mockPiece.isWhite()).thenReturn(true);
        when(mockBoard.movePiece(0, 0, 1, 1)).thenReturn(true);
        when(mockBoard.isKingInCheck(false)).thenReturn(true);
        when(mockBoard.findKing(false)).thenReturn(null);  // Simulamos que el rey del oponente es nulo (jaque mate)

        // Usamos un Scanner para simular la entrada del usuario
        String simulatedInput = "0 0 0 1\nexit\n";

        // Establecemos el InputStream con los datos del Scanner
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Iniciamos el juego
        gameController.startGame();
    }

    @Test
    public void testValidMove() {
        // Configuramos un mock de una pieza en la posición 0,0
        when(mockBoard.getPiece(0, 0)).thenReturn(mockPiece);
        when(mockPiece.isWhite()).thenReturn(true);
        when(mockBoard.movePiece(0, 0, 1, 1)).thenReturn(true);
        when(mockBoard.isKingInCheck(false)).thenReturn(false);

        // Usamos un Scanner para simular la entrada del usuario
        String simulatedInput = "0 0 0 1\nexit\n";

        // Establecemos el InputStream con los datos del Scanner
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Iniciamos el juego
        gameController.startGame();
    }
}
