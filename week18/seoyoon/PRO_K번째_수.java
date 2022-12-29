package week18.seoyoon;

import java.util.Arrays;

public class PRO_K번째_수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int k = 0;

        int[] tempArr;
        for (int i = 0; i < commands.length; i++) {
            tempArr = Arrays.copyOfRange(array, commands[i][0] - 1,  commands[i][1]);
            Arrays.sort(tempArr);
            answer[k++] = tempArr[commands[i][2] - 1];
        }

        return answer;
    }
}
