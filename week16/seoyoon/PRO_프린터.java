package week16.seoyoon;

import java.util.ArrayList;

public class PRO_프린터 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1};
        System.out.println(solution(arr, 0));
    }

    private static int solution(int[] priorities, int location) {
        int order = 0;   // 몇 번째로 출력되는 문서인지
        ArrayList<Docs> list = new ArrayList<Docs>();
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Docs(priorities[i], i == location ? true : false));	// 문서의 중요도, 내가 요청한 문서인지 여부
        }

        int max = findMax(list);
        while (true) {
            Docs curDoc = list.remove(0);   // 맨 앞의 문서 먼저 뺌

            if (curDoc.priority == max) {   // 맨 앞의 문서의 중요도가 가장 높다면
                ++order;                    // 출력

                if (curDoc.target == true) {    // 해당 문서가 마침 내가 요청했던 문서라면
                    break;                      // while문 종료
                }
                max = findMax(list);        // 가장 중요도가 높았던 문서를 빼냈기 때문에 max값 다시 구하기
            }
            else {                          // 중요도가 높은 문서가 아니라면
                list.add(curDoc);           // list 맨 뒤에 다시 넣어주기
            }
        }
        return order;
    }

    private static int findMax(ArrayList<Docs> list) {		// max값 찾기
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).priority) {
                max = list.get(i).priority;
            }
        }
        return max;
    }

    private static class Docs {
        int priority;       // 문서의 중요도
        boolean target;     // 내가 요청한 문서인지

        public Docs(int priority, boolean target) {
            this.priority = priority;
            this.target = target;
        }
    }
}
