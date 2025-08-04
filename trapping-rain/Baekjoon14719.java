import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon14719{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int answer=trappingRain(bf);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }

    //사용자의 입력을 받기
    static int trappingRain(BufferedReader bf) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int width = Integer.parseInt(st.nextToken());
    
        //각 블록의 높이 입력받기
        st = new StringTokenizer(bf.readLine());
        int[] blocks = new int[width];
        for (int i = 0; i < width; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }

        return countingRain(blocks, width);
    }

    //빗물의 총량 계산하기
    static int countingRain(int[] blocks, int width){
        int[] leftMax = new int[width];
        int[] rightMax = new int[width];
        int totalWater = 0;

        // 왼쪽에서의 최대 높이
        leftMax[0] = blocks[0];
        for (int i = 1; i < width; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blocks[i]);
        }
        //오른쪽 최대 높이
        rightMax[width - 1] = blocks[width - 1];
        for (int i = width - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blocks[i]);
        }

        for (int i = 1; i < width - 1; i++) {
            int water = Math.min(leftMax[i], rightMax[i]) - blocks[i];
            if (water > 0) totalWater += water;
        }

        return totalWater;
    }
}
