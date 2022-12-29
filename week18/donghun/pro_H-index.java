package temp_pro.week18;

import java.io.IOException;
import java.util.Arrays;

public class pro_Hindex {
    public static void main(String[] args) throws NumberFormatException, IOException {

        // TC
        int[] citations = {3, 0, 6, 1, 5}; // return 3

        // 출력
        pro_Hindex S = new pro_Hindex();
        System.out.println(S.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;

        // 1. 오름차순 정렬 (앞의 원소일수록 올수록 h가 높다)
        Arrays.sort(citations);

        // 2. 논문 인용 횟수=배열[i] >= 해당 논문보다 인용횟수가 크거나같은 편수=h -> 만족하는 가장 큰 h를 찾는다
        for (int i = 0; i < citations.length; i++) {

            // i일때 가장 큰 h값 = 이 원소보다 뒤의 것들의 갯수
            int h = citations.length - i;

            if (citations[i] >= h) { // 조건을 만족하면
                answer = h; // 갱신
                break; // 이 뒤는 볼 필요가 없다. 1.의 이유처럼 h가 갈수록 무조건 작아지기 때문
            }
        }

        return answer;
    }
}
