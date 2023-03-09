package week26.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20125 {
    /**
     * Tier:
     * SILVER 4
     * Title: 쿠키의 신체 측정
     * Category: 구현
     *
     * 심장의 위치를 먼저 구한 뒤, 팔 다리 허리의 길이를 구한다.
     * 배열 돌리기
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] map = new String[N];
        int heartX = 0;
        int heartY = 0;
        boolean hasHead = false;
        int leftArm = 0;
        int rightArm = 0;
        int leftLeg = 0;
        int rightLeg = 0;
        int waist = 0;

        // find Heart
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map[i] = str;
            for (int j = 0; j < N; j++) {
                if (!hasHead && str.charAt(j) == '*') {
                    hasHead = true;
                    heartX = j;
                    heartY = i+1;
                    break;
                }
            }
        }

        // find left arm length
        for (int i = heartX-1; i >= 0; i--) {
            if (map[heartY].charAt(i) == '*') leftArm++;
            else break;
        }
        // find right arm length
        for (int i = heartX+1; i < N; i++) {
            if (map[heartY].charAt(i) == '*') rightArm++;
            else break;
        }
        // find waist length
        for (int i = heartY+1; i < N; i++) {
            if (map[i].charAt(heartX) == '*') waist++;
            else break;
        }
        // find left leg length
        for (int i = heartY+waist+1; i < N; i++) {
            if (map[i].charAt(heartX-1) == '*') leftLeg++;
            else break;
        }
        // find right leg length
        for (int i = heartY+waist+1; i < N; i++) {
            if (map[i].charAt(heartX+1) == '*') rightLeg++;
            else break;
        }

        System.out.println((heartY+1)+" "+(heartX+1));
        System.out.println(leftArm+" "+rightArm+" "+waist+" "+leftLeg+" "+rightLeg);
    }
}
