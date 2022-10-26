package greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B2138_전구와스위치 {
	static int N;
	static String ans;
	static Map<String, Integer> set;
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[] input = br.readLine().toCharArray();
		set = new HashMap<>();
		min = Integer.MAX_VALUE;
		ans = br.readLine();
		
		dfs(0, input);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	static void dfs(int idx, char[] str) {
		StringBuilder sb = new StringBuilder();
		String s = sb.append(str).toString();
		if(ans.equals(s)) {
			min = Math.min(min, idx);
			return;
		}
		
		for(int i=0; i<N; i++) {
			//앞에서 부터 꺼본다
			int before = i-1;
			int now = i;
			int next = i+1;
			
			if(before >= 0) {
				if(str[before] == '0') str[before] = '1';
				else str[before] = '0';
			}
			
			if(str[now] == '0') str[now] = '1';
			else str[now] = '0';
			
			if(next <= N-1) {
				if(str[next] == '0') str[next] = '1';
				else str[next] = '0';
			}
			String ss = new StringBuilder().append(str).toString();
			int cnt = set.getOrDefault(ss, 0);
			if(cnt == 0) {
				set.put(ss, idx);
				dfs(idx+1, str);
			}else if(cnt > idx) {
				set.put(ss, idx);
				dfs(idx+1, str);
			}
			
			if(before >= 0) {
				if(str[before] == '0') str[before] = '1';
				else str[before] = '0';
			}
			
			if(str[now] == '0') str[now] = '1';
			else str[now] = '0';
			
			if(next <= N-1) {
				if(str[next] == '0') str[next] = '1';
				else str[next] = '0';
			}
		}
	}
}