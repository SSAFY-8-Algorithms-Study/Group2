package week12.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ14225:부분수열의 합 */
public class BOJ14225 {
    static boolean[] visit, nums;
    static int[] arr;
    static int MaxRange;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        MaxRange = N * 100000 + 1;
        visit = new boolean[N];
        nums = new boolean[MaxRange];
        subset(0);

        for (int i = 1; i <= MaxRange; i++) {
            if (!nums[i]) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void subset(int idx) {
        if (idx == arr.length) {
            int sum = 0;
            // 나올 수 있는 모든 부분집합을 구해
            for (int i = 0; i < arr.length; i++) {
                if (visit[i]) {
                    // 그 때의 합을
                    sum += arr[i];
                }
            }
            // 배열에 true 표시함
            nums[sum] = true;
            return;
        }

        visit[idx] = true;
        subset(idx + 1);
        visit[idx] = false;
        subset(idx + 1);
    }
}
