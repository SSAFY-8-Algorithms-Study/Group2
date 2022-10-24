package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B14225_부분수열의합 {
	static int N;
	static int[] s;
	static boolean[] selected;
	static Set<Integer> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = new int[N];
		selected = new boolean[N];
		set = new HashSet<>();
		for(int i=0; i<N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		subset(0);
		//System.out.println(set.toString());
		for(int i=1; i<=100000 * 20; i++) {	//여기서 여러번 틀림 ㅠ
			if(!set.contains(i)) {
				System.out.println(i);
				return;
			}
		}
	}
	static void subset(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i=0; i<N; i++) {	//부분 집합의 합
				if(selected[i]) {
					//System.out.print(s[i] + " ");
					sum += s[i];
				}
			}
			if(sum == 0) return;
			//System.out.println();
			set.add(sum);
			return;
		}
		
		selected[idx] = true;
		subset(idx + 1);
		selected[idx] = false;
		subset(idx + 1);
	}
}
