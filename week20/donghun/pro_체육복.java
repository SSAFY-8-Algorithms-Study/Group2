package temp_pro.week20;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.io.IOException;
import java.util.Queue;

public class pro_체육복 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        // 출력
        pro_체육복 S = new pro_체육복();
        System.out.println(S.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//      System.out.println(S.solution(5, new int[]{2, 4}, new int[]{3}));
//      System.out.println(S.solution(5, new int[]{2, 4}, new int[]{3}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 현황 배열
        int[] arr = new int[n];

        // 다 1벌로 초기화 (-1, 0, 1로 해도 되긴 함)
        Arrays.fill(arr, 1);

        // 여벌 가져온 애들 +1벌 반영
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1]++;
        }

        // 도둑 맞은 애들 -1벌 반영
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1]--;
        }

        // 체육복 없는 놈들 인덱스를 담을 queue 생성
        Queue<Integer> q = new ArrayDeque<Integer>();

        // 체육복 없는 놈들 인덱스를 queue에 추가
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) q.add(i);
        }

        int size = q.size();

        int turn = 0;
        while (!q.isEmpty()) {
            turn++;

            int idx = q.poll(); // 꺼낸 인덱스

            int l = idx - 1; // 왼쪽 놈
            int r = idx + 1; // 오른쪽 놈

            // 인덱스 Boundary Out 처리
            if (l == -1) l = 0; // 없는 놈이 제일 키 작은 놈이면 걍 더 작은 놈거 빌릴 기회 없는 놈
            if (r == n) r = n - 1; // 없는 놈이 제일 키 큰 놈이면 걍 더 큰 놈거 빌릴 기회 없는 놈

            if (arr[l] == 2 && arr[r] == 2) { // 양 쪽 다 들고있는 놈이면
                if (turn > size*2) { // 무한루프 비상탈출
                    arr[l]--; // 옛다
                    arr[idx]++; // ㄳ
                    continue;
                }
                q.add(idx); // 넌 기회 많으니 급한놈부터 처리하게 뒤로가

            } else if (arr[l] == 2) { // 왼쪽놈만 들고있는 상황이면
                arr[l]--; // 옛다
                arr[idx]++; // ㄳ

            } else if (arr[r] == 2) { // 오른쪽놈만 들고있는 상황이면
                arr[r]--; // 옛다
                arr[idx]++; // ㄳ

            }
        }

//        System.out.println(Arrays.toString(arr)); // 디버깅

        // 출석 부른다
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) answer++;
        }

        return answer;
    }
}
