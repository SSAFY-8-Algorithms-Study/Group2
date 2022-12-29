package week18.seoyoon;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PRO_가장_큰_수 {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers).mapToObj(Integer::toString).sorted((o1, o2) -> (o2+o1).compareTo(o1+o2)).collect(Collectors.joining());

        return answer;
    }
}
