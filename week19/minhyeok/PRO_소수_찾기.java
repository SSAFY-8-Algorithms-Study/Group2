import java.util.*;

class Solution {
    /*
        1 ~ 숫자의 길이 -> r -> nPr 의 결과를 구한 후 소수를 체크하고 개수를 센다.
    */
    
    // 전역변수 설정 
    HashMap<Integer,Boolean> visitedNumber = new HashMap<Integer,Boolean>();
    int primeCnt = 0;
    boolean[] visited;
    String numbers;
    
    // 소수 체크 메서드 
    public boolean isPrime(int num) {
        for (int i=2; i<= num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(String numbers) {
        
        this.numbers = numbers;
        
        // numbers 길이만큼 순열 돌리기
        for (int i=1; i<=numbers.length(); i++) {
            visited = new boolean[numbers.length()];
            perm(0,i,new StringBuilder());
        }
        
        return primeCnt;
    }
    
    public void perm(int cnt, int r, StringBuilder sb) {
        
        if (cnt == r) {
            int num = Integer.parseInt(sb.toString());
            if(!visitedNumber.getOrDefault(num,false)) { // 순열의 최종 결과 방문 체크 후 소수 체크
                visitedNumber.put(num,true);
                if (num >= 2 && isPrime(num)) primeCnt++;
            }
            return;
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                perm(cnt+1,limit,sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}