package week25.minhyeok;

import javax.xml.xpath.XPathExpressionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ7588 {

    /**
     * Tier: Silver 5
     * Title: 덩치
     * Category: 구현, 브루트포스
     *
     * 이중 for문 돌면서 순위 탐색하기
     * O(n2) 보다 빠르게 풀 수는 없을까
     *
     */

    static class Person {
        int w;
        int h;

        public Person(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Person> people = new ArrayList<Person>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            people.add(new Person(w,h));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Person curPerson = people.get(i);
            int w = curPerson.w;
            int h = curPerson.h;
            int rank = 0;
            for (int j = 0; j < N; j++) {
                if (i==j) continue;
                Person person = people.get(j);
                if (person.w - w > 0 && person.h - h > 0) {
                    rank++;
                }
            }
            sb.append(rank+1);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
