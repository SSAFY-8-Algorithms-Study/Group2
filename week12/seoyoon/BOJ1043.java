package week12.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/* BOJ1043:거짓말 */
public class BOJ1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] party = new int[M + 1][N + 1];	// 파티에 오는 사람 저장 배열
        boolean[][] partyVisit = new boolean[M + 1][N + 1];

        // 진실 아는 사람 입력
        st = new StringTokenizer(br.readLine());
        int truePeopleCnt = Integer.parseInt(st.nextToken());
        int[] truePeople = new int[truePeopleCnt];

        for (int i = 0; i < truePeopleCnt; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
        }

        // 파티 입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyPeopleCnt = Integer.parseInt(st.nextToken());

            for (int p = 0; p < partyPeopleCnt; p++) {
                int num = Integer.parseInt(st.nextToken());
                party[i][num] = 1;
                partyVisit[i][num] = true;
            }
        }

        // 진실 아는 사람 배열 돌며 못가는 파티 체크
        for (int i = 0; i < truePeopleCnt; i++) {
            Queue<Integer> q = new ArrayDeque<Integer>();
            int trueMan = truePeople[i];
            q.add(trueMan);

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int j = 1; j <= M; j++) {
                    if (party[j][cur] == 1) {	// 진실을 아는 사람이 참가하는 파티에 가서
                        partyVisit[j][cur] = false;

                        for (int k = 1; k <= N; k++) {	// 그 파티에 오는 사람들 모두
                            if (party[j][k] == 1 && partyVisit[j][k]) {
                                partyVisit[j][k] = false;	// 방문 처리하고
                                q.add(k);		// queue에 넣기
                            }
                        }
                    }
                }
            }
        }

        // 과장된 이야기를 할 수 있는 파티 개수 구하기
        int ans = 0;
        for (int i = 1; i <= M; i++) {	// 각 파티를 돌며
            for (int j = 1; j <= N; j++) {
                if (partyVisit[i][j] == true) {		// true가 남아 있다면 과장된 이야기를 할 수 있다는 뜻
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
