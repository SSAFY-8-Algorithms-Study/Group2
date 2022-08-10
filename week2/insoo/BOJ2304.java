package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * BOJ 2304 silver 2
 * 창고 다각형
 * 1. 높이를 기준으로 내림차순 정률 후 maxHeight를 뽑는다.
 * 2. 위치를 나타내는 첫번째 인덱스를 기준으로 재정렬한다.
 * 3. 왼쪽 끝부터 maxHeight를 가진 기둥에 닿기까지 오른쪽으로 올라가며 각 넓이를 더한다.
 * 4. 오른쪽 끝부터 maxHeight를 가진 기둥에 닿기까지 왼쪽으로 올라가며 각 넓이를 더한다.
 * 5. maxHeight를 가진 기둥이 다수라면 기둥 사이의 거리를 구한 후 넓이를 더한다.
 */
public class BOJ2304 {
	static int[][] arr;
	static int maxHeight;
	static int maxArrSize;
	static int[] maxArr;
	static int area;
	static int idx = 0;
	static int endIdx;
	
	// 3. 왼쪽 끝부터 maxHeight를 가진 기둥에 닿기까지 오른쪽으로 올라가며 각 넓이 더하기
	static void calcLeft() {
		if(idx == maxArr[0]) return;

		int h = arr[idx][1];
		int nextIdx = getHigher(idx+1, h);
		int w = arr[nextIdx][0] - arr[idx][0];
		idx = nextIdx;
		area += w*h;
		
		calcLeft();
	}
	
	// 4. 오른쪽 끝부터 maxHeight를 가진 기둥에 닿기까지 왼쪽으로 올라가며 각 넓이 더하기
	static void calcRight() {
		if(endIdx == maxArr[maxArrSize-1]) return;

		int h = arr[endIdx][1];
		int nextIdx = getLower(endIdx-1, h);
		int w = arr[endIdx][0] - arr[nextIdx][0];
		endIdx = nextIdx;
		area += w*h;
		
		calcRight();
	}
	
	// 5. maxHeight를 가진 기둥이 다수라면 기둥 사이의 거리를 구한 후 넓이 더하기
	static void calcTop() {
		int w = (arr[maxArr[maxArrSize-1]][0]+1) - arr[maxArr[0]][0];
		area += w*maxHeight;
	}
	
	static int getHigher(int nextIdx, int h) {
		if(h < arr[nextIdx][1]) {
			return nextIdx;
		}
		return getHigher(nextIdx+1, h);
	}

	static int getLower(int nextIdx, int h) {
		if(h < arr[nextIdx][1]) {
			return nextIdx;
		}
		return getLower(nextIdx-1, h);
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        maxArr = new int[n];
		endIdx = arr.length-1;

        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 2; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        // 1. 높이를 기준으로 내림차순 정률 후 maxHeight를 뽑기
        Arrays.sort(arr, (a,b) -> {
        	if(a[1] == b[1]) return a[0]-b[0];
        	return b[1]-a[1];
        });
        maxHeight = arr[0][1];
        // 2. 위치를 나타내는 첫번째 인덱스를 기준으로 재정렬
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        for (int i = 0; i < arr.length; i++) {
			if(arr[i][1] == maxHeight) {
				maxArr[maxArrSize++] = i;
			}
		}
        calcLeft();
        calcTop();
        calcRight();
        
        System.out.print(area);
	}
}