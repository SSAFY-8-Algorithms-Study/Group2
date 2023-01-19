import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
/*
 * 1. 숫자 접붙이기 5, 55, ...
 * 2. 사칙연산으로 만들어진 수를 저장해놓고 비교에 사용
 * 3. 최소 사용 횟수 갱신 반복
 */
class PROG_DP_level3_N으로표현 {
    static int MAX = 32_000;
    
    public static void main(String[] args) {
		System.out.println(solution(5,12)); // expect 4
//		System.out.println(solution(2,11)); // expect 3
	}
    
    static int solution(int N, int number) {
        PriorityQueue<Info> pq = new PriorityQueue<>((a,b)-> a.cnt - b.cnt); // 사용 횟수 최솟값 우선
        int[] visit = new int[MAX + 1]; // 방문을 사용 횟수로 기록 1 ~ 32,000
        Arrays.fill(visit, Integer.MAX_VALUE);

        ArrayDeque<Info> numList = new ArrayDeque<>(); // 모든 num 보관 리스트

        for (int i = 1; i <= 7; i++) {
            int num = numConcat(N,i); // 5, 55, 555, ...

            pq.add(new Info(num, i));
            if(num <= MAX) visit[num] = i; // 방문 기록 55,555는 기록할 필요 없음

            numList.add(new Info(num,i));
        }

        while(!pq.isEmpty()) {
            Info el = pq.poll();

            if(el.num == number && el.cnt < visit[number])
            	visit[number] = el.cnt; // 사용횟수 최소 기록

            ArrayDeque<Info> numListTemp = numList.clone();

            for (Info B : numList) {
                for (int op = 0; op < 4; op++) { // 사칙연산
                    if(8 < el.cnt + B.cnt) continue;

                    int res = Math.abs(calc(el.num, B.num, op)); // calc 메서드 호출, 절대값 해줘야 양방향 계산
                    if(1 <= res && res <= MAX && el.cnt+B.cnt < visit[res]) { // 최소 사용 횟수 갱신
                        visit[res] = el.cnt+B.cnt;
                        numListTemp.add(new Info(res, el.cnt + B.cnt)); // 새롭게 만들어진 수 추가
                        pq.add(new Info(res, el.cnt + B.cnt));
                    }
                }
            }
            numList = numListTemp;
        }
        if(8 < visit[number]) return -1; // 최소값이 8보다 크면 -1, 만들어질 수 있음
        return visit[number] == 0 ? -1 : visit[number];
    }

    static int numConcat(int num, int cnt) { // 숫자 접붙이기 메서드, 5, 55, ...
        String str = String.valueOf(num);
        while(--cnt > 0) {
            str += String.valueOf(num);
        }
        return Integer.parseInt(str);
    }

    static int calc(int e, int num, int op) { // 사칙연산 수행 메서드
        switch(op) {
            case 0:
                return e+num;
            case 1:
                return e-num;
            case 2:
                return e*num;
            case 3:
                return e/num;
        }
        return -1;
    }

    static class Info {
        int num, cnt; // 숫자, N 사용 횟수
        Info(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}