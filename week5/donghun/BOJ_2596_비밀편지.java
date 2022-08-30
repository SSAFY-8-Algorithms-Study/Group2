package week5.donghun;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2596_비밀편지 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        ArrayList<Password> pass = new ArrayList<Password>();

        pass.add(new Password("A", "000000"));
        pass.add(new Password("B", "001111"));
        pass.add(new Password("C", "010011"));
        pass.add(new Password("D", "011100"));
        pass.add(new Password("E", "100110"));
        pass.add(new Password("F", "101001"));
        pass.add(new Password("G", "110101"));
        pass.add(new Password("H", "111010"));

        int n = sc.nextInt();

        String[] arr = new String[n];
        String line = sc.next();
        for (int i = 0; i < n; i++) {
            arr[i] = line.substring(6 * i, 6 * (i + 1));
        }

        boolean flag = false;
        int check = -1;
        outer:
        for (int i = 0; i < n; i++) { //[[], [], []]
            flag = false;
            for (int j = 0; j < 8; j++) { // [[], [], [], [], [], [], [], []]
                if (arr[i].equals(pass.get(j).pass)) { // 맞으면
                    sb.append(pass.get(j).alp); // 바로 넣고
                    flag = true;
                    break;
                } else {
                    int chance = 1; // 기회 한번 주고
                    for (int k = 0; k < arr[i].length(); k++) { // 해당 번호동안
                        if (arr[i].charAt(k) != pass.get(j).pass.charAt(k)) { // 검사
                            chance--;
                        }
                    }
                    if (chance >= 0) { // 1번만 제낀거면 추가, 아닌 경우 check 기록 및 종료
                        sb.append(pass.get(j).alp);
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                check = i;
                break;
            }
        }

        if (!flag) {
            System.out.println(check+1);
        } else {
            System.out.println(sb);
        }
    }

    static class Password {
        String alp, pass;

        public Password(String alp, String pass) {
            this.alp = alp;
            this.pass = pass;
        }
    }
}
