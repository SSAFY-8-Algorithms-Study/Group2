package week8.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* BOJ 1764 : 듣보잡 */
public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> noHearSee = new TreeMap<>();

        int cnt = 0;
        for(int i = 0; i < N + M; i++) {
            String key = br.readLine();
            noHearSee.put(key, noHearSee.get(key) != null ? noHearSee.get(key) + 1 : 1);
            if(noHearSee.get(key) == 2) cnt++;
        }

        System.out.println(cnt);
        for (Map.Entry<String, Integer> entrySet : noHearSee.entrySet()) {
            if (entrySet.getValue() == 2) {
                System.out.println(entrySet.getKey());
            }
        }
    }
}
