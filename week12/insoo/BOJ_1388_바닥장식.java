import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * BOJ 1388 Silver 3
 * 바닥 장식
 */
public class BOJ_1388_바닥장식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		int cntRow = 0;
		
		for (int r = 0; r < N; r++) { // 가로 찾기
			int check = 0;
			for (int c = 0; c < M; c++) {
				if(map[r][c] == '-') check++;
				else check = 0;
				
				if(check == 1) cntRow++;
			}
		}
		
		int cntCol = 0;
		
		for (int c = 0; c < M; c++) { // 세로 찾기
			int check = 0;
			for (int r = 0; r < N; r++) {
				if(map[r][c] == '|') check++;
				else check = 0;
				
				if(check == 1) cntCol++;
			}
		}
		
		System.out.print(cntRow + cntCol);
	}
}