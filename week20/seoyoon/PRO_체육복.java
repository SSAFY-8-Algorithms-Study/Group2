package week20.seoyoon;

import java.util.Arrays;

public class PRO_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;   // 전체 학생 중 체육복이 없는 학생 수 빼주기
        int used = Integer.MIN_VALUE;   // 체육복을 빌려줘서 더이상 고려하지 않아도 될 경우를 표시하기 위한 변수

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == lost[i]) {   // 여벌의 체육복을 가져온 학생이 체육복을 도난당한 경우 -> 자기 체육복 자기가 써야함
                    lost[i] = used;     // 도난당한 학생 목록에서 제외
                    reserve[j] = used;  // 빌려줄 수 있는 학생 목록에서 제외
                    answer++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] - 1 == lost[i] || lost[i] == reserve[j] + 1) {   // 도난당한 학생 기준 앞뒤 친구가 체육복을 빌려줄 수 있는 경우
                    reserve[j] = used;
                    answer++;
                    break;
                }
            }
        }

        // System.out.println(answer);
        return answer;
    }
}