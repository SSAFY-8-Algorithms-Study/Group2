package week11.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17143 {
    static int R, C, M;	// M: 상어의 수
    static Shark[][] map;

    static int[] di = {0, -1, 1, 0, 0};
    static int[] dj = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(s, d, z);
        }
        // End Input

        int fisherMan = 0;
        int sharkSum = 0;
        while (fisherMan < C) {
            // 1. 낚시꾼 이동
            fisherMan++;

            // 2. 가장 가까운 상어 잡기
            for (int i = 1; i <= R; i++) {
                if (map[i][fisherMan] != null) {
                    sharkSum += map[i][fisherMan].z;
                    map[i][fisherMan] = null;
                    break;
                }
            }

            // 3. 상어 이동
            Shark[][] newMap = new Shark[R + 1][C + 1];

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j] != null) {
                        Shark curShark = map[i][j];
                        map[i][j] = null;

                        int curi = i, curj = j;

                        // 세로 상어
                        if (curShark.d == 1 || curShark.d == 2) {
                            int move = curShark.s % ((R - 1) * 2);

                            for (int m = 0; m < move; m++) {
                                int newi = curi + di[curShark.d];
                                int newj = curj + dj[curShark.d];

                                if (newi < 1 || newi > R) {
                                    curShark.d = reverse(curShark.d);
                                    newi = curi + di[curShark.d];
                                    newj = curj + dj[curShark.d];
                                }
                                curi = newi;
                                curj = newj;
                            }

                        }
                        // 가로 상어
                        else if (curShark.d == 3 || curShark.d == 4) {
                            int move = curShark.s % ((C - 1) * 2);

                            for (int m = 0; m < move; m++) {
                                int newi = curi + di[curShark.d];
                                int newj = curj + dj[curShark.d];

                                if (newj < 1 || newj > C) {
                                    curShark.d = reverse(curShark.d);
                                    newi = curi + di[curShark.d];
                                    newj = curj + dj[curShark.d];
                                }
                                curi = newi;
                                curj = newj;
                            }
                        }
                        // 4. 상어 잡아먹기
                        if (newMap[curi][curj] == null) {	// 같은 칸에 다른 상어가 없다면 바로 넣고
                            newMap[curi][curj] = curShark;
                        }
                        else {	// 같은 칸에 다른 상어가 있다면 현재 상어의 크기가 클 때만 넣기
                            if (newMap[curi][curj].z < curShark.z) {
                                newMap[curi][curj] = curShark;
                            }
                        }
                    }
                }
            }
            map = newMap;
        }
        System.out.println(sharkSum);
    }

    static int reverse(int d) {
        if (d == 1) return 2;
        else if (d == 2) return 1;
        else if (d == 3) return 4;
        else return 3;
    }

    static class Shark {
        int s, d, z;

        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}