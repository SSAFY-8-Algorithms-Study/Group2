import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 18429 Silver 3
 * 근손실
 */
public class BOJ_18429_근손실 {
	static int N, K, bigThree, answer;
	static int[] weightIncList, selected;
	static boolean[] isSelected;
	
	static boolean check(int[] list) {
		bigThree = 500; // 초기 3대 중량
		
		for(int n : list) {
			bigThree -= K; // 근손실 감소
			bigThree += n; // 운동 키트 중량 증가
			
			if(bigThree < 500) return false;
		}
		return true;
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			if(check(selected)) answer++; // 체크 메서드 호출하고 문제 없으면 카운트
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue; // 중복 순열 방지
			
			selected[cnt] = weightIncList[i];
			
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 운동 키트 수, 기간
		K = Integer.parseInt(st.nextToken()); // 중량 감소량
		
		weightIncList = new int[N]; // 중량 증가량 배열
		selected = new int[N]; // 순열 선택된 요소 배열
		isSelected = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int A = Integer.parseInt(st.nextToken());
			weightIncList[i] = A; // 중량 증가량
		}
		perm(0); // 순열 호출
		System.out.print(answer);
	}
}