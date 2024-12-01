package Model;
import Model.pieces.*;

public class Board{
    //Atributs
    public Piece[][] board = new Piece[9][9];
    public boolean gameOver;

    //Metodes
    public Board() {
        initializeBoard();
    }
    public boolean isGameOver() {
        return gameOver;
    }
    private void initializeBoard() {
        // --- Inicialización de las piezas ---
        board[0][0] = new Lance(0, 0, true);
        board[1][0] = new Knight(1, 0, true);
        board[2][0] = new SilverGeneral(2, 0, true);
        board[3][0] = new GoldGeneral(3, 0, true);
        board[4][0] = new King(4, 0, true);
        board[5][0] = new GoldGeneral(5, 0, true);
        board[6][0] = new SilverGeneral(6, 0, true);
        board[7][0] = new Knight(7, 0, true);
        board[8][0] = new Lance(8, 0, true);

        board[1][1] = new Rook(1, 1, true);
        board[7][1] = new Bishop(7, 1, true);

        for (int i = 0; i < 9; i++) {
            board[i][2] = new Pawn(i, 2, true);
        }

        board[1][7] = new Rook(1, 7, false);
        board[7][7] = new Bishop(7, 7, false);

        board[0][8] = new Lance(0, 8, false);
        board[1][8] = new Knight(1, 8, false);
        board[2][8] = new SilverGeneral(2, 8, false);
        board[3][8] = new GoldGeneral(3, 8, false);
        board[4][8] = new King(4, 8, false);
        board[5][8] = new GoldGeneral(5, 8, false);
        board[6][8] = new SilverGeneral(6, 8, false);
        board[7][8] = new Knight(7, 8, false);
        board[8][8] = new Lance(8, 8, false);

        for (int i = 0; i < 9; i++) {
            board[i][6] = new Pawn(i, 6, false);
        }
    }
    public boolean movePiece(int x, int y, int newX, int newY) {
        Piece piece = board[x][y];
        if (piece != null && piece.isValidMove(newX, newY, board)) {
            board[newX][newY] = piece;
            board[x][y] = null;
            piece.move(newX, newY);
            return true;
        }
        return false;
    }

    public void displayBoard() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                Piece piece = board[x][y];
                if (piece == null) {
                    System.out.print(". ");
                } else {
                    System.out.print((piece.isWhite() ? "W" : "B") + piece.getName() + " ");
                }
            }
            System.out.println();
        }
    }
    //Getters
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public int[] findKing(boolean isWhiteKing) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Piece piece = board[x][y];
                if (piece != null && piece.getName().equals("K") && piece.isWhite() == isWhiteKing) {
                    return new int[]{x, y}; // Devuelve las coordenadas del rey
                }
            }
        }
        return null; //No hay rey
    }

    public boolean isKingInCheck(boolean isWhiteKing) {
        int[] kingPosition = findKing(isWhiteKing);
        if (kingPosition == null) return false;

        int kingX = kingPosition[0];
        int kingY = kingPosition[1];

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Piece piece = board[x][y];
                if (piece != null && piece.isWhite() != isWhiteKing) {
                    if (piece.isValidMove(kingX, kingY, board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void cleanBoard(){
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                board[x][y] = null;
            }
        }
    }

    public boolean isKingInCheckmate(boolean isWhiteKing) {
        if (!isKingInCheck(isWhiteKing)) {
            return false;
        }

        int[] kingPosition = findKing(isWhiteKing);
        if (kingPosition == null) return false;

        int kingX = kingPosition[0];
        int kingY = kingPosition[1];

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int newX = kingX + dx;
                int newY = kingY + dy;
                if (newX >= 0 && newX < 9 && newY >= 0 && newY < 9) {
                    if (board[kingX][kingY].isValidMove(newX, newY, board)) {
                        Piece original = board[newX][newY];
                        board[newX][newY] = board[kingX][kingY];
                        board[kingX][kingY] = null;

                        boolean stillInCheck = isKingInCheck(isWhiteKing);

                        board[kingX][kingY] = board[newX][newY];
                        board[newX][newY] = original;

                        if (!stillInCheck) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public void checkGameOver() {
        if (isKingInCheckmate(true)) {
            System.out.println("¡Jaque mate! El jugador negro gana.");
            gameOver = true;
        } else if (isKingInCheckmate(false)) {
            System.out.println("¡Jaque mate! El jugador blanco gana.");
            gameOver = true;
        }
    }
}
