import java.io.*;

public class Backjoon9663{
    static int count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(bf.readLine());

        //보드판 만들기
        int [][] board=new int[n][n];

        backtracking(board, 0, n);

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        bf.close();
        
    }

    static boolean check(int[][] board, int n, int row, int col){

        // 1. 같은 열에 퀸이 있는지 검사 (현재 행 위쪽만 확인)
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // 2. 왼쪽 위 대각선에 퀸이 있는지 검사
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 3. 오른쪽 위 대각선에 퀸이 있는지 검사
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 모든 검사를 통과하면 안전합니다.
        return true;
    }

    static void backtracking(int[][] board, int row, int n){
        if(row==n){
            count++;
            return;
        }

        for(int col=0;col<n;col++){
            if(check(board, n, row, col)) {
                board[row][col] = 1;
                backtracking(board, row+1, n);
                board[row][col] = 0;
            }
        }
    }
}
