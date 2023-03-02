package week25.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* BOJ 10431 : 줄 세우기 */
public class BOJ10431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int p = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < p; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			
			int goBack = 0;
			LinkedList<Integer> orderedLine = new LinkedList<Integer>();
			orderedLine.add(Integer.parseInt(st.nextToken()));
			
			for (int j = 1; j < 20; j++) {
				int student = Integer.parseInt(st.nextToken());
				
				if (student > orderedLine.getLast()) {
					orderedLine.addLast(student);
				}
				else {
					for (int k = 0; k < orderedLine.size(); k++) {
						if (student < orderedLine.get(k)) {
							goBack += (orderedLine.size() - k);
							orderedLine.add(k, student);
							break;
						}
					}
				}
			}
			sb.append(t).append(" ").append(goBack).append("\n");
		}
		System.out.println(sb);
	}
}