package heap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B8979_올림픽 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Country> pq = new PriorityQueue<>();
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int Gold = Integer.parseInt(st.nextToken());
			int Silver = Integer.parseInt(st.nextToken());;
			int Bronze = Integer.parseInt(st.nextToken());;
			Country c = new Country(num, Gold, Silver, Bronze);
			pq.add(c);
		}
		//순위 매기기
		int[] grades = new int[N+1];
		int grade = 1;
		
		//맨 처음..
		Country now = pq.poll();
		
		grades[now.num] = 1;
		for(int n=1; n<N; n++) {
			Country next = pq.poll();
			
			if(now.Gold == next.Gold && now.Silver == next.Silver && now.Bronze == next.Bronze) {
				//동 순위
				grades[next.num] = grade;
				now = next;
				continue;
			}
			grades[next.num] = ++grade;
			now = next;
		}
		System.out.println(grades[K]);
	}
	static class Country implements Comparable<Country>{
		int num;
		int Gold;
		int Silver;
		int Bronze;
	
		public Country(int num, int Gold, int Silver, int Bronze) {
			this.num = num;
			this.Gold = Gold;
			this.Silver = Silver;
			this.Bronze = Bronze;
			
		}
		@Override
		public int compareTo(Country o) {

			if(o.Gold > this.Gold) {
				return 1;
			}else if(o.Gold < this.Gold) {
				return -1;
			}else {
				// 은 비교
				if(o.Silver > this.Silver) {
					return 1;
				}else if(o.Silver < this.Silver) {
					return -1;
				}else {
					// 동 비교
					if(o.Bronze > this.Bronze) {
						return 1;
					}else if(o.Bronze < this.Bronze) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		}
		
	}
}
