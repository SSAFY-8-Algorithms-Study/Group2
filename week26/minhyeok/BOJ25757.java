package week26.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ25757 {
    /**
     * Tier:
     * SILVER 5
     * Title: 임스와 함께하는 미니게임
     * Category: 자료 구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
     *
     * 해시맵을 사용해 이미 같이 플레이했던 유저를 관리한다.
     * 해시맵에 등록되지 않은 유저만 카운트해서 게임 종류별 플레이할 수 있는 수를 구한다.
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String category = st.nextToken();
        HashMap<String,Boolean> map = new HashMap<String, Boolean>();
        int totalPlayerCnt = 0;
        int ans = 0;

        switch (category) {
            case "Y":
                totalPlayerCnt = 1;
                break;
            case "F":
                totalPlayerCnt = 2;
                break;
            case "O":
                totalPlayerCnt = 3;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String player = br.readLine();
            Boolean result = map.getOrDefault(player,null);
            if (result == null) {
                map.put(player,true);
                cnt++;
                if (cnt == totalPlayerCnt) {
                    cnt = 0;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
