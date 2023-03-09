import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ25757_임스와_함께하는_미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int total = 0;

        if (game.equals("Y")) total = 1;
        if (game.equals("F")) total = 2;
        if (game.equals("O")) total = 3;

        HashMap<String, Integer> map = new HashMap<>();

        for (int n = 0; n < N; n++) {
            String name = br.readLine();
            map.put(name, 0);
        }

        System.out.println(map.size() / total);
    }
}
