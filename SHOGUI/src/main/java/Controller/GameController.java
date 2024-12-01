package Controller;

import Model.Board;

import java.util.Scanner;

public class GameController {
    private final Board board;

    public GameController() {
        this.board = new Board();    }
    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        boolean isWhiteTurn = true;

        while (true) {
            board.displayBoard();
            System.out.println((isWhiteTurn ? "White" : "Black") + "'s turn.");
            System.out.print("Enter move (format: x y newX newY): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int newX = scanner.nextInt();
            int newY = scanner.nextInt();

            if (board.getPiece(x, y) != null && board.getPiece(x, y).isWhite() == isWhiteTurn) {
                if (board.movePiece(x, y, newX, newY)) {
                    isWhiteTurn = !isWhiteTurn;
                } else {
                    System.out.println("Invalid move, try again.");
                }
            } else {
                System.out.println("Invalid piece selection, try again.");
            }
        }
    }
}
