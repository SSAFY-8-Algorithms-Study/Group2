import java.util.Scanner;
/*
 * BOJ 20363 Silver 4
 * 당근 키우기
 */
public class BOJ_20363_당근키우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		System.out.print(Math.max(X,Y) + Math.min(X,Y) / 10 + Math.min(X,Y));
	}
}