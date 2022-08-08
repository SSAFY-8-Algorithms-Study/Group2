package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj2304 {
	
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>(); // KEY: height , VALUE: list<int:x>
		int maxH = 0; // Max Height
		int maxX=0; // X (on Max Height)
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (map.get(h)==null) { 
				map.put(h, new ArrayList<Integer>()); // Map<Height, List<X>>
			}
			map.get(h).add(x);
			
			// Get Max Height, X
			if (maxH<h) {
				maxH=h;
				maxX=x;
			}
		}
		int l = maxX; // left side
		int r = maxX+1; // right side
		int ans = maxH; // area
		for (int i = maxH;i>=1;i--) {
			ArrayList<Integer> xList = map.get(i);
			if (xList != null) {
				for (int nx: xList) {
					if (nx < l) { // Move If X is Less than Current Left
						ans += (l-nx)*i;
						l = nx;
					}
					if (nx >= r) { // Move If X is equal to or greater than Current Right
						ans += (nx+1-r)*i; // Because It's Rectangle
						r = nx+1;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
