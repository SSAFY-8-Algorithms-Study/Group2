package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
 * BOJ 1764 Silver 4
 * 듣보잡
 */
public class BOJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String> list = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if(!set.add(name)) list.add(name);
		}
		Collections.sort(list);
		
		sb.append(list.size()+"\n");
		for(String e : list) sb.append(e+"\n");
		System.out.print(sb);
	}
}