package week18.seoyoon;

import java.util.Arrays;

public class PRO_H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int min = Math.min(citations[i], citations.length-i);
            answer = Math.max(min, answer);
        }

        return answer;
    }
}
