package week3.donghun;

import java.util.Scanner;

public class BOJ_1213_펠린드롬_old {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        arr = new int[26][2];
        for (int i = 0; i < line.length(); i++) {
            int abc = line.charAt(i) - 'A';
            arr[i][0] = abc;
            arr[abc][1]++;
        }

        int sumCheck = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] % 2 == 1) {
                sumCheck++;
                if (sumCheck > 1) {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
            }
        }

//        Arrays.sort(arr, (o1, o2) -> o1[1] - o2[1]); // 갯수별 정렬
//        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]); // 사전순 정렬

        for (int i=0; i< arr.length; i++) {
            if (arr[i][1] > 0) {
            }
        }

        for (int i = arr.length-1; i>=0; i--) {

        }
    }
}
