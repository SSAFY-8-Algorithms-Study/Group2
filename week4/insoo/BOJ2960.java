import java.util.Scanner;
/*
 * BOJ 2960 Silver 4
 * 에라토스테네스의 체
 * 1. 2부터 1씩 커지는 수
 * 2. i의 배수 탐색
 * 3. 배수에 해당하면 제거 처리
 * 4. K만큼 카운트되면 해당하는 값 출력
 */
public class BOJ2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] map = new boolean[N+1];
		int cnt = 0;
		
		for (int i = 2; i <= N; i++) { // 1. 2부터 1씩 커지는 수
			for (int j = 1; j <= N/i; j++) { // 2. i의 배수 탐색
				if(!map[i*j]) {
					map[i*j] = true; // 3. 배수에 해당하면 제거 처리
					cnt++;
					if(cnt == K) { // 4. K만큼 카운트되면 해당하는 값 출력
						System.out.print(i*j);
						return;
					}
				}
			}
		}
	}
}