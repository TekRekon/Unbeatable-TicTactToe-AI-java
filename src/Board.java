import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {
    private int[] state = {3, 3, 3, 3, 3, 3, 3, 3, 3};

    public void state(int[] board) {
        this.state = board;
    }

    public int returnCell(int cell) {
        return this.state[cell];
    }

    public boolean boardFull() {
        for (int i = 0; i < 9; i++) {
            if (this.state[i] == 3) {
                return false;
            }
        }
        return true;
    }

    public void modifyCell(int cell, int value) {
        this.state[cell] = value;
    }

    public String checkWin() {
        int winner = 3;
        if (((this.state[0] == this.state[1]) && (this.state[1] == this.state[2]))) {
            winner = this.state[0];
        }
        else if (((this.state[3] == this.state[4]) && (this.state[4] == this.state[5]))) {
            winner = this.state[3];
        }
        else if (((this.state[6] == this.state[7]) && (this.state[7] == this.state[8]))) {
            winner = this.state[6];
        }
        else if (((this.state[0] == this.state[3]) && (this.state[3] == this.state[6]))) {
            winner = this.state[0];
        }
        else if (((this.state[1] == this.state[4]) && (this.state[4] == this.state[7]))) {
            winner = this.state[1];
        }
        else if (((this.state[2] == this.state[5]) && (this.state[5] == this.state[8]))) {
            winner = this.state[2];
        }
        else if (((this.state[0] == this.state[4]) && (this.state[4] == this.state[8]))) {
            winner = this.state[0];
        }
        else if (((this.state[2] == this.state[4]) && (this.state[4] == this.state[6]))) {
            winner = this.state[2];
        }
        if (winner == 1) {
            return "win";
        }
        else if (winner == 0) {
            return "lose";
        }
        else if (this.boardFull()) {
            return "tie";
        }
        else {
            return "none";
        }

    }

    public void printBoard() {
        String[] board = new String[9];
        for (int i = 0; i < 9; i++) {
            if (this.state[i] == 1) {
                board[i] = "X";
            }
            else if (this.state[i] == 0) {
                board[i] = "O";
            }
            else {
                board[i] = " ";
            }
        }
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }
}
