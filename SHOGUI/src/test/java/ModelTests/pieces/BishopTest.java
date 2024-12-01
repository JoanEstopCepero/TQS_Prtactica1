package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.Bishop;
import Model.pieces.Knight;
import Model.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


public class BishopTest {

    public class MockBoard extends Board
    {
        private Piece[][] MockBoard = new Piece[9][9];
        public MockBoard(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoard[2][4] = new Bishop(2, 4, true);
            MockBoard[5][4] = new Bishop(5, 4, true);

            MockBoard[5][0] = new Bishop(5, 0, false);
            MockBoard[7][7] = new Bishop(7, 7, false);

            MockBoard[3][2] = new Pawn(3, 2, false);
            MockBoard[7][2] = new Pawn(7, 2, true);
        }
        public Piece getPiece(int x, int y) {
            return MockBoard[x][y];
        }
    }

    @Test
    void testConstructorBishop() {
        Bishop whiteBishop = new Bishop(0, 0, true);
        assertEquals("B", whiteBishop.getName(), "fitxa incorrecte");
        assertEquals(0, whiteBishop.getX(), "x incorrecte");
        assertEquals(0, whiteBishop.getY(), "y incorrecte");
        assertTrue(whiteBishop.isWhite(), "color incorrecte");

        Bishop blackBishop = new Bishop(3, 6, false);
        assertEquals("B", blackBishop.getName(), "fitxa incorrecte");
        assertEquals(3, blackBishop.getX(), "x incorrecte");
        assertEquals(6, blackBishop.getY(), "y incorrecte");
        assertFalse(blackBishop.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new Bishop(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new Bishop(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new Bishop(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new Bishop(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new Bishop(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new Bishop(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }

    @Test
    void testIsValidMoveBishop(){
        MockBoard taulell_aux = new MockBoard();
        Piece bishop_24 = taulell_aux.getPiece(2,4);
        assertFalse(bishop_24.isValidMove(-1, 1, taulell_aux.MockBoard), "es mou fora taulell");
        assertFalse(bishop_24.isValidMove(7, -1, taulell_aux.MockBoard), "es mou fora taulell");
        assertTrue(bishop_24.isValidMove(1, 3, taulell_aux.MockBoard), "no permet moviment correcte");


        assertFalse(bishop_24.isValidMove(1, 2, taulell_aux.MockBoard), "pemet moviment incorrecte");
        assertTrue(bishop_24.isValidMove(0, 2, taulell_aux.MockBoard), "no permet moviment correcte");
        assertTrue(bishop_24.isValidMove(0, 6, taulell_aux.MockBoard), "no permet moviment correcte");
        assertTrue(bishop_24.isValidMove(4, 2, taulell_aux.MockBoard), "no permet moviment correcte");
        assertTrue(bishop_24.isValidMove(5, 7, taulell_aux.MockBoard), "no permet moviment correcte");

        Piece bishop_54 = taulell_aux.getPiece(5,4);
        assertFalse(bishop_54.isValidMove(2, 1, taulell_aux.MockBoard), "permet travessar fitxes");
        assertFalse(bishop_54.isValidMove(8, 1, taulell_aux.MockBoard), "permet travessar fitxes");
        Piece bishop_50B = taulell_aux.getPiece(5,0);
        assertFalse(bishop_50B.isValidMove(2, 3, taulell_aux.MockBoard), "permet travessar fitxes");
        assertFalse(bishop_50B.isValidMove(8, 3, taulell_aux.MockBoard), "permet travessar fitxes");

    }

}
