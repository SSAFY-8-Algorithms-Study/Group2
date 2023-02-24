import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class BOJ_11723_집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[21]; // 주어지는 수 범위 1 <= x <= 20
		
		int[] all = new int[21];
		for (int i = 0; i < all.length; i++) {
			all[i]++;
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			int num = 0;
			if(!cmd.equals("all") && !cmd.equals("empty")) {
				num = Integer.parseInt(st.nextToken());
			}
			
			switch(cmd) { // 각 기능 수행
				case "add":
					arr[num] = 1;
					break;
				case "remove":
					arr[num] = 0;
					break;
				case "check":
					sb.append(arr[num] == 1 ? "1\n" : "0\n");
					break;
				case "toggle":
					arr[num] = arr[num] == 1 ? 0 : 1;
					break;
				case "all":
					arr = all.clone();
					break;
				case "empty":
					arr = new int[20];
					break;
			}
		}
		
		System.out.print(sb);
	}
}