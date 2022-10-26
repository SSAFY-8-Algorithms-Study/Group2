package week13.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17244 {
    static int N, M, minTime, timeSum;
    static Point SPos;
    static char[][] map;
    static ArrayList<Point> itemList;

    static int[] order;
    static boolean[] visit;

    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        itemList = new ArrayList<Point>();

        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S') {
                    SPos = new Point(i, j);
                }
                if (map[i][j] == 'X') {
                    itemList.add(new Point(i, j));
                }
            }
        }
        order = new int[itemList.size()];
        visit = new boolean[itemList.size()];
        minTime = Integer.MAX_VALUE;
        itemOrderPerm(0);
    }

    public static void itemOrderPerm(int cnt) {		// 순열로 물건 챙길 순서 정하기
        if (cnt == itemList.size()) {
            findExit(order);
            return;
        }

        for (int i = 0; i < itemList.size(); i++) {
            if (visit[i]) continue;
            order[cnt] = i;
            visit[i] = true;
            itemOrderPerm(cnt + 1);
            visit[i] = false;
        }
    }

    public static void findExit(int[] order) {
        //TODO BFS 다시 짜보기,,
    }

    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}