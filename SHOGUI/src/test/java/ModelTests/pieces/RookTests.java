package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.Lance;
import Model.pieces.Pawn;
import Model.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RookTests {
    public class MockBoard extends Board
    {
        private Piece[][] MockBoard = new Piece[9][9];
        public MockBoard(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoard[0][0] = new Rook(0, 0, true);
            MockBoard[2][2] = new Rook(2, 2, true);


            MockBoard[5][5] = new Rook(5, 5, false);
            MockBoard[8][8] = new Rook(8, 8, false);

            MockBoard[5][2] = new Pawn(2, 4, true);
            MockBoard[2][5] = new Pawn(3, 3, false);
        }
        public Piece getPiece(int x, int y) {
            return MockBoard[x][y];
        }
    }
    @Test
    void testConstructorLance() {
        Rook whiteRook = new Rook(0, 0, true);
        assertEquals("R", whiteRook.getName(), "fitxa incorrecte");
        assertEquals(0, whiteRook.getX(), "x incorrecte");
        assertEquals(0, whiteRook.getY(), "y incorrecte");
        assertTrue(whiteRook.isWhite(), "color incorrecte");

        Rook blackRook = new Rook(3, 6, false);
        assertEquals("R", blackRook.getName(), "fitxa incorrecte");
        assertEquals(3, blackRook.getX(), "x incorrecte");
        assertEquals(6, blackRook.getY(), "y incorrecte");
        assertFalse(blackRook.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new Rook(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new Rook(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new Rook(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new Rook(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new Rook(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new Rook(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }

    @Test
    void testIsValidMoveRook()
    {
        MockBoard taulell_aux = new MockBoard();
        Piece rook_00 = taulell_aux.getPiece(0,0);
        assertFalse(rook_00.isValidMove(0, 9, taulell_aux.MockBoard), "es mou fora taulell");
        assertFalse(rook_00.isValidMove(0, -1, taulell_aux.MockBoard), "es mou fora taulell");
        assertTrue(rook_00.isValidMove(0, 2, taulell_aux.MockBoard), "no permet moviment correcte");
    }

}
