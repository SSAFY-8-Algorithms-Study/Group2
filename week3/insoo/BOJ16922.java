import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*
 * BOJ 16922 Silver 3
 * 로마 숫자 만들기
 * 1. N개의 문자로 만들 수 있는 중복 조합
 * 2. 중복 조합의 합을 Set에 넣어 합의 중복 제거
 */
public class BOJ16922 {
	static int N;
	static int[] numbers;
	static int[] romman = {1,5,10,50};
	static Set<Integer> set;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		set = new HashSet<>();
		
		comb(0, 0);
		System.out.print(set.size());
	}

	static void comb(int cnt, int start) {
		//1. N개의 문자로 만들 수 있는 중복 조합
		if(cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += numbers[i];
			}
			// 2. 중복 조합의 합을 Set에 넣어 합의 중복 제거
			set.add(sum);
			return;
		}
		for (int i = start; i < 4; i++) {
			numbers[cnt] = romman[i];
			comb(cnt+1, i);
		}
	}
}