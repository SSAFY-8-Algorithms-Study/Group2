import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * BOJ 1043 Gold 4
 * 거짓말
 * 인접 리스트, flag 배열
 */
public class BOJ_1043_거짓말 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] knowList = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		int nPerson = Integer.parseInt(st.nextToken());
		for (int i = 0; i < nPerson; i++) { // 진실을 아는 사람
			int p = Integer.parseInt(st.nextToken());
			knowList[p] =  true;
		}
		
		ArrayList<Integer>[] attList = new ArrayList[M];
		for (int i = 0; i < M; i++) attList[i] = new ArrayList<>();
		boolean[] flag = new boolean[M]; // 파티별 진실 여부, true == 진실
		
		for (int i = 0; i < M; i++) { // 파티별 참여 명단
			st = new StringTokenizer(br.readLine());
			int nAtt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < nAtt; j++) {
				int att = Integer.parseInt(st.nextToken());
				attList[i].add(att);
			}
		}
		
		for (int i = 0; i < M; i++) {
			if(flag[i]) continue;
			
			boolean change = false;
			
			for (int j = 0; j < attList[i].size(); j++) {
				int att = attList[i].get(j);
				
				if(knowList[att] && !change) {
					change = true;
					j = -1;
					continue;
				} else if(!knowList[att] && change) {
					knowList[att] = true;
				}
			}
			if(change) {
				flag[i] = true;
				i = -1;
			}
		}
		
		int answer = 0;
		for(boolean e : flag) if(!e) answer++;
		System.out.print(answer);
	}
}