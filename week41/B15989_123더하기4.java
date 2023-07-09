package week43;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 시간 초 과 ~~~
 * 20m 00s
 */
public class B15989_123더하기4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            int answer = 1;

            //1,2 로 이루어진 경우
            if(N >= 3){
                answer += N / 2;
            }

            //1,3 로 이루어진 경우
            if(N >= 4){
                answer += N / 3;
            }

            // 2,3 로 이루어진 경우
            if(N >= 5){
                for(int i=1; i<= N/3; i++){
                    if((N - 3*i) % 2 == 0) answer++;
                }
            }

            if(N >= 6){
                for(int i=1; i<= N/3; i++){
                    for(int j=1; j<= N - 3 * i; j++){
                        if((N - 3*i) - 2*j > 0) answer++;
                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}