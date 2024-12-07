package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.GoldGeneral;
import Model.pieces.Knight;
import Model.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KnightTest {
    public class MockBoardW extends Board
    {
        private Piece[][] MockBoardW = new Piece[9][9];
        public MockBoardW(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoardW[0][0] = new Knight(0, 0, true);
            MockBoardW[8][8] = new Knight(8, 8, true);

            MockBoardW[2][4] = new Knight(2, 4, true);
            MockBoardW[5][4] = new Knight(5, 4, true);

            MockBoardW[6][6] = new Pawn(6, 6, false);
            MockBoardW[4][6] = new Pawn(4, 6, true);
        }
        public Piece getPiece(int x, int y) {
            return MockBoardW[x][y];
        }
    }
    public class MockBoardB extends Board
    {
        private Piece[][] MockBoardB = new Piece[9][9];
        public MockBoardB(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoardB[0][0] = new Knight(0, 0, false);
            MockBoardB[8][8] = new Knight(8, 8, false);

            MockBoardB[2][4] = new Knight(2, 4, false);
            MockBoardB[5][4] = new Knight(5, 4, false);

            MockBoardB[4][2] = new Pawn(4, 2, true);
            MockBoardB[6][2] = new Pawn(6, 2, false);
        }
        public Piece getPiece(int x, int y) {
            return MockBoardB[x][y];
        }
    }
    @Test
    void testConstructorKing() {
        Knight whiteKnight = new Knight(0, 0, true);
        assertEquals("N", whiteKnight.getName(), "fitxa incorrecte");
        assertEquals(0, whiteKnight.getX(), "x incorrecte");
        assertEquals(0, whiteKnight.getY(), "y incorrecte");
        assertTrue(whiteKnight.isWhite(), "color incorrecte");

        Knight blackKnight = new Knight(3, 6, false);
        assertEquals("N", blackKnight.getName(), "fitxa incorrecte");
        assertEquals(3, blackKnight.getX(), "x incorrecte");
        assertEquals(6, blackKnight.getY(), "y incorrecte");
        assertFalse(blackKnight.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new Knight(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new Knight(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new Knight(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new Knight(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new Knight(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new Knight(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }

    @Test
    void testIsValidMoveKnight() {
        MockBoardW taulell_aux_w = new MockBoardW();
        Piece knight_00 = taulell_aux_w.getPiece(0,0);
        assertFalse(knight_00.isValidMove(-1, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(knight_00.isValidMove(1, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(knight_00.isValidMove(-1, 1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertTrue(knight_00.isValidMove(1, 2, taulell_aux_w.MockBoardW), "no permet moviment correcte");

        Piece knight_88 = taulell_aux_w.getPiece(8,8);
        assertFalse(knight_88.isValidMove(8, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(knight_88.isValidMove(9, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(knight_88.isValidMove(7, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");

        Piece knight_24 = taulell_aux_w.getPiece(2,4);
        assertTrue(knight_24.isValidMove(3, 6, taulell_aux_w.MockBoardW), "no permet moviment correcte");
        assertTrue(knight_24.isValidMove(1, 6, taulell_aux_w.MockBoardW), "no permet moviment correcte");

        assertFalse(knight_24.isValidMove(1, 2, taulell_aux_w.MockBoardW), "permet moures enrere");
        assertFalse(knight_24.isValidMove(3, 2, taulell_aux_w.MockBoardW), "permet moures enrere");
        assertFalse(knight_24.isValidMove(4, 6, taulell_aux_w.MockBoardW), "permet moviments incorrectes");
        assertFalse(knight_24.isValidMove(2, 5, taulell_aux_w.MockBoardW), "permet moviments incorrectes");

        Piece knight_54 = taulell_aux_w.getPiece(5,4);
        assertTrue(knight_54.isValidMove(6, 6, taulell_aux_w.MockBoardW), "no permet menjar");
        assertFalse(knight_54.isValidMove(4, 6, taulell_aux_w.MockBoardW), "permet menjar blanques");

        MockBoardB taulell_aux_b = new MockBoardB();
        Piece knight_00B = taulell_aux_b.getPiece(0,0);
        assertFalse(knight_00B.isValidMove(-1, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(knight_00B.isValidMove(1, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(knight_00B.isValidMove(-1, 1, taulell_aux_b.MockBoardB), "es mou fora taulell");

        Piece knight_88B = taulell_aux_b.getPiece(8,8);
        assertFalse(knight_88B.isValidMove(8, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(knight_88B.isValidMove(9, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(knight_88B.isValidMove(7, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertTrue(knight_88B.isValidMove(7, 6, taulell_aux_b.MockBoardB), "no permet moviment correcte");


        Piece knight_24B = taulell_aux_b.getPiece(2,4);
        assertTrue(knight_24B.isValidMove(1, 2, taulell_aux_b.MockBoardB), "no permet moviment correcte");
        assertTrue(knight_24B.isValidMove(3, 2, taulell_aux_b.MockBoardB), "no permet moviment correcte");

        assertFalse(knight_24B.isValidMove(1, 6, taulell_aux_b.MockBoardB), "permet moures enrere");
        assertFalse(knight_24B.isValidMove(3, 6, taulell_aux_b.MockBoardB), "permet moures enrere");
        assertFalse(knight_24B.isValidMove(4, 6, taulell_aux_b.MockBoardB), "permet moviments incorrectes");
        assertFalse(knight_24B.isValidMove(2, 5, taulell_aux_b.MockBoardB), "permet moviments incorrectes");

        Piece knight_54B = taulell_aux_b.getPiece(5, 4);
        assertTrue(knight_54B.isValidMove(4, 2, taulell_aux_b.MockBoardB), "no permet menjar");
        assertFalse(knight_54B.isValidMove(6, 2, taulell_aux_b.MockBoardB), "permet menjar negres");
    }
}
