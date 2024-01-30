import java.util.ArrayList;
import java.util.List;

public class NQueen {


    public static List<List<String>> solveNQueen(int n) {
        String[][] board = new String[n][n];
        for (String[] e : board) {
            for (int i = 0; i < n; i++) {
                e[i] = ".";
            }
        }
        return solve(board, 0, n);

    }

    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solve(String[][] board, int row, int n) {
        //end condition
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (String[] e : board) {
                String r = "";
                for (String ie : e) {
                    r = r + ie;
                }
                temp.add(r);
            }
            res.add(temp);
        }
        if(row == 4){
//            System.out.println("row"+row);
        }
        for (int col = 0; col < n; col++) {
            // isValid checks out that if the queen can be put here or not
            if (isValid(row, col, board, n)) {
                board[row][col] = "Q";

                //try to put queen next row
                solve(board, row + 1, n);
                //exit as not finished (row reach n), take away queen
                board[row][col] = ".";
            }
        }

        return res;
    }

    public static Boolean isValid(int row, int col, String[][] board, int n) {

        for (int i = 0; i < n; ++i) {

            //till here row can equal 4, but it goes back when each row has a queen so board[n][] will never be referred
            if (board[i][col].equals("Q")) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == row + col || row - col == i - j) {
                    if (board[i][j].equals("Q")) {
                        return false;
                    }
                }
            }
        }

/*        int t = Math.min(n - row, n - col);
        int p = row, q = col;
        for (int i = 0; i < t; ++i) {
            if (board[p][q].equals("Q")) {
                return false;
            }
            p++;
            q++;
        }

        p = row;
        q = col;
        t = Math.min(row, col);
        for (int i = t; i >= 0; i--) {
            if (board[p][q].equals("Q")) {
                return false;
            }
            p--;
            q--;
        }*/
        return true;
    }

    public static void main(String[] args) {

        System.out.println(solveNQueen(1));
    }
}
