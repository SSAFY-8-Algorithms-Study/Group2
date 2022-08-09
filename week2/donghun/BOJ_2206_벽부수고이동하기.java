package donghun;

import java.util.*;
import java.io.*;

public class BOJ_2206_벽부수고이동하기 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;

    static int[][] map;
    boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        boolean[][][] visit = new boolean[N][M][2];
        Queue<int[]> qu = new LinkedList<>(); // BFS..?
    }
}