import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int[] arr = new int[tc+1];
		int result = 0;

		String[] strs = br.readLine().split(" ");
		for(int i=0; i<tc; i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int n = Integer.parseInt(br.readLine());
		arr[tc] = n;
		Arrays.sort(arr);
		
		for(int i=0; i<tc+1; i++) {
			if(arr[i] == n) {
				int maxRange = arr[i+1];
				if(arr[i] == maxRange) {
					break;
				}
			int minRange = 0;
			if(i!=0) minRange = arr[i-1];

			int distance = n - minRange;
			result += (distance * (maxRange - n - 1));
			result += distance - 1;
			}
		}
		System.out.print(result);
	}
}