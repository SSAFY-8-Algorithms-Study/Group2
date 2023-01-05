class Solution {
    public int solution(String word) {
        
        int answer = word.length(); // 길이
        
        String str = "AEIOU";
        int[] x = {781, 156, 31, 6, 1}; // 각 자릿수 마다의 증가폭
        
        for (int i=0; i<word.length(); i++) {
            int idx = str.indexOf(word.charAt(i)); // AEIOU중에 어떤거니
            answer += x[i] * idx; // 제낀 양(증가폭) * AEIOU 중에 어느것(몇글자 제칠거니)
        }
        
        return answer;
    }
}
