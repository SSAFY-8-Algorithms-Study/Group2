package seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* BOJ16235 - 나무 재테크 */
public class BOJ16235 {

    static class Tree {
        int y, x, age;
        boolean live;

        public Tree(int y, int x, int age, boolean live) {
            this.y = y;
            this.x = x;
            this.age = age;
            this.live = live;
        }
    }

    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};  // 8방향
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    static ArrayList<Tree> tree, baby;
    static Deque<Tree> dead;
    static int[][] ground, Arc;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 땅의 크기 N
        M = Integer.parseInt(st.nextToken());   // 나무의 개수
        K = Integer.parseInt(st.nextToken());   // K년 후의 나무의 갯수 구하기 <- ans에 필요

        ground = new int[N + 1][N + 1];
        // 땅의 양분 저장 배열
        for (int i = 1; i <= N; i++) {
            Arrays.fill(ground[i], 5);
        }

        // 추가할 양분 저장 배열 A[r][c]
        Arc = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                Arc[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tree = new ArrayList<>();
        dead = new ArrayDeque<>();

        // 나무정보 저장 리스트
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            tree.add(new Tree(y, x, age, true));
        }

        int yearPass = 0;
        while (yearPass < K) {
            spring();
            summer();
            autumn();
            winter();
            yearPass++;
        }
        System.out.println(tree.size());
    }

    public static void spring() {
        for (int i = 0; i < tree.size(); i++) {
            Tree tr = tree.get(i);
            if (ground[tr.y][tr.x] >= tr.age) {
                ground[tr.y][tr.x] -= tr.age;   // 자신의 나이만큼 양분을 먹고
                tr.age++;   // 나이가 1 증가
            } else {  // 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는
                tr.live = false;
                dead.add(tr);     // 죽은 나무에 저장
            }
        }
    }

    public static void summer() {
        //  봄에 죽은 나무가 양분으로 변하게 된다.
        for (Tree tr : dead) {      // 각각의 죽은 나무마다
            ground[tr.y][tr.x] += (tr.age / 2);     // (나이를 2로 나눈 값)이 나무가 있던 칸에 양분으로 추가된다.
        }
        dead.clear();
    }

    public static void autumn() {
        baby = new ArrayList<>();
        for (int i = 0; i < tree.size(); i++) {
            Tree tr = tree.get(i);

            if (tr.live) {
                if (tr.age % 5 == 0) {
                    for (int d = 0; d < 8; d++) {   //  인접한 8개의 칸에
                        int newY = tr.y + dy[d];
                        int newX = tr.x + dx[d];

                        if (newY < 1 || newY > N || newX < 1 || newX > N) continue;
                        baby.add(new Tree(newY, newX, 1, true));    // 나이가 1인 나무가 생긴다.
                    }
                }
            }
        }

        for (Tree tr : tree) {
            if (tr.live) {
                baby.add(tr);
            }
        }
        tree = baby;
    }

    public static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ground[i][j] += Arc[i][j];
            }
        }
    }
}
