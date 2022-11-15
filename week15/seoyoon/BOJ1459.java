package week15.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* BOJ1459 : 걷기 */
public class BOJ1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        if (2 * W <= S) {						// 가로+세로 이동이 대각선 이동보다 적거나 같게 걸리는 경우
            System.out.println((X + Y) * W);	// 가로 세로 이동만큼 시간 계산
        }
        else {									// 가로+세로 이동이 대각선 이동보다 오래 걸리는 경우
            if (W < S) {						// 가로 or 세로 이동이 대각선 이동보다 적게 걸린다면
                long maxDiag = (X > Y ? Y : X);	// 대각선으로 이동할 수 있는 최대거리 계산
                long restDist = Math.abs(X - maxDiag) + Math.abs(Y - maxDiag); 	// 남은거리 가로 or 세로 이동
                System.out.println((maxDiag * S) + (restDist * W));
            }
            else {								// 가로+세로, 가로 or 세로 이동이 대각선 이동보다 오래 걸린다면
                long maxDiag = (X > Y ? X : Y);	// 처음부터 끝까지 최대한 대각선으로만 이동
                if ((X % 2 == 0 && Y % 2 == 0) || (X % 2 == 1 && Y % 2 == 1)) {		// X, Y 좌표가 모두 홀수거나 모두 짝수라면
                    System.out.println(maxDiag * S);								// 끝까지 대각선 이동 가능
                }
                else {											// 아니라면
                    System.out.println((maxDiag - 1) * S + W);	// 최대한 대각선 이동 후 한 칸만 가로 or 세로 이동
                }
            }
        }
    }
}
