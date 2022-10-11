package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
* 15% 오답
*/

public class BOJ_6987_월드컵_G5 {
    static StringBuilder sb;
    static int[] input;
    static int[] out;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
//        out = new int[];
//        visited = new boolean[5];
        flag = false;

        int[][] map1 = new int[6][3];
        int[][] map2 = new int[6][3];
        int[][] map3 = new int[6][3];
        int[][] map4 = new int[6][3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                map1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                map2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                map3[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                map4[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println("(1)");
        check(map1);
//        System.out.println("\n(2)");
        check(map2);
//        System.out.println("\n(3)");
        check(map3);
//        System.out.println("\n(4)");
        check(map4);

        System.out.println(sb);
//        // 배열 입력 테스트
//        for (int i = 0; i < 6; i++)
//            System.out.println(Arrays.toString(map1[i]));
//        System.out.println();
//        for (int i = 0; i < 6; i++)
//            System.out.println(Arrays.toString(map2[i]));
//        System.out.println();
//        for (int i = 0; i < 6; i++)
//            System.out.println(Arrays.toString(map3[i]));
//        System.out.println();
//        for (int i = 0; i < 6; i++)
//            System.out.println(Arrays.toString(map4[i]));
    }

    static void check(int[][] map) {
        // 1개 팀의 승무패 합이 5가 맞는지
        for (int i = 0; i < 6; i++) {
            int sum1 = 0;
            for (int j = 0; j < 3; j++) {
                sum1 += map[i][j];
            }
            if (sum1 != 5) {
                sb.append("0 ");
                return;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 모든 팀의 승합-패합=0이 맞는지
        int winSum = 0;
        int loseSum = 0;

        for (int i = 0; i < 6; i++) {
            winSum += map[i][0];
            loseSum += map[i][2];

            int tmp = map[i][1]; // 무승부 값
            if (tmp != 0) pq.add(tmp); // 무승부 값들이 담긴긴 큐
        }
        if (winSum != loseSum) {
            sb.append("0 ");
            return;
        }


        int size = pq.size();

        if (size == 0) {
            sb.append("1 ");
            return;
        } else if (size % 2 == 1) {
            sb.append("0 ");
            return;
        }

        int pmSize = size * 2;
        input = new int[pmSize];
        out = new int[pmSize];

        for (int i = 0; i < pmSize; i+=2) {
            int temp = pq.poll();
            input[i] = temp;
            input[i+1] = -temp;
        }

        visited = new boolean[pmSize];

        comb(0, 0, size);
        // 각 팀의 무승부 조합의 합이 0이 맞는지

        if (flag) {
            sb.append("1 ");
        } else {
            sb.append("0 ");
        }

    }

    static void comb(int start, int cnt, int size) {
        if (cnt == size) {
            System.out.println(Arrays.toString(out));
            int sum = 0;
            for (int i = 0; i < out.length; i++) {
                sum += out[i];
            }
            if (sum == 0) {
                flag = true;
            }
        }

        for (int i = start; i < size; i++) {
            if (!visited[i]) {
                out[i] = input[i];
                visited[i] = true;
                comb(i + 1, cnt + 1, size);
                visited[i] = false;
            }
        }
    }

    static void print(int[][] map) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
