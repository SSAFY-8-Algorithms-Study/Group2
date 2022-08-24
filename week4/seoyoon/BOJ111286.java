package week4.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* BOJ11286 - 절댓값 힙 */
public class BOJ111286 {

    // 1. 배열에 정수 x (x ≠ 0)를 넣는다.
    // 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.

    static class IntNum implements Comparable<IntNum> {
        int num;    // 입력받은 정수 x의 절댓값
        int sign;   // 정수 x의 부호

        public IntNum(int num, int sign) {
            this.num = num;
            this.sign = sign;
        }

        @Override
        public int compareTo(IntNum o) {
            if (this.num == o.num) {
                return this.sign - o.sign;
            }
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<IntNum> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {       // 0이 입력되었다면
                if (queue.isEmpty()) System.out.println(0); // 배열이 비어있는 경우 0 출력
                else {
                    if (queue.peek().sign == -1) {          // queue.peek() :: 절댓값이 가장 작은 값,  queue.peek().sign :: 그 절  값의 부호
                        System.out.println(queue.poll().num * -1);    // 절댓값이 가장 작은 값이 여러개(양수, 음수)일 때는 가장 작은 수 출력하고 (= 음수 출력), 배열에서 제거
                    } else System.out.println(queue.poll().num);
                }
            } else {
                int absX = Math.abs(x);
                int signX = (x > 0) ? 1 : -1;
                queue.offer(new IntNum(absX, signX));
            }
        }
    }
}
