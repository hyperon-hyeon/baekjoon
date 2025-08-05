import java.io.*;

public class Baekjoon12904{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 

        int answer=stringGame(bf);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }

    //사용자의 입력을 받음
    static int stringGame(BufferedReader bf) throws IOException {
        String first = bf.readLine();
        String second =bf.readLine();
        
        
        return secondToFirst(first,second);
    }

    //두번째(결과로 주어진 값) -> 첫번째 값으로 갈 수 있는지 확인
    static int secondToFirst(String first, String second){

        while (second.length() >= first.length()) {
            //만약 두개가 같으면 1 리턴
            if(second.equals(first)) return 1;

            //다를 경우 다시 두번째(결과로 주어진 값) -> 첫번째 값으로 갈 수 있는지 확인
            else{
                char lastChar = second.charAt(second.length() - 1);

                second = second.substring(0, second.length() - 1);
                if(lastChar=='B') {
                    second = new StringBuilder(second).reverse().toString();
                }
            }
        }
        return 0;       
    }
}