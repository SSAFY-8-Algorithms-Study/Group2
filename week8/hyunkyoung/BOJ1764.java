package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1764 { // 듣보잡
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 듣
		int M = Integer.parseInt(st.nextToken()); // 보
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N + M; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(String key : map.keySet()) {
			if(map.get(key) > 1) {
				list.add(key);
			}
		}
		
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append('\n');			
		}
		
		System.out.println(list.size());
		System.out.println(sb);
	}
}
