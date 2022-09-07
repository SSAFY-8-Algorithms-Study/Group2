package week6.seoyoon;

import java.util.Scanner;

/* 백준 10162: 전자레인지 */
public class BOJ10162 {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int T = sc.nextInt();
        int Acnt = 0, Bcnt = 0, Ccnt = 0;

        if (T % 10 != 0) {
            System.out.print(-1);
            return;
        }
        else {
            while (T > 0) {
                if (T >= 300) {
                    Acnt += T / 300;
                    T %= 300;
                }
                else if (60 <= T && T < 300) {
                    Bcnt += T / 60;
                    T %= 60;
                }
                else {
                    Ccnt += T / 10;
                    T %= 10;
                }
            }
        }
        System.out.println(Acnt +" "+ Bcnt + " " + Ccnt);
        return;
    }
}
