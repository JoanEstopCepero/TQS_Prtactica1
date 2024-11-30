package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.King;
import Model.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class KingTest {

    public class MockBoardW extends Board
    {
        private Piece[][] MockBoardW = new Piece[9][9];
        public MockBoardW(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoardW[0][0] = new King(0, 0, true);
            MockBoardW[8][8] = new King(8, 8, true);

            MockBoardW[2][4] = new King(2, 4, true);
            MockBoardW[5][4] = new King(5, 4, true);

            MockBoardW[4][4] = new Pawn(4, 4, false);
            MockBoardW[6][4] = new Pawn(6, 4, false);
            MockBoardW[5][3] = new Pawn(5, 3, true);
            MockBoardW[5][5] = new Pawn(5, 5, true);
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
            MockBoardB[0][0] = new King(0, 0, false);
            MockBoardB[8][8] = new King(8, 8, false);

            MockBoardB[2][4] = new King(2, 4, false);
            MockBoardB[5][4] = new King(5, 4, false);

            MockBoardB[4][4] = new Pawn(4, 4, true);
            MockBoardB[6][4] = new Pawn(6, 4, true);
            MockBoardB[5][3] = new Pawn(5, 3, false);
            MockBoardB[5][5] = new Pawn(5, 5, false);
        }
        public Piece getPiece(int x, int y) {
            return MockBoardB[x][y];
        }
    }

    @Test
    void testConstructorKing() {
        King whiteKing = new King(0, 0, true);
        assertEquals("K", whiteKing.getName(), "fitxa incorrecte");
        assertEquals(0, whiteKing.getX(), "x incorrecte");
        assertEquals(0, whiteKing.getY(), "y incorrecte");
        assertTrue(whiteKing.isWhite(), "color incorrecte");

        King blackKing = new King(3, 6, false);
        assertEquals("K", blackKing.getName(), "fitxa incorrecte");
        assertEquals(3, blackKing.getX(), "x incorrecte");
        assertEquals(6, blackKing.getY(), "y incorrecte");
        assertFalse(blackKing.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new King(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new King(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new King(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new King(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new King(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new King(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }


    @Test
    void testisValidMoveKing()
    {
        MockBoardW taulell_aux_w = new MockBoardW();
        Piece rei_00 = taulell_aux_w.getPiece(0,0);
        assertFalse(rei_00.isValidMove(-1, 0, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(rei_00.isValidMove(-1, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(rei_00.isValidMove(0, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(rei_00.isValidMove(1, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");


        Piece rei_88 = taulell_aux_w.getPiece(8,8);
        assertFalse(rei_88.isValidMove(9, 8, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(rei_88.isValidMove(9, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(rei_88.isValidMove(8, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(rei_88.isValidMove(7, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");

        Piece rei_24 = taulell_aux_w.getPiece(2,4);
        assertTrue(rei_24.isValidMove(2, 3, taulell_aux_w.MockBoardW), "no deixa mov correcte");
        assertTrue(rei_24.isValidMove(2, 5, taulell_aux_w.MockBoardW), "no deixa mov correcte");
        assertTrue(rei_24.isValidMove(3, 5, taulell_aux_w.MockBoardW), "no deixa mov correcte");
        assertFalse(rei_24.isValidMove(2, 6, taulell_aux_w.MockBoardW), "permet moure's de 2 en 2");
        assertFalse(rei_24.isValidMove(4, 4, taulell_aux_w.MockBoardW), "permet moure's de 2 en 2");

        Piece rei_54 = taulell_aux_w.getPiece(5,4);
        assertTrue(rei_54.isValidMove(4, 4, taulell_aux_w.MockBoardW), "no deixa menjar");
        assertTrue(rei_54.isValidMove(6, 4, taulell_aux_w.MockBoardW), "no deixa menjar");
        assertFalse(rei_54.isValidMove(5, 3, taulell_aux_w.MockBoardW), "permet menjar peo blanc");
        assertFalse(rei_54.isValidMove(5, 5, taulell_aux_w.MockBoardW), "permet menjar peo blanc");


        MockBoardB taulell_aux_b = new MockBoardB();
        Piece rei_00B = taulell_aux_b.getPiece(0,0);
        assertFalse(rei_00B.isValidMove(-1, 0, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(rei_00B.isValidMove(-1, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(rei_00B.isValidMove(0, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(rei_00B.isValidMove(1, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");


        Piece rei_88B = taulell_aux_b.getPiece(8,8);
        assertFalse(rei_88B.isValidMove(9, 8, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(rei_88B.isValidMove(9, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(rei_88B.isValidMove(8, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(rei_88B.isValidMove(7, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");

        Piece rei_24B = taulell_aux_b.getPiece(2,4);
        assertTrue(rei_24B.isValidMove(2, 3, taulell_aux_b.MockBoardB), "no deixa mov correcte");
        assertTrue(rei_24B.isValidMove(2, 5, taulell_aux_b.MockBoardB), "no deixa mov correcte");
        assertTrue(rei_24B.isValidMove(3, 5, taulell_aux_b.MockBoardB), "no deixa mov correcte");
        assertFalse(rei_24B.isValidMove(2, 6,taulell_aux_b.MockBoardB), "permet moure's de 2 en 2");
        assertFalse(rei_24B.isValidMove(4, 4, taulell_aux_b.MockBoardB), "permet moure's de 2 en 2");

        Piece rei_54B = taulell_aux_b.getPiece(5,4);
        assertTrue(rei_54B.isValidMove(4, 4, taulell_aux_b.MockBoardB), "no deixa menjar");
        assertTrue(rei_54B.isValidMove(6, 4, taulell_aux_b.MockBoardB), "no deixa menjar");
        assertFalse(rei_54B.isValidMove(5, 3, taulell_aux_b.MockBoardB), "permet menjar peo negre");
        assertFalse(rei_54B.isValidMove(5, 5, taulell_aux_b.MockBoardB), "permet menjar peo negre");

    }
}
