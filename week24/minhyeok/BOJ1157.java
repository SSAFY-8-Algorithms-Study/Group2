package week24.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1157 {

    /**
     * Tier: BRONZE 1
     * Title: 단어 공부
     * Category: 구현, 문자열
     *
     * 각 알파벳의 개수를 아스키 코드를 이용해 카운트한다.
     * 가장 많이 나온 알파벳의 개수가 두 개 이상이면 '?'를 출력하고
     * 그게 아니면 해당 알파벳을 대문자로 출력한다.
     */

    static class  WordInfo {
        char c;
        int cnt;

        public WordInfo(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] count = new int[26];
        int size = word.length();
        for (int i=0; i<size; i++) {
            int wIndex;
            // 소문자 대문자를 구별하여 0~25 사이의 인덱스로 만들고 개수를 센다.
            if ( (int) (word.charAt(i) - 'a') < 0) {
                wIndex = (int) (word.charAt(i) - 'A');
            } else {
                wIndex = (int) (word.charAt(i) - 'a');
            }
            count[wIndex]++;
        }

        // 알파벳을 자주 나온 순서로 정렬한다.
        PriorityQueue<WordInfo> pq = new PriorityQueue<WordInfo>((o1, o2) -> o2.cnt-o1.cnt);
        for (int i=0; i<count.length; i++) {
            if (count[i] > 0) {
                WordInfo wordInfo = new WordInfo((char) (i+'A'), count[i]);
                pq.add(wordInfo);
            }
        }

        // 가장 많이 나온 알파벳이 두 개 이상인지 아닌지 확인하고 정답을 출력한다.
        WordInfo wordInfo = pq.poll();
        char mostCommonWord = wordInfo.c;
        int mostCommonWordCnt= wordInfo.cnt;
        if (!pq.isEmpty() && pq.peek().cnt == mostCommonWordCnt) {
            System.out.println('?');
        } else {
            System.out.println(mostCommonWord);
        }
    }
}
