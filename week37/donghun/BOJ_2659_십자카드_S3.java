package donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2659_십자카드_S3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받아 정수로 만들기
        int input = 0;
        for (int i = 0; i < 4; i++) {
            input = input * 10 + Integer.parseInt(st.nextToken());
        }

        // 입력 값의 시계수 초기화
        int clock = input;

        // 입력 값의 시계수 구하기
        for (int i = 0; i < 4; i++) {
            input = (input % 1000) * 10 + input / 1000; // 첫자리를 마지막 자리로 옮기기
            if (input < clock) clock = input; // 갱신
        }

        // size로 답을 낼 것임
        HashSet<Integer> set = new HashSet<Integer>();

        // 1111 to 9999
        for (int start = 1111; start <= 9999; start++) {

            // 숫자에 0이 포함되어 있다면 건너뛰기
            if(Integer.toString(start).contains("0")) continue;

            int num = start;
            int min = start;

            for (int i = 0; i < 4; i++) {
                num = (num % 1000) * 10 + num / 1000; // 첫자리를 마지막 자리로 옮기기
                if (num < min) min = num; // 갱신
            }
            set.add(min);
        }

        int count = 0;
        for (int item : set) {
            if (item <= clock) {
                count++;
            }
        }
        System.out.println(count);
    }
}
