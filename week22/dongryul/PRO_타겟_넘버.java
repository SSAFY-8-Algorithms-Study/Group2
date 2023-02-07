package programmers.backtracking;

public class PRO_타겟_넘버 {
	int cnt;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        //총 갯수
        cnt = 0;
        
        //재귀
        dfs(numbers, 0, 0, target);
        
        answer = cnt;
        return answer;
    }
    public void dfs(int[] numbers, int sum, int depth, int target){
        if(depth == numbers.length){
            if(sum == target) cnt++;
            return;
        }
        // 백트래킹
        // +
        dfs(numbers, sum + numbers[depth], depth+1, target);
        
        // -
        dfs(numbers, sum - numbers[depth], depth+1, target);
    }
}
