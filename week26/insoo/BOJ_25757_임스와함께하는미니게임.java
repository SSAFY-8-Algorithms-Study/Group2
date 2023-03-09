package pending;
import java.io.*;
import java.util.*;
class BOJ_25757_임스와함께하는미니게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);
		int nPlayer = game == 'Y' ? 1 : (game == 'F' ? 2 : 3);
		int numAble = nPlayer;
		int answer = 0;
		
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 0; i < N; i++) {
			if(set.add(br.readLine())) { // set에 추가할 수 있으면
				if(--numAble == 0) { //
					numAble = nPlayer;
					answer++;
				}
			}
		}
		
		System.out.print(answer);
	}
}