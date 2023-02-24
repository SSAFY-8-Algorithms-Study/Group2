package week24.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11723 {

    /**
     * Tier:
     * SILVER 5
     * Title: 집합
     * Category: 구현, 비트마스킹
     *
     * 입력에 대한 연산을 모두 구현하고 StringBuilder를 이용해 출력 시간을 최적화한다.
     */

    static int[] S;

    static void add(int num) {
        S[num] = num;
    }

    static void remove(int num) {
        S[num] = 0;
    }

    static int check(int num) {
        if (S[num] == num) return 1;
        return 0;
    }

    static void toggle(int num) {
        if (S[num] == num) {
            S[num] = 0;
        } else {
            S[num] = num;
        }
    }

    static void all() {
        for (int i=1; i<21; S[i]=i++);
    }

    static void empty() {
        S = new int[21];
    }

    public static void main(String[] args) throws IOException {
        S = new int[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            if (oper.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                add(num);
            } else if (oper.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                remove(num);
            } else if (oper.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                sb.append(check(num));
                sb.append("\n");
            } else if (oper.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                toggle(num);
            } else if (oper.equals("all")) {
                all();
            } else if (oper.equals("empty")) {
                empty();
            }
        }
        System.out.println(sb.toString());
    }
}
