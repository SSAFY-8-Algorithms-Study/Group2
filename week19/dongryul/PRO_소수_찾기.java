package programmers.bruteforce;

import java.util.HashSet;
import java.util.Set;

public class PRO_소수_찾기 {
	int total;
    char[] charArr;
    int[] arr;
    int[] output;
    
    boolean[] selected;
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // charArr로 변환 - 한 글자 한 글자
        charArr = numbers.toCharArray();
        arr = new int[charArr.length];
        
        for(int i=0; i<charArr.length; i++){
            arr[i] = charArr[i] - '0';
        }
        // 1~n개를 뽑았을 때
        for(int i=1; i<=charArr.length; i++){
            output = new int[i];
            selected = new boolean[charArr.length];
            perm(0, i);
        }
        //다 돌리고 set에서 하나씩 꺼내면서 확인
        for(int num : set){
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    public boolean isPrime(int num){
        if(num == 0 || num == 1){   // not prime
            return false;
        }
        if(num == 2 || num == 3){   // 2 or 3 is prime
            return true;
        }
        
        for(int i=2; i<=num/2; i++){
            if(num % i == 0){   // 절반 정도 중에 나누어 떨어지면 not prime
                return false;
            }
        }
        return true;
    }
    public void perm(int cnt, int max){
        if(cnt == max){ // n개 뽑았을 때
            StringBuilder sb = new StringBuilder();
            
            for(int n : output){
                sb.append(n);
            }
            // 만든 문자열을 숫자로 변환하여 set에 저장
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        for(int i=0; i<charArr.length; i++){
            if(!selected[i]){
                selected[i] = true;
                output[cnt] = arr[i];
                perm(cnt+1, max);
                selected[i] = false;
            }
        }
    }
}
