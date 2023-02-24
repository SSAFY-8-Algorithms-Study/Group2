import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class BOJ_2292_벌집 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int pos = 1;
		int cnt = 1;
		
		while(pos < N) {
			pos += 6 * cnt; // 6의  배수로 커지는 테두리
			cnt++; // 거리
		}
		
		System.out.print(cnt);
	}
}