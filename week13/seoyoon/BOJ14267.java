package week13.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ14267:회사 문화1 */
public class BOJ14267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] complArr = new int[n + 1];	// 칭찬 저장 배열
        int[] seniorArr = new int[n + 1];	// 상사 저장 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            seniorArr[i] = Integer.parseInt(st.nextToken());	// 각 직원당 직속 상사 번호 입력받음
        }

        complArr[1] = 0;									// 사장은 상사가 없으므로 칭찬을 받지 않는다.
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int junior = Integer.parseInt(st.nextToken());	// 칭찬 받은 직원 번호
            int w = Integer.parseInt(st.nextToken());		// 칭찬의 수치

            complArr[junior] += w;							// 칭찬받기~
        }

        for (int junior = 2; junior <= n; junior++) {		// 직급이 높은 직원부터 돌면서
            complArr[junior] += complArr[seniorArr[junior]];// 자기의 직속 상사가 받은 칭찬 수치를 가져와서 더해줌
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(complArr[i] +" ");
        }
        System.out.println(sb);
    }
}