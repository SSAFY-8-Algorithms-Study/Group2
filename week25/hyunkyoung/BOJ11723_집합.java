import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            String order = str.split(" ")[0];

            if(order.equals("all")) {
                list = new ArrayList<>();
                for (int j = 1; j <= 20; j++) {
                    list.add(j);
                }
            } else if (order.equals("empty")) {
                list = new ArrayList<>();
            } else {
                int x = Integer.parseInt(str.split(" ")[1]);

                switch (order) {
                    case "add":
                        if (!list.contains(x)) list.add(x);
                        break;
                    case "remove":
                        if (list.contains(x)) list.remove((Object) x);
                        break;
                    case "check":
                        if (list.contains(x)) sb.append(1).append("\n");
                        else sb.append(0).append("\n");
                        break;
                    case "toggle":
                        if (list.contains(x)) list.remove((Object) x);
                        else list.add(x);
                        break;
                }
            }
        }

        System.out.println(sb);
    }
}
