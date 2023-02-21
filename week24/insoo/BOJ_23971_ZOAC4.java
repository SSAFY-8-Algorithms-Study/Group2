import java.io.*;
import java.util.*;
class BOJ_23971_ZOAC4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 주어진 거리로 나눈 몫과 나머지 여부에 따른 1 더하기
		int A = (H / (N+1)) + ((H % (N+1)) != 0 ? 1 : 0);
		int B = (W / (M+1)) + ((W % (M+1)) != 0 ? 1 : 0);
        
		System.out.print(A * B);
	}
}