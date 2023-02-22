class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        check(0, target, 0, numbers);
        
        return answer;
    }
    
    static void check(int sum, int target, int depth, int[] numbers) {
        if(depth == numbers.length) {
            if(sum == target) answer++;
            
            return;
        }
        
        check(sum + numbers[depth], target, depth + 1, numbers);
        check(sum - numbers[depth], target, depth + 1, numbers);
    }
}