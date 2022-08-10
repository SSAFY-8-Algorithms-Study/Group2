package donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]);

        int count = 0;
        int end = 0;

        for(int i=0;i<N;i++) {
            if(arr[i][0]>=end) {
                end = arr[i][1]; // 셋팅: 이 종료 시간이 다음 인덱스의 시작 시간보다 앞섰는지에 대한 준비
                count++;
            }
        }

        System.out.println(count);

    }
}