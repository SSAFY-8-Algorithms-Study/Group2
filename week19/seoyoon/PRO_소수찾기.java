package week19.seoyoon;

import java.util.HashSet;

public class PRO_소수찾기 {
    static boolean[] visited;
    static HashSet<Integer> set;
    static int depth = 0;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        findPrimes(numbers, 0, "");
        answer = set.size();
        return answer;

    }

    public void findPrimes(String numbers, int depth, String cur) {
        if (depth == numbers.length()) return;

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i] == true) {
                continue;
            }
            else {
                String number = cur + numbers.charAt(i);

                if (isPrime(Integer.parseInt(number))) {
                    set.add(Integer.parseInt(number));
                }
                visited[i] = true;
                findPrimes(numbers, depth+1, number);
                visited[i] = false;
            }

        }
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num > 1) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
