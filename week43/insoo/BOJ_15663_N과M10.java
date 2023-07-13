import java.io.*;
import java.util.*;
class Main {
	static int N, M;
	static int[] arr, selected;
	static StringBuilder sb;
	static Set<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		selected = new int[M];
		set = new HashSet<Integer>();
		
		perm(0, 0);
		System.out.print(sb);
	}
	
	static void perm(int idx, int cnt) {
		if(cnt == M) {
			if(set.add(Arrays.hashCode(selected))) {
				for(int num : selected) {
					sb.append(num + " ");
				} sb.append("\n");
			}
			return;
		}
		
		for (int i = idx; i < N; i++) {
			selected[cnt] = arr[i];
			perm(i+1, cnt+1);
		}
	}
}