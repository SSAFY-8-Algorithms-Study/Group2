import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static String[] word_perm;
    static ArrayList<String> word_list;
    
    public int solution(String word) {
        word_perm = new String[5];
        word_list = new ArrayList<>();
        
        for(int i = 1; i <= 5; i++) {
            permutation(0, i);
        }
        
        Collections.sort(word_list);
        return word_list.indexOf(word) + 1;
    }
    
    // 중복 순열 탐색
    static void permutation(int cnt, int num) {
        if(cnt == num) {
            String str = "";
            
            for(int i = 0; i < num; i++) {
                str += word_perm[i];
            }
            
            word_list.add(str);
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            word_perm[cnt] = alpha[i];
            permutation(cnt + 1, num);
        }
    }
}