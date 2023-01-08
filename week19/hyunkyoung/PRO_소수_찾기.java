import java.util.ArrayList;

class Solution {
    static int numbers_cnt;
    static String[] numbers_arr;
    static String[] numbers_perm;
    static boolean[] numbers_visit;
    static ArrayList<Integer> list;
    
    public int solution(String numbers) {
        numbers_cnt = numbers.length();
        numbers_arr = numbers.split("");
        numbers_perm = new String[numbers_cnt];
        list = new ArrayList<>();
        
        for(int i = 1; i <= numbers_cnt; i++) {
            numbers_visit = new boolean[numbers_cnt];
            permutation(0, i);
        }
        
        return list.size();
    }
    
    static void permutation(int idx, int cnt) {
        if(idx == cnt) {
            String str = "";
            
            for(int i = 0; i < cnt; i++) {
                str += numbers_perm[i];
            }
            
            if(check(Integer.parseInt(str))) {
                if(!list.contains(Integer.parseInt(str))) {
                    list.add(Integer.parseInt(str));
                }
            }
            
            return;
        }
        
        for(int i = 0; i < numbers_cnt; i++) {
            if(!numbers_visit[i]) {
                numbers_visit[i] = true;
                numbers_perm[idx] = numbers_arr[i];
                permutation(idx + 1, cnt);
                numbers_visit[i] = false;
            }
        }       
    }
    
    // 소수인지 확인하는 함수
    static boolean check(int num) {
        if(num == 0 || num == 1) return false;
        if(num == 2 || num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}