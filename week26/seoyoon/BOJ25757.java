package week26.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/* BOJ 25757 : 임스와 함께하는 미니게임 */
public class BOJ25757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int players = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);
		
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < players; i++) {
			set.add(br.readLine());
		}
		
		if (game == 'Y') System.out.println(set.size() / 1);
		else if (game == 'F') System.out.println(set.size() / 2);
		else System.out.println(set.size() / 3);
	}
}