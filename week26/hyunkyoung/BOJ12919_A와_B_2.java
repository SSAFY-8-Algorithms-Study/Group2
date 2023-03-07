import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ12919_A와_B_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        Queue<String> queue = new ArrayDeque<>();
        queue.add(T);

        while (true) {
            if (!queue.isEmpty()) {
                String str = queue.poll();
                int length = str.length();

                if (length == 1) {
                    System.out.println(0);
                    break;
                }

                String removeA = "", reverse = "";
                if (str.charAt(length - 1) == 'A') {
                    removeA = str.substring(0, length - 1);
                    queue.add(removeA);
                }

                if (str.charAt(0) == 'B') {
                    String removeB = str.substring(1, length);
                    reverse = new StringBuilder(removeB).reverse().toString();
                    queue.add(reverse);
                }

                if (removeA.equals(S) || reverse.equals(S)) {
                    System.out.println(1);
                    break;
                }
            } else {
                System.out.println(0);
                break;
            }
        }
    }
}
