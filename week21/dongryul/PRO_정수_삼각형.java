package programmers.dp;

public class PRO_정수_삼각형 {
	public int solution(int[][] triangle) {
        int answer = 0;
        
        int length = triangle.length; // i
        
        int[][] D = new int[length][length];
        
        D[0][0] = triangle[0][0];
        
        for(int i=0; i<length-1; i++){
            int width = triangle[i].length;
            for(int j=0; j<width; j++){
                //left
                if(D[i+1][j] < D[i][j] + triangle[i+1][j]){
                    D[i+1][j] = D[i][j] + triangle[i+1][j];
                }
                //right
                if(D[i+1][j+1] < D[i][j] + triangle[i+1][j+1]){
                    D[i+1][j+1] = D[i][j] + triangle[i+1][j+1];
                }
            }
        }//end for
        int max = 0;
        for(int n : D[length-1]){
            max = Math.max(max, n);
        }
        answer = max;
        return answer;
    }
}
