import java.io.*;
import java.util.*;
class Main {
	static int N, M;
	static int[] selected, inputs;
	static boolean[] isSelected;
	static StringBuilder sb;
	static HashSet<Integer> set;
	
	static void perm(int cnt) {
		if(cnt == M) {
			boolean isAdded = set.add(Arrays.hashCode(selected));
			if(!isAdded) return;
			for(int e : selected) sb.append(e + " ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			selected[cnt] = inputs[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		isSelected = new boolean[N];
		set = new HashSet<>();
		
		inputs = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] =Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputs);
		perm(0);
		System.out.print(sb);
	}
}