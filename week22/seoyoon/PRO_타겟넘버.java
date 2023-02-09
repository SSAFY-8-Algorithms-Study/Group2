package week22.seoyoon;

public class PRO_타겟넘버 {

    private static int answer = 0 ;

    public static void main(String[] args) {
        int[] nums = {4,1,2,1};
        int targetNum = 4;

        System.out.println(solution(nums, targetNum));
    }

    public static int solution(int[] numbers, int target) {
        findTarget(numbers, target, 0, 0);
        return answer;
    }

    public static void findTarget(int[] numbers, int target, int curSum, int idx) {
        if (idx == numbers.length) {
            if (curSum == target) {
                answer++;
            }
            return;
        }

        findTarget(numbers, target, curSum + numbers[idx], idx + 1);
        findTarget(numbers, target, curSum - numbers[idx], idx + 1);
    }
}
