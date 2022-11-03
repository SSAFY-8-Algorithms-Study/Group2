import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		int cnt = 0;

		while(st.hasMoreTokens()) {
			if(sum <= M) {
				int num = Integer.parseInt(st.nextToken());
				q.add(num);
				sum += num;
				
				if(sum == M) {
					cnt++;
				}
			}else {
				sum -= q.poll();
				if(sum == M) {
					cnt++;
				}
			}
		}
		while(!q.isEmpty()) {
			sum -= q.poll();
			if(sum == M) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

