class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 2];
        
        for(int num : lost) { // 체육복을 도단당한 학생
            students[num] = -1;
        }
        
        for(int num : reserve) { // 여벌 체육복이 있는 학생
            students[num] += 1;
        }
        
        for(int i = 1; i <= n; i++) {
            if(students[i] == 0) answer += 1; // 체육복 1개 있는 학생 +1
            
            if(students[i] == 1) { // 체육복 2개 있는 학생인 경우
                answer += 1;
                
                if(students[i - 1] == -1) { // 앞번호 학생이 체육복이 없는 경우
                    students[i - 1] += 1;
                    students[i] -= 1;
                    answer += 1;
                    continue;
                }
                
                if(students[i + 1] == -1) { // 뒷번호 학생이 체육복이 없는 경우
                    students[i + 1] += 1;
                    students[i] -= 1;
                }
            }
        }
        
        return answer;
    }
}