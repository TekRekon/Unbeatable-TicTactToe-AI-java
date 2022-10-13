public class AI {
    int minimax(Board board, int depth, boolean isMaximizing) {
        String result = board.checkWin();
        if ((depth == 0) || (result.equals("tie"))) {
            return 0;
        }
        else if (result.equals("win")) {
            return 10;
        }
        else if (result.equals("lose")) {
            return -10;
        }

        if (isMaximizing) {
            int bestScore = -1000;
            for (int i = 0; i < 9; i++) {
                if (board.returnCell(i) == 3) {
                    board.modifyCell(i, 1);
                    int score = minimax(board, depth - 1, false);
                    board.modifyCell(i, 3);
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        }
        else {
            int bestScore = 1000;
            for (int i = 0; i < 9; i++) {
                if (board.returnCell(i) == 3) {
                    board.modifyCell(i, 0);
                    int score = minimax(board, depth - 1, true);
                    board.modifyCell(i, 3);
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;

        }
    }

    int bestMove(Board board, int depth) {
        int bestScore = -1000;
        int move = 0;
        for (int i = 0; i < 9; i++) {
            if (board.returnCell(i) == 3) {
                board.modifyCell(i, 1);
                int score = minimax(board, depth - 1, false);
                board.modifyCell(i, 3);
                if (score > bestScore) {
                    bestScore = score;
                    move = i;
                }
            }
        }
        return move;
    }

}
