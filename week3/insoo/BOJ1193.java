import java.util.Scanner;
/*
 * BOJ 1193
 * 분수찾기
 */
public class BOJ1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int left = 1;
		int right = 1;
		int cnt = 1;
		boolean toggle = false;

		while(cnt++ != n) {
			if(left == 1) {
				if(right % 2 == 1) {
					right++;
					toggle = !toggle;
				} else {
					left++;
					right--;
				}
			} else if(right == 1) {
				if(left % 2 == 1) {
					left--;
					right++;
				} else {
					left++;
					toggle = !toggle;
				}
			} else if(toggle) {
				left++;
				right--;
			} else {
				left--;
				right++;
			}
		}
		System.out.print(left+"/"+right);
	}
}