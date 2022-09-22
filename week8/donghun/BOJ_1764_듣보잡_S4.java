package group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class BOJ_1764_듣보잡_S4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<String> a = new HashSet<>();
        ArrayList<String> b = new ArrayList<>();

        TreeSet<String> t = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.next());
        }

        for (int i = 0; i < m; i++) {
            b.add(sc.next());
        }

        for (int i = 0; i < m; i++) {
            String str = b.get(i);
            if (a.contains(str)) {
                t.add(str);
            }
        }

        // Iterator 사용
        for (String s : t) {//값이 있으면 true 없으면 false
            sb.append(s).append("\n");
        }

        System.out.println(t.size());
        System.out.println(sb);
    }
}
