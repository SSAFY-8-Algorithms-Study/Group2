package group;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11387_님무기가좀나쁘시네여_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 장비 중의 스탯
        long[] equipedA = new long[5];
        long[] equipedB = new long[5];

        // 무기 스탯
        long[] weaponA = new long[5];
        long[] weaponB = new long[5];

        // 맨몸 스탯
        long[] manA = new long[5];
        long[] manB = new long[5];

        // 무기 바꿔든 뒤 스탯
        long[] swapedA = new long[5];
        long[] swapedB = new long[5];

        // 입력
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            switch (i) {
                case 0:
                    insert(equipedA, st);
                    break;
                case 1:
                    insert(equipedB, st);
                    break;
                case 2:
                    insert(weaponA, st);
                    break;
                case 3:
                    insert(weaponB, st);
                    break;
            }
        }

        // 맨몸 스탯
        for (int i = 0; i <5; i++) {
            manA[i] = equipedA[i] - weaponA[i];
            manB[i] = equipedB[i] - weaponB[i];
        }

        // 무기 바꿔든 뒤 스탯
        for (int i = 0; i < 5; i++) {
            swapedA[i] = manA[i] + weaponB[i];
            swapedB[i] = manB[i] + weaponA[i];
        }
        // 입력 종료

        long beforeA = power(equipedA[0],equipedA[1],equipedA[2],equipedA[3],equipedA[4]);
        long beforeB = power(equipedB[0],equipedB[1],equipedB[2],equipedB[3],equipedB[4]);
        long afterA = power(swapedA[0],swapedA[1],swapedA[2],swapedA[3],swapedA[4]);
        long afterB = power(swapedB[0],swapedB[1],swapedB[2],swapedB[3],swapedB[4]);


//        System.out.println("manA,B");
//        System.out.println(Arrays.toString(manA));
//        System.out.println(Arrays.toString(manB));
//        System.out.println("----------");
//        System.out.println("weaponA,B");
//        System.out.println(Arrays.toString(weaponA));
//        System.out.println(Arrays.toString(weaponB));
//        System.out.println("==========");
//        System.out.println("equipedA,B");
//        System.out.println(Arrays.toString(equipedA));
//        System.out.println(Arrays.toString(equipedB));
//        System.out.println("----------");
//        System.out.println("swapedA,B");
//        System.out.println(Arrays.toString(swapedA));
//        System.out.println(Arrays.toString(swapedB));
//        System.out.println("==========");
//        System.out.println("beforeA,B");
//        System.out.println(beforeA+", "+afterA);
//        System.out.println(beforeB+", "+afterB);
//        System.out.println("----------");
//        System.out.println("result");
        print(beforeA, afterA);
        print(beforeB, afterB);
    }

    static long power(long ATK, long STR, long CRIT_MULT, long CRIT_RATIO, long AS) {
        return ATK * (100+STR) * (100*(100 - Math.min(CRIT_MULT,100)) + Math.min(CRIT_MULT,100) * (CRIT_RATIO)) * (100+AS);
    }
    static void insert(long[] arr, StringTokenizer st) {
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    static void print(long before, long after) {
        long ans = after - before;
        if (ans > 0) {
            System.out.println("+");
        } else if (ans < 0) {
            System.out.println("-");
        } else {
            System.out.println("0");
        }
    }
}
