package ModelTests.pieces;

import Model.Board;
import Model.Piece;
import Model.pieces.SilverGeneral;
import Model.pieces.King;
import Model.pieces.Pawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SilverGeneralTests {
    public class MockBoardW extends Board {
        private Piece[][] MockBoardW = new Piece[9][9];

        public MockBoardW() {
            initializeBoard();
        }

        public void initializeBoard() {
            MockBoardW[0][0] = new SilverGeneral(0, 0, true);
            MockBoardW[8][8] = new SilverGeneral(8, 8, true);

            MockBoardW[2][4] = new SilverGeneral(2, 4, true);
            MockBoardW[5][4] = new SilverGeneral(5, 4, true);

            MockBoardW[6][5] = new Pawn(6, 5, false);
            MockBoardW[5][5] = new Pawn(5, 5, true);
        }

        public Piece getPiece(int x, int y) {
            return MockBoardW[x][y];
        }
    }

    public class MockBoardB extends Board {
        private Piece[][] MockBoardB = new Piece[9][9];

        public MockBoardB() {
            initializeBoard();
        }

        public void initializeBoard() {
            MockBoardB[0][0] = new SilverGeneral(0, 0, false);
            MockBoardB[8][8] = new SilverGeneral(8, 8, false);

            MockBoardB[2][4] = new SilverGeneral(2, 4, false);
            MockBoardB[5][4] = new SilverGeneral(5, 4, false);

            MockBoardB[6][5] = new Pawn(6, 5, true);
            MockBoardB[5][3] = new Pawn(5, 3, false);
        }

        public Piece getPiece(int x, int y) {
            return MockBoardB[x][y];
        }
    }

    @Test
    void testConstructorSG() {
        SilverGeneral whiteSG = new SilverGeneral(0, 0, true);
        assertEquals("S", whiteSG.getName(), "fitxa incorrecte");
        assertEquals(0, whiteSG.getX(), "x incorrecte");
        assertEquals(0, whiteSG.getY(), "y incorrecte");
        assertTrue(whiteSG.isWhite(), "color incorrecte");

        SilverGeneral blackSG = new SilverGeneral(3, 6, false);
        assertEquals("S", blackSG.getName(), "fitxa incorrecte");
        assertEquals(3, blackSG.getX(), "x incorrecte");
        assertEquals(6, blackSG.getY(), "y incorrecte");
        assertFalse(blackSG.isWhite(), "color incorrecte");


        //Com el tauler es de 9x9, les posicions no poden ser ni mes petites que 0
        //ni mes grans que 8
        assertThrows(IllegalArgumentException.class, () -> new SilverGeneral(-10, -10, true),
                "El constructor hauria de llemçar excepcio valors molt negatius");

        assertThrows(IllegalArgumentException.class, () -> new SilverGeneral(-1, -1, true),
                "El constructor hauria de llemçar excepcio valors  negatius");

        Piece piece5 = new SilverGeneral(5, 6, true);
        assertEquals(5, piece5.getX(), "el constructor no permet valors de x del rang 0 - 8");
        assertEquals(6, piece5.getY(), "el constructor no permet valors de y del rang 0 - 8");

        Piece piece8 = new SilverGeneral(8, 8, true);
        assertEquals(8, piece8.getX(), "el constructor no permet valors frontera de x");
        assertEquals(8, piece8.getY(), "el constructor no permet valors frontera de y");

        assertThrows(IllegalArgumentException.class, () -> new SilverGeneral(9, 9, true),
                "El constructor hauria de llemçar excepcio valos positius");

        assertThrows(IllegalArgumentException.class, () -> new SilverGeneral(10, 10, true),
                "El constructor hauria de llemçar excepcio valors molt positius");
    }

    @Test
    void testIsValidMoveSG() {
        MockBoardW taulell_aux_w = new MockBoardW();
        Piece sg_00 = taulell_aux_w.getPiece(0, 0);
        assertFalse(sg_00.isValidMove(-1, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(sg_00.isValidMove(1, -1, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(sg_00.isValidMove(-1, 1, taulell_aux_w.MockBoardW), "es mou fora taulell");

        Piece sg_88 = taulell_aux_w.getPiece(8, 8);
        assertFalse(sg_88.isValidMove(8, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(sg_88.isValidMove(9, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");
        assertFalse(sg_88.isValidMove(7, 9, taulell_aux_w.MockBoardW), "es mou fora taulell");

        Piece sg_24 = taulell_aux_w.getPiece(2, 4);
        assertTrue(sg_24.isValidMove(2, 5, taulell_aux_w.MockBoardW), "no permet moviment correcte");
        assertTrue(sg_24.isValidMove(3, 5, taulell_aux_w.MockBoardW), "no permet moviment correcte");
        assertTrue(sg_24.isValidMove(1, 3, taulell_aux_w.MockBoardW), "no permet moviment correcte");
        assertFalse(sg_24.isValidMove(2, 6, taulell_aux_w.MockBoardW), "permet moviments dobles");
        assertFalse(sg_24.isValidMove(0, 4, taulell_aux_w.MockBoardW), "permet moviments dobles");

        Piece sg_54 = taulell_aux_w.getPiece(5, 4);
        assertTrue(sg_54.isValidMove(6, 5, taulell_aux_w.MockBoardW), "no permet menjar");
        assertFalse(sg_54.isValidMove(5, 5, taulell_aux_w.MockBoardW), "permet menjar blanques");

        MockBoardB taulell_aux_b = new MockBoardB();
        Piece sg_00B = taulell_aux_b.getPiece(0, 0);
        assertFalse(sg_00B.isValidMove(-1, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(sg_00B.isValidMove(1, -1, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(sg_00B.isValidMove(-1, 1, taulell_aux_b.MockBoardB), "es mou fora taulell");

        Piece sg_88B = taulell_aux_b.getPiece(8, 8);
        assertFalse(sg_88B.isValidMove(8, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(sg_88B.isValidMove(9, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");
        assertFalse(sg_88B.isValidMove(7, 9, taulell_aux_b.MockBoardB), "es mou fora taulell");

        Piece sg_24B = taulell_aux_b.getPiece(2, 4);
        assertFalse(sg_24B.isValidMove(1, 4, taulell_aux_b.MockBoardB), "permet moviment horitzontal");
        assertFalse(sg_24B.isValidMove(2, 5, taulell_aux_b.MockBoardB), "permet moviment cap abaix");
        assertTrue(sg_24B.isValidMove(1, 3, taulell_aux_b.MockBoardB), "no permet moviment correcte");
        assertFalse(sg_24B.isValidMove(2, 6, taulell_aux_b.MockBoardB), "permet moviments dobles");
        assertFalse(sg_24B.isValidMove(1, 2, taulell_aux_b.MockBoardB), "permet moviments dobles");

        Piece sg_54B = taulell_aux_b.getPiece(5, 4);
        assertTrue(sg_54B.isValidMove(6, 5, taulell_aux_b.MockBoardB), "no permet menjar");
        assertFalse(sg_54B.isValidMove(5, 3, taulell_aux_b.MockBoardB), "permet menjar blanques");
    }
}
