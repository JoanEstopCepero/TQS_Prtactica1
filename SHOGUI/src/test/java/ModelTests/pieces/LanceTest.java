package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.Bishop;
import Model.pieces.Lance;
import Model.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LanceTest {
    public class MockBoard extends Board
    {
        private Piece[][] MockBoard = new Piece[9][9];
        public MockBoard(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoard[0][0] = new Lance(0, 0, true);
            MockBoard[2][2] = new Lance(2, 2, true);
            MockBoard[3][0] = new Lance(3, 0, true);


            MockBoard[5][5] = new Lance(5, 5, false);

            MockBoard[2][4] = new Pawn(2, 4, true);
            MockBoard[3][3] = new Pawn(3, 3, false);
            MockBoard[5][2] = new Pawn(5, 2, true);
        }
        public Piece getPiece(int x, int y) {
            return MockBoard[x][y];
        }
    }

    @Test
    void testConstructorLance() {
        Lance whiteLance = new Lance(0, 0, true);
        assertEquals("L", whiteLance.getName(), "fitxa incorrecte");
        assertEquals(0, whiteLance.getX(), "x incorrecte");
        assertEquals(0, whiteLance.getY(), "y incorrecte");
        assertTrue(whiteLance.isWhite(), "color incorrecte");

        Lance blackLance = new Lance(3, 6, false);
        assertEquals("L", blackLance.getName(), "fitxa incorrecte");
        assertEquals(3, blackLance.getX(), "x incorrecte");
        assertEquals(6, blackLance.getY(), "y incorrecte");
        assertFalse(blackLance.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new Lance(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new Lance(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new Lance(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new Lance(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new Lance(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new Lance(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }

    @Test
    void testIsValidMoveLance()
    {
        MockBoard taulell_aux = new MockBoard();
        Piece lance_00 = taulell_aux.getPiece(0,0);
        assertFalse(lance_00.isValidMove(0, 9, taulell_aux.MockBoard), "es mou fora taulell");
        assertFalse(lance_00.isValidMove(0, -1, taulell_aux.MockBoard), "es mou fora taulell");
        assertTrue(lance_00.isValidMove(0, 2, taulell_aux.MockBoard), "no permet moviment correcte");

        Piece lance_22 = taulell_aux.getPiece(2,2);
        assertFalse(lance_22.isValidMove(2, 1, taulell_aux.MockBoard), "es mou cap enrere");
        assertTrue(lance_22.isValidMove(2, 3, taulell_aux.MockBoard), "no permet moviment correcte");
        assertTrue(lance_22.isValidMove(2, 6, taulell_aux.MockBoard), "no permet moviment correcte");
        Piece lance_55B = taulell_aux.getPiece(5,5);
        assertFalse(lance_55B.isValidMove(5, 6, taulell_aux.MockBoard), "permet moviment enrere");
        assertTrue(lance_22.isValidMove(5, 3, taulell_aux.MockBoard), "no permet moviment correcte");
        assertTrue(lance_22.isValidMove(5, 0, taulell_aux.MockBoard), "no permet moviment correcte");


    }

}
