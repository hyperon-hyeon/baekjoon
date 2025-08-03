    import java.io.*;

    public class Baekjoon1107{
        public static void main(String[] args)throws IOException{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
            int now=100;
            int answer=remote(bf,now);
            bw.write(String.valueOf(answer));

            bw.flush();
            bw.close();
        }

        //사용자의 입력을 받음
        static int remote(BufferedReader bf, int now) throws IOException {
            int goal = Integer.parseInt(bf.readLine());
            int num = Integer.parseInt(bf.readLine());
            
            //잘못누른 버튼 저장할 배열 초기화
            int[] wrong=new int[10];
            for (int i=0;i<10;i++){wrong[i]=0;}
            if (num!=0) {
                String[] arr=bf.readLine().split(" ");
                for(int i=0;i<num;i++){
                wrong[Integer.parseInt(arr[i])]=1;
                }
            }
            int answer=remoteControl(goal, wrong, now);
            return answer;
        }

        //버튼 누르는 횟수 계산하기
        static int remoteControl(int goal, int[] wrong, int now){
            //기본 최소값을 +, - 버튼 누르는 횟수로 설정함
            int min = Math.abs(goal - 100);

            //고장난 버튼을 누르지 않는 범위 내에서 최소값 갱신
            for(int i=0;i<1000000;i++){
                if(inspectWrong(wrong, i)==true){
                    int press = String.valueOf(i).length(); 
                    press += Math.abs(goal - i);           
                    if(press<min) min=press;
                }
            }
            return min;
        }

        //고장난 버튼 누르는지 확인
        static boolean inspectWrong(int[] wrong, int num){
            int digit=-1;
            if (num == 0) return wrong[0] == 0;
            while (num>0){
                digit=num%10;
                if(wrong[digit]==1) return false;
                num/=10;
            }
            return true;
        }
    }
