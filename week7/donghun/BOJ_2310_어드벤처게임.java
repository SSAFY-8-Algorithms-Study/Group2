package week7.donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* BFS로 접근해서 방문 해제가 난해해진 상황
* while로 접근해서 풀던지 DFS로 바꾸던지 해서 풀어볼 예정
*/

public class BOJ_2310_어드벤처게임 {
    static int N, coin;
    static boolean[] visited;
    static Queue<Integer> q;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        outer:
        while (true) {
            N = Integer.parseInt(br.readLine()); // 방 갯수
            if (N == 0) break; // 방 없는 케이스면 프로그램 종료

            list = new ArrayList[N + 1]; // 방마다의 ArrayList
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }

            visited = new boolean[N + 1]; // 각 방의 방문 여부
            q = new LinkedList<>(); // 몇번 방 갈건데?
            coin = 0; // 플레이어 주머니 소환

            for (int i = 1; i <= N; i++) { // 방 갯수만큼 돈다
                String s = br.readLine();
                String[] str = s.split(" "); // 배열로 자르고
                int[] line = new int[str.length]; // parse할 int 배열 생성
                line[0] = str[0].charAt(0) - 'A'; // 타입 받고
                for (int z = 1; z < str.length; z++) { // 연결된 방 번호 받고
                    line[z] = Integer.parseInt(str[z]); // 예아
                }
                if (line[0] == 'E' - 'A') {
                    coin += line[1]; // 플레이어 금화 초기값
                    list[i].add(line[1]);
                    for (int j = 2; j < line.length - 1; j++) { // 각 줄에 주어진 정보. 마지막 0은 취급ㄴ
                        q.add(line[j]); // 자 드가자
                    }
                }
                // coin: 레플리컨이면 +값, 트롤이면 -값을 넣을 것임
                if (line[0] == 'L' - 'A') { // 착한놈
                    list[i].add(line[1]);
                    for (int j = 2; j < line.length - 1; j++) { //
                        list[i].add(line[j]);
                    }
                }
                if (line[0] == 'T' - 'A') { // 나쁜놈
                    list[i].add(-line[1]);
                    for (int j = 2; j < line.length - 1; j++) {
                        list[i].add(line[j]);
                    }
                }
            }
            bfs(coin);
        }
    }

    public static void bfs(int coin) {
        outer:
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int roomNo = q.poll();
                if (roomNo == N) {
                    System.out.println("YES");
                    break outer;
                }
                for (int i = 1; i < list[roomNo].size(); i++) {
                    int next = list[roomNo].get(i);
                    int nextCoin = list[next].get(0); // 방문할 방의 돈 미리보기

                    if (list[next].get(0) > 0) { // 레프리컨일때
                        q.add(next); // 무지성 방문

                        if (coin < nextCoin) { // 미만이야?
                            coin = nextCoin; // 최소 복지
                        }
                    }
                    if (list[next].get(0) < 0) { // 츄럴일때
                        if (coin < Math.abs(nextCoin)) { // 히히 못가
                            System.out.println("NO"); // 컫!
                            break outer;
                        } else {
                            q.add(next); // 방문은 할 수있네
                            coin += nextCoin;
                        }
                    }
                }
            }
        }
    }
}
