package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ16922 { // 로마 숫자 만들기
	static int N;
	static int[] arr = {1, 5, 10, 50};
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 문자 개수
		list = new ArrayList<>(); // 문자 합 저장 리스트
		
		select(0, 0, 0);
		System.out.println(list.size());
	}
	
	static void select(int cnt, int start, int sum) {
		if(cnt == N) {
			if(!list.contains(sum)) { // 중복 체크
				list.add(sum);
			}
			return;
		}
		
		for(int i = start; i < 4; i++) {
			select(cnt + 1, i, sum + arr[i]);
		}
	}
}
