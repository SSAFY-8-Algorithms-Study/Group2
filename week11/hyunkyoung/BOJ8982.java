package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ8982 { // 수족관1
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수족관 꼭짓점 개수
		ArrayList<Point> pList = new ArrayList<>();
		int colLen = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			pList.add(new Point(row, col));
			colLen = Math.max(colLen, col);
		}
		
		int[] water = new int[colLen];
		int[] depth = new int[colLen];
		
		for(int i = 0; i < pList.size(); i++) {
			if(i % 2 == 0) continue;
			if(i == pList.size() - 1) continue;
			
			int row = pList.get(i).x;
			int col = pList.get(i).y;
			int next_col = pList.get(i + 1).y;
			
			for(int c = col; c < next_col; c++) {
				water[c] = row;
				depth[c] = row;
			}			
		}
		
		int K = Integer.parseInt(br.readLine());
		ArrayList<Point> hList = new ArrayList<>();
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			hList.add(new Point(row, col));
		} // end input
		
		for(int h = 0; h < hList.size(); h++) {
			int rowNum = hList.get(h).x;
			int colNum = hList.get(h).y;
			
			for(int i = colNum; i >= 0; i--) { // 왼쪽
				if(depth[i] >= rowNum)
					water[i] = Math.min(water[i], depth[i] - rowNum);
				else {
					water[i] = 0;
					rowNum = depth[i];
				}
			}
			
			rowNum = hList.get(h).x;
			for(int i = colNum + 1; i < colLen; i++) { // 오른쪽
				if(depth[i] >= rowNum)
					water[i] = Math.min(water[i], depth[i] - rowNum);
				else {
					water[i] = 0;
					rowNum = depth[i];
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < colLen; i++) {
			result += water[i];
		}
		
		System.out.println(result);
	}
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
