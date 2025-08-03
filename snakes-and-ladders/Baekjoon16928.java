import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon16928{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int answer=snakesNladders(bf);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }

    //사용자의 입력을 받음
    static int snakesNladders(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int ladders = Integer.parseInt(st.nextToken());
        int snakes = Integer.parseInt(st.nextToken());
        
        //보드판 초기화 (1~100)
        int[] board=new int[101];
        for (int i=1;i<=100;i++){board[i]=i;}
        
        //사다리 입력받기
        for(int i=0;i<ladders;i++){
            st = new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            board[from]=to;
        }

        //뱀 입력받기
        for(int i=0;i<snakes;i++){
            st = new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            board[from]=to;
        }
        return minMove(board);
    }

    //최소의 움직임 구히기
    static int minMove(int[] board){
        boolean[] visited = new boolean[101]; // 방문한 배열을 체크할 수 있는 배열 생성
        Queue<int[]> queue = new LinkedList<>(); // 큐 배열 생성
        queue.offer(new int[]{1, 0}); // {현재 위치, 이동 횟수} 형식으로 큐에 저장하기
        visited[1] = true; //1번쨰 칸은 시작 칸이기 때문에 방문한 것으로 간주

        while (!queue.isEmpty()) { //탐색할 위치가 남았을 경우 계속 반복
        int[] curr = queue.poll(); //큐 가장 앞의 요소 꺼냄
        int pos = curr[0]; //현재 위치 저장
        int dist = curr[1]; //이동횟수 저장

        if (pos == 100) return dist; //현재 위치 100 도달시 이동횟수 반환

        for (int dice = 1; dice <= 6; dice++) {
            int next = pos + dice;
            if (next <= 100) {
                next = board[next]; 
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, dist + 1}); //큐의 각 요소 갱신
                }
            }
        }
    }
    return -1;
    }
}