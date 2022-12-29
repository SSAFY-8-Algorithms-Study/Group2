package temp_pro.week18;

import java.io.IOException;
import java.util.Arrays;

public class pro_가장큰수 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        // TC
        int[] numbers_1 = {6, 10, 2}; // return "6210"
        int[] numbers_2 = {3, 30, 34, 5, 9}; // return "9534330"

        // 출력
        pro_가장큰수 S = new pro_가장큰수();
        System.out.println(S.solution(numbers_1));
        System.out.println(S.solution(numbers_2));
    }

    public String solution(int[] numbers) {

        // 1. int[] -> String[] 변환
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2. 내림차순 - 두개를 합쳐서 비교. 자릿수가 다른 경우를 처리하기 위함. ex) 3, 30 -> 330, 303
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 3. 시간 절약을 위한 StringBuilder
        StringBuilder answer = new StringBuilder();

        // 4. 순서대로 이어붙임
        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        // 5. 맨 앞이 0이면 그냥 0
        if (answer.charAt(0) == '0') {
            return "0";
        }

        // 6. StringBuilder -> String 변환하여 return
        return answer.toString();
    }

}
