class Solution {
    /*
        DFS로 더하고 빼기 탐색하기
    */
    int[] numbers;
    int target;
    int answer;
    
    public void dfs(int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        // 더하기, 빼기
        dfs(index+1, sum+numbers[index]);
        dfs(index+1, sum-numbers[index]);
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);
        return this.answer;
    }
}