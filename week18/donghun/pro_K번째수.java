package temp_pro.week18;

import java.io.IOException;
import java.util.Arrays;

public class pro_K번째수 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        // TC
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}; // return [5, 6, 3]

        // 출력
        pro_K번째수 S = new pro_K번째수();
        System.out.println(Arrays.toString(S.solution(array, commands)));

    }

    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];

        for (int loop = 0; loop < len; loop++) {

            // 1. 입력받은 배열을 index i~j까지 끊어 새로운 배열을 만든다
            int i = commands[loop][0];
            int j = commands[loop][1];
            int k = commands[loop][2];

            int[] copy = Arrays.copyOfRange(array, i-1, j);

            // 2. 정렬을 한다
            Arrays.sort(copy);

//            // 디버깅
//            System.out.println(Arrays.toString(copy));

            // 3. k번째의 원소를 구한다
            int ans = copy[k-1];

            // 4. array를 토대로 commands를 수행한 값을 answer 배열의 원소에 담는다
            answer[loop] = ans;
        }


        return answer;
    }
}
