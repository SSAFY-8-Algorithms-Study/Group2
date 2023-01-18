import java.util.*;

class Solution {
    
    /* 
        기본 1, 잃어버림 -=1, 여벌 +=1
        체육복이 없는 학생은 왼쪽 학생부터 빌린다.
    */
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] studentArr = new int[n+1];
        Arrays.fill(studentArr,1);
        
        studentArr[0] = 0;
        
        for (int r : reserve) {
            studentArr[r] += 1;
        }
        
        for (int l : lost) {
            studentArr[l] -= 1;
        }
        
        for (int i=1; i<n+1; i++) {
            if (studentArr[i] >= 1) continue;
            int[] side = {-1,1};
            for (int s : side) {
                int dir = i+s;
                if (dir <=0 || dir >= n+1) continue;
                if (studentArr[dir] == 2) {
                    studentArr[dir] -= 1;
                    studentArr[i] += 1;
                    break;
                }
            }
        }
        
        for (int i=1; i<n+1; i++) {
            if (studentArr[i] >= 1) answer++;
        }
        return answer;
    }
}