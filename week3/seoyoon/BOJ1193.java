package seoyoon;

import java.util.Scanner;

public class BOJ1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int level = 1, i = 1;
        String s = "";

        // X가 위치한 레벨을 찾기 위해 1, 2, 3, ,,, 증가시키며 뺄셈
        int num = X - i;
        while (num - i >= 0) {
            num = num - i;
            i++;
            level++;
        }

        // 해당 레벨이 짝수인 경우 탐색 방향 :: 1/level -> level/1
        if (level % 2 == 0) {
            s = (num + 1) + "/" + (level - num);
        }
        // 해당 레벨이 홀수인 경우 탐색 방향 :: level/1 -> 1/level
        else {
            s = (level - num) + "/" + (num + 1);
        }
        System.out.println(s);
    }
}
