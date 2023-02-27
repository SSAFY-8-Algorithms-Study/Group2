package algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
class BOJ_10431_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int P = Integer.parseInt(br.readLine());
		for (int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			sb.append(T + " ");

			int sum = 0;
			LinkedList<Integer> list = new LinkedList<>();
			list.add(Integer.parseInt(st.nextToken()));
			
			for (int j = 1; j < 20; j++) {
				int num = Integer.parseInt(st.nextToken());
				int idx = Collections.binarySearch(list, num); // 추가할 위치 구하기
				sum += list.size() - (Math.abs(idx) - 1); // 그래서 더 큰 거 몇개야
				
				list.add(num); // 추가 후 재정렬
				Collections.sort(list);
			}
			sb.append(sum + "\n");
		}
		
		System.out.print(sb);
	}
}