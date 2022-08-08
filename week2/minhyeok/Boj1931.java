package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1931 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Meeting> arr = new ArrayList<Meeting>();
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr.add(new Meeting(s,e));
		}
		Collections.sort(arr);
		int ans = 1;
		int curE = arr.get(0).e;
		for (int i=1;i<arr.size();i++) {
			if (arr.get(i).s>=curE) {
				ans +=1;
				curE = arr.get(i).e;
			}
			
		}
		System.out.println(ans);
	}
}

class Meeting implements Comparable<Meeting>{
	int s;
	int e;
	
	public Meeting(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Meeting o) {
		int res = this.e-o.e; // Sort Meeting with End Time
		if (res==0) {
			return this.s-o.s;
		} else {
			return res;
		}
	}
}