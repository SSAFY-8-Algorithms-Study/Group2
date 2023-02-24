package etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5073_삼각형과_세_변 {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] tri = new int[3];
			for(int t=0; t<3; t++) {
				tri[t] = Integer.parseInt(st.nextToken());
			}
			if(tri[0] + tri[1] + tri[2] == 0) break;
			Arrays.sort(tri);
			
			if(tri[0] == tri[1] && tri[1] == tri[2]) sb.append("Equilateral\n");
			else if(tri[0] + tri[1] <= tri[2]) sb.append("Invalid\n"); //a + b < c = Invalid
			else if(tri[0] == tri[1] || tri[1] == tri[2]) sb.append("Isosceles\n");
			else sb.append("Scalene\n");
			
		}
		System.out.println(sb.toString());
	}
}
