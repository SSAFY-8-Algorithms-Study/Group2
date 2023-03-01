package week25;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B20125_쿠키의신체측정 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] cArr = new char[N][];
        for(int n=0; n<N; n++){
            cArr[n] = br.readLine().toCharArray();
        }
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, 1, -1};
        int[] heart = getHeartLocation(N, cArr);
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        //왼팔 (중앙으로부터)
        for(int m=heart[1] - 1; m>=0; m--){
            if(cArr[heart[0]][m] == '*') leftArm++;
        }

        //오른팔
        for(int m=heart[1] + 1; m<N; m++){
            if(cArr[heart[0]][m] == '*') rightArm++;
        }
        //허리 사이즈 - 마지막 허리 위치도 있어야 한다.
        int[] lastWaist = new int[2];
        for(int n=heart[0] + 1; n<N; n++){
            if(cArr[n][heart[1]] == '*') waist++;
            if(cArr[n][heart[1]] == '_'){   // 마지막 허리 위치
                lastWaist[0] = n-1;
                lastWaist[1] = heart[1];
                break;
            }
        }

        //다리
        for(int n=lastWaist[0] + 1; n<N; n++){
            if(cArr[n][lastWaist[1] - 1] == '*') leftLeg++;
            if(cArr[n][lastWaist[1] + 1] == '*') rightLeg++;
        }
        System.out.println((heart[0]+1) + " " + (heart[1]+1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
    static int[] getHeartLocation(int N, char[][] cArr){
        for(int n=1; n<N-1; n++){
            for(int m=1; m<N-1; m++){
                if(cArr[n][m] == '_') continue;
                // 4방향 모두 * 이면 심장
                if(cArr[n-1][m] == '*' && cArr[n][m-1] == '*' && cArr[n][m+1] == '*' && cArr[n+1][m] == '*'){
                    return new int[]{n,m};
                }
            }
        }
        return new int[]{0,0};
    }
}
