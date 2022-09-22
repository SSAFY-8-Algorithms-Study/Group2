package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1764 { // 듣보잡 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,Boolean> map = new HashMap<String,Boolean>(); // 방문 체크 ?
		for (int i=0; i<N; i++) {
			map.put(br.readLine(), true); // 방문 
		}
		
		int cnt = 0; // 듣+보 카운트 
		ArrayList<String> arr = new ArrayList<String>(); // 듣+보 담기 
		for (int i=0; i<M; i++) {
			String str = br.readLine();
			if (map.get(str) != null) {
				cnt++;
				arr.add(str);
			}
		}
		
		Collections.sort(arr); // 문자열 정렬 
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		for (String s: arr) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}

}
