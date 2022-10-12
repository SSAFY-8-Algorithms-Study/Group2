package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2624_동전바꿔주기 {
	static int T;
	static int k;
	static ArrayList<Coin> list;
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		cnt = 0;
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			list.add(new Coin(price, cnt));
		}
		
		dfs(0, T);
		
		System.out.println(cnt);
	}
	static void dfs(int idx, int price) {
		if(price == 0) {
			cnt++;
			return;
		}
		if(idx == list.size()) {
			return;
		}
		Coin c = list.get(idx);
		
		for(int i=0; i<=c.cnt; i++) {
			if(price >= c.price * i) {
				dfs(idx+1, price - c.price * i);
			}
		}
	}
	static class Coin{
		int price;
		int cnt;
		
		public Coin(int price, int cnt) {
			this.price = price;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Coin [price=" + price + ", cnt=" + cnt + "]";
		}
		
	}
}
