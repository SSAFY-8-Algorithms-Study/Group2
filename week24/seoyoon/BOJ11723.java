package week24.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/* 집합 */
public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();

            switch(operator) {
                case "add":
                    ad.add(Integer.parseInt(st.nextToken()));
                    break;

                case "check":
                    sb.append(ad.contains(Integer.parseInt(st.nextToken())) ? "1 \n" : "0 \n");
                    break;

                case "remove":
                    ad.remove(Integer.parseInt(st.nextToken()));
                    break;

                case "toggle":
                    int x = Integer.parseInt(st.nextToken());
                    if (ad.contains(x)) {
                        ad.remove(x);
                    }
                    else {
                        ad.add(x);
                    }
                    break;

                case "all":
                    ad = new ArrayDeque<Integer>();
                    for (int j = 1; j <= 20; j++) {
                        ad.add(j);
                    }
                    break;

                case "empty":
                    ad.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}
