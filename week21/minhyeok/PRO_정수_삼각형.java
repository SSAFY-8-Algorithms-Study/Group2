import java.util.*;

class Solution {
    /*
        (i,j)의 수는 부모의 수 [(i-1,j-1), (i-1,j)] 중 최댓값을 누적합한다.
            triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j])
        삼각형의 마지막 행 중 최댓값이 경로 중 거쳐간 숫자의 합이 가장 큰 경우이다.
    */
    public int solution(int[][] triangle) {
        int answer = 0;
        int tDepth = triangle.length;
        
        for (int i=1; i<tDepth; i++) {
            for (int j=0; j<i+1; j++) {
                if (j==0) { // 가장 왼쪽의 숫자 예외 처리 
                    triangle[i][j] += triangle[i-1][j];
                } else if (j==i) { // 가장 오른쪽의 숫자 예외 처리
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        
        for (int a : triangle[tDepth-1]) {
            if (a > answer) {
                answer = a;
            }
        }
        return answer;
    }
}