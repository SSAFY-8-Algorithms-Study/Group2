package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week12_1_바닥장식 {
    static int N, M;
    static int[][] origin, rotatedMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        origin = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (c[j] == '|') {
                    origin[i][j] = 1;
                } else {
                    origin[i][j] = 0;
                }
            }
        }
        // 입력 종료

//        print(origin);

        int r = calcOrigin();

        rotatedMap = new int[M][N];
        rotate90();

//        print(rotatedMap);

        int c = calcRotated();

        System.out.println(r + c);
    }

    static void rotate90() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rotatedMap[i][j] = origin[j][i];
            }
        }
    }

    static int calcOrigin() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < M; j++) {
                if (origin[i][j] == 0) {
                    if (temp == 0) {
                        count++;
                    }
                    temp++;
                } else {
                    temp = 0;
                }
            }
        }
//        System.out.println(count);
        return count;
    }

    static int calcRotated() {
        int count = 0;
        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (rotatedMap[i][j] == 1) {
                    if (temp == 0) {
                        count++;
                    }
                    temp++;
                } else {
                    temp = 0;
                }
            }
        }
//        System.out.println(count);
        return count;
    }


    static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
