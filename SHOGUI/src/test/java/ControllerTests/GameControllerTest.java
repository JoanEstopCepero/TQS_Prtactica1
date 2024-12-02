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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gameController = new GameController(mockBoard);
    }

    @Test
    public void testPieceIsNull() {

        when(mockBoard.getPiece(0, 0)).thenReturn(null);

        Scanner scanner = new Scanner("0 0 1 1\n");
        String input = scanner.nextLine();

        System.setIn(new ByteArrayInputStream(input.getBytes()));


        gameController.startGame();


        verify(mockBoard, times(1)).displayBoard();
        verify(mockBoard, never()).movePiece(anyInt(), anyInt(), anyInt(), anyInt());
    }

    @Test
    public void testInvalidMove() {
        when(mockBoard.getPiece(0, 0)).thenReturn(mockPiece);
        when(mockPiece.isWhite()).thenReturn(true);
        when(mockBoard.movePiece(0, 0, 1, 1)).thenReturn(false);

        Scanner scanner = new Scanner("0 0 1 1\n");
        String input = scanner.nextLine();

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        gameController.startGame();

        verify(mockBoard, times(1)).movePiece(0, 0, 1, 1);
        verify(mockBoard, never()).isKingInCheck(anyBoolean());
    }

    @Test
    public void testKingInCheck() {
        when(mockBoard.getPiece(0, 0)).thenReturn(mockPiece);
        when(mockPiece.isWhite()).thenReturn(true);
        when(mockBoard.movePiece(0, 0, 1, 1)).thenReturn(true);
        when(mockBoard.isKingInCheck(false)).thenReturn(true);

        Scanner scanner = new Scanner("0 0 1 1\n");
        String input = scanner.nextLine();

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        gameController.startGame();

        verify(mockBoard, times(1)).isKingInCheck(false);
    }

    @Test
    public void testKingInCheckmate() {

        when(mockBoard.getPiece(0, 0)).thenReturn(mockPiece);
        when(mockPiece.isWhite()).thenReturn(true);
        when(mockBoard.movePiece(0, 0, 1, 1)).thenReturn(true);
        when(mockBoard.isKingInCheck(false)).thenReturn(true);
        when(mockBoard.findKing(false)).thenReturn(null);


        Scanner scanner = new Scanner("0 0 1 1\n");
        String input = scanner.nextLine();

        System.setIn(new ByteArrayInputStream(input.getBytes()));


        gameController.startGame();


        verify(mockBoard, times(1)).isKingInCheck(false);
        verify(mockBoard, times(1)).findKing(false);
    }

    @Test
    public void testValidMove() {

        when(mockBoard.getPiece(0, 0)).thenReturn(mockPiece);
        when(mockPiece.isWhite()).thenReturn(true);
        when(mockBoard.movePiece(0, 0, 1, 1)).thenReturn(true);
        when(mockBoard.isKingInCheck(false)).thenReturn(false);


        Scanner scanner = new Scanner("0 0 1 1\n");
        String input = scanner.nextLine();

        System.setIn(new ByteArrayInputStream(input.getBytes()));


        gameController.startGame();


        verify(mockBoard, times(1)).movePiece(0, 0, 1, 1);
        verify(mockBoard, times(1)).isKingInCheck(false);
    }
}

