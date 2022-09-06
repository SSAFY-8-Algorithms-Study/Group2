package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2922 { // 즐거운 단어 ... (?)
	
	static char[] words; // 즐거운 단어 
	static int[] blanks; // 빈 칸 인덱스 
	static int bCnt; // 빈 칸 개수 카운트 
	static long ans; // long 타입으로 !!
	
	// 모음 자음 카운트하는 함수 
	static int[] check(int i) { 
		int[] res = new int[2]; // 최대 모음 개수, 최대 자음 개수 를 담을 배열 

		// 현재 위치 앞의 두 개 문자 체크 
		if (0<= i-2) { 
			int vCnt = 0; // 모음 카운트 
			int cCnt = 0; // 자음 카운트 
			for (int j : new int[] {-2,-1}) {
				char c = words[i+j];
				if (c == '_') continue; // 빈 칸이면 패스 
				if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
					vCnt++;
				} else {
					cCnt++;
				}
			}
			res[0] = Math.max(res[0], vCnt);
			res[1] = Math.max(res[1], cCnt);
		}
		
		// 현재 위치 앞의 문자, 뒤의 문자 체크 
		if (0<= i-1 && i+1<words.length) { 
			int vCnt = 0;
			int cCnt = 0;
			for (int j : new int[] {-1,1}) {
				char c = words[i+j];
				if (c == '_') continue;
				if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
					vCnt++;
				} else {
					cCnt++;
				}
			}
			res[0] = Math.max(res[0], vCnt);
			res[1] = Math.max(res[1], cCnt);
		}
		
		// 현재 위치 뒤의 문자 두 개 체크 
		if (i+2<words.length) { 
			int vCnt = 0;
			int cCnt = 0;
			for (int j : new int[] {1,2}) {
				char c = words[i+j];
				if (c == '_') continue;
				if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
					vCnt++;
				} else {
					cCnt++;
				}
			}

			res[0] = Math.max(res[0], vCnt);
			res[1] = Math.max(res[1], cCnt);
		}

		return res;
	}
	
	// 재귀 
	static void dfs(int cnt, long res) { 

		// 빈 칸 개수만큼 재귀 제한 
		if (cnt == bCnt) { 
			// 단어에 L 포함 여부 검사 
			boolean hasL = false;
			for (char c: words) { 
				if (c=='L') {
					hasL=true; // L 있는지 체크 
					break;
				}
			}
			if (hasL) { // L이 포함되어 있으면 경우의 수 정답에 더하기 
				ans += res;
			}
			return;
		}
		
		int curIdx = blanks[cnt]; // 현재 빈 칸의 위치 
		int[] vc = check(curIdx); // 현재 위치 주변의 최대 모음 자음 개수 체크 
		
		// 주변의 모음의 개수가 2개 미만이라면 아무 모음을 빈 칸에 쓰고 경우의 수 x5
		if (vc[0]<2) { 
			words[curIdx] = 'A';
			dfs(cnt+1, res*5);
			words[curIdx] = '_'; // 초기화를 꼭 해주기 
		}
		
		// 주변의 자음의 개수가 2개 미만이라면
		if (vc[1]<2) { 
			words[curIdx] = 'B'; // L이 아닌 경우 - 우선 L이 아닌 아무 문자 넣기 
			dfs(cnt+1,res*20); // L을 제외한 모든 자음의 개수 20개 
			words[curIdx] = '_'; // 다시 빈칸으로 
			
			words[curIdx] = 'L'; // L인 경우 
			dfs(cnt+1,res*1); // 경우의 수는 x1
			words[curIdx] = '_';
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		words = br.readLine().toCharArray(); // 단어 배열 입력 받기  
		for (char c: words) {
			if (c=='_') bCnt++; // 빈 칸 개수 세기 
		}
		
		blanks = new int[bCnt]; // 빈 칸 인덱스를 담은 배열 
		
		bCnt=0;
		for (int i=0; i<words.length; i++) {
			char c = words[i];
			if (c=='_') blanks[bCnt++] = i; // 빈 칸의 위치 저장 
		}
		dfs(0,1); // (빈 칸 카운트, 모든 경우의 수 결과값) 재귀 
		System.out.println(ans);
	}

}
