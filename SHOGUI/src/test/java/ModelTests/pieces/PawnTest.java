package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PawnTest {

    public class MockBoard extends Board
    {
        private Piece[][] MockBoard = new Piece[9][9];
        public MockBoard(){
            initializeBoard();
        }
        public void initializeBoard(){
            MockBoard[0][0] = new Pawn(0, 0, true);
            MockBoard[0][8] = new Pawn(0, 8, true);
            MockBoard[2][1] = new Pawn(2, 1, true);
            MockBoard[3][1] = new Pawn(3, 1, true);
            MockBoard[2][2] = new Pawn(2, 2, true);
            MockBoard[3][2] = new Pawn(3, 2, false);
            MockBoard[5][4] = new Pawn(5, 4, true);
        }
        public Piece getPiece(int x, int y) {
            return MockBoard[x][y];
        }
    }


    @Test
    void testConstructorPawn() {
        Pawn whitePawn = new Pawn(0, 0, true);
        assertEquals("P", whitePawn.getName(), "fitxa incorrecte");
        assertEquals(0, whitePawn.getX(), "x incorrecte");
        assertEquals(0, whitePawn.getY(), "y incorrecte");
        assertTrue(whitePawn.isWhite(), "color incorrecte");

        Pawn blackPawn = new Pawn(3, 6, false);
        assertEquals("P", blackPawn.getName(), "fitxa incorrecte");
        assertEquals(3, blackPawn.getX(), "x incorrecte");
        assertEquals(6, blackPawn.getY(), "y incorrecte");
        assertFalse(blackPawn.isWhite(), "color incorrecte");



        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new Pawn(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new Pawn(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new Pawn(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new Pawn(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new Pawn(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new Pawn(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }

    @Test
    void testIsValidMove()
    {
        MockBoard taulell_auxiliar = new MockBoard();

        Piece peo_00 = taulell_auxiliar.getPiece(0,0);
        assertTrue(peo_00.isValidMove(0, 1, taulell_auxiliar.MockBoard), "no es mou bé endavant");
        assertFalse(peo_00.isValidMove(0, -1, taulell_auxiliar.MockBoard), "permet sortir del tauler");
        assertFalse(peo_00.isValidMove(-1, 0, taulell_auxiliar.MockBoard), "permet sortir tauler i moures esquerre");

        Piece peo_54 = taulell_auxiliar.getPiece(5,4);
        assertFalse(peo_54.isValidMove(6, 4, taulell_auxiliar.MockBoard), "permet moviment horitzontal");
        assertFalse(peo_54.isValidMove(4, 4, taulell_auxiliar.MockBoard), "permet moviment horitzontal");
        assertFalse(peo_54.isValidMove(6, 5, taulell_auxiliar.MockBoard), "permet moviment diagonal");
        assertFalse(peo_54.isValidMove(4, 5, taulell_auxiliar.MockBoard), "permet moviment diagonal");
        assertFalse(peo_54.isValidMove(6, 3, taulell_auxiliar.MockBoard), "permet moviment diagonal");
        assertFalse(peo_54.isValidMove(4, 3, taulell_auxiliar.MockBoard), "permet moviment diagonal");
        assertFalse(peo_54.isValidMove(5, 6, taulell_auxiliar.MockBoard), "permet moviment doble");

        Piece peo_08 = taulell_auxiliar.getPiece(0,8);
        assertFalse(peo_08.isValidMove(0, 9, taulell_auxiliar.MockBoard), "permet sortir tauler");

        Piece peo_21 = taulell_auxiliar.getPiece(2,1);
        assertFalse(peo_21.isValidMove(2, 2, taulell_auxiliar.MockBoard), "permet menjar un altre peça blanca");

        Piece peo_22 = taulell_auxiliar.getPiece(2,2);
        assertTrue(peo_22.isValidMove(2, 3, taulell_auxiliar.MockBoard), "no permet menjar peça negra");

    }



}
