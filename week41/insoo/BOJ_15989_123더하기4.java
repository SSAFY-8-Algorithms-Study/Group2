package pending;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/*
 * 예시) 5를 구하는 과정
 * 1로만 표현할 수 있는 경우 = 1
 * 	1 1 1 1 1
 * 1과 2로만 표현할 수 있는 경우 = 5/2 = 2
 *  1 1 1 2
 *  1 2 2
 * 1과 3으로만 표현할 수 있는 경우 = 5/3 = 1
 *  1 1 3
 * 타겟이 2와 3을 합한 5보다 큰지 확인
 * 	1) 5를 초과한다면 (값-5)의 값으로 위 과정 DFS 수행
 * 		(6-5 => 1) == (6 => 1 2 3)
 * 	2) 5와 같다면 
 * 		(5 => 2 3)
 */
class BOJ_15989_123더하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append((div(n)+1) + "\n");
		}
		
		System.out.print(sb);
	}
	
	static int div(int n) {
		int res = 0;
		res += n / 2;
		res += n / 3;
		if(5 <= n) res += 1;
		
		if(5 < n) res += div(n - 5);
		
		return res;
	}
}