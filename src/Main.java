import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Board board = new Board();
        AI ai = new AI();
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        int turn = rand.nextInt(2);
        while (board.checkWin().equals("none")) {
            if (turn==0) {
                int x = ai.bestMove(board, 10);
                System.out.println("AI move");
                board.modifyCell(x, 1);
                board.printBoard();
                System.out.println("--------------------------------");
                turn++;
            } else {
                System.out.println("Enter a number (1-9): ");
                int n = reader.nextInt()-1;
                board.modifyCell(n, 0);
                System.out.println("Your move");
                board.printBoard();
                System.out.println("--------------------------------");
                turn--;
            }

        }
        System.out.println("AI " + board.checkWin() + "s");

    }
}
