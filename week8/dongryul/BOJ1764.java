import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ1764 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		Set<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		for(int n=0; n<N; n++) {
			set.add(sc.next());
		}
		for(int m=0; m<M; m++) {
			String s = sc.next();
			boolean b = set.add(s);
			if(!b) {
				list.add(s);
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(String output : list) {
			System.out.println(output);
		}
	}
}
