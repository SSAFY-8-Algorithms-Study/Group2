class Solution {
    
    /* 
        DFS로 모든 경우의 수 탐색하기
        1. A ~ U까지 모든 문자를 대입해보며 찾는 단어와 맞는지 확인한다.
    */
    
    char[] alphabet = {'A','E','I','O','U'};
    int wordCnt = 0;
    boolean isFin;
    
    // DFS로 사전순으로 단어 조합하기
    public void dfs(int cnt, StringBuilder sb, String word) {

        if (sb.toString().equals(word)) {
            isFin = true;
            return;
        }
        
        if (cnt == 5) return;
            
        
        for (int i=0; i<5; i++) {
            sb.append(alphabet[i]);
            wordCnt++; // 사전순 순서
            dfs(cnt+1,sb,word);
            sb.deleteCharAt(sb.length()-1);
            
            if (isFin) return;
        }
    }
    
    public int solution(String word) {
        
        dfs(0,new StringBuilder(), word);
        
        return wordCnt++;
    }
}