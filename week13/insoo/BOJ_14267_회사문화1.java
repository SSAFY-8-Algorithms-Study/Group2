package pending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14267_회사문화1 {
	static int n;
	static int[] resultList;
	static ArrayList<Integer>[] bossList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken()); // 직원 수
		int m = Integer.parseInt(st.nextToken()); // 칭찬 횟수
		
		bossList = new ArrayList[n+1]; // 상사 번호 인덱스, 부하 번호 값
		for (int i = 0; i < bossList.length; i++)  bossList[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int v = Integer.parseInt(st.nextToken());
			if(v == -1) continue;
			
			bossList[v].add(i);
		}
		
		resultList = new int[n+1]; // 칭찬 배열
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int ni = Integer.parseInt(st.nextToken()); // 직원 번호
			int w = Integer.parseInt(st.nextToken()); // 칭찬 수치
			
			resultList[ni] += w; // 직원 번호별로 칭찬을 미리 부여
		}
		
		goodBoy(1, 0); // 칭찬 메서드
		
		for (int i = 1; i < resultList.length; i++) {
			sb.append(resultList[i] + " ");
		}
		
		System.out.print(sb);
	}
	
	static void goodBoy(int idx, int w) {
		for (int i = 0; i < bossList[idx].size(); i++) {
			int boy = bossList[idx].get(i);
			
			resultList[boy] += w; // 상속 받은 칭찬 더하기
			goodBoy(boy, resultList[boy]); // 칭찬 상속
		}
	}
}