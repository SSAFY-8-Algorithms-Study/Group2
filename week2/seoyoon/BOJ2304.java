package week2.seoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int highest = 0, highestIdx = 0;
        int area = 0;

        // 입력 받기
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            map.put(index, high);
        }

        // 기둥의 index 기준으로 정렬
        List<Integer> indexSet = new ArrayList<>(map.keySet());
        Collections.sort(indexSet);

        // 기준이 되는 가장 높은 기둥 구하기
        for (int idx : indexSet) {
            if (map.get(idx) > highest) {
                highest = map.get(idx);
                highestIdx = idx;
            }
        }

        // 탐색 방향 : 0 --> highest
        int peak = map.get(indexSet.get(0));
        int peakIdx = indexSet.get(0);
        for (int idx : indexSet) {
            if (map.get(idx) > peak) {
                area += (idx - peakIdx) * peak;

                peak = map.get(idx);
                peakIdx = idx;
            }

            if (idx == highestIdx) {
                area += highest;
                break;
            }
        }

        // 탐색 방향 : highest <-- N-1
        peak = map.get(indexSet.get(N - 1));
        peakIdx = indexSet.get(N - 1);
        boolean isSum = false;

        for (int i = N - 1; i >= indexSet.indexOf(highestIdx); i--) {
            if (map.get(indexSet.get(i)) > peak) {
                area += (peakIdx - indexSet.get(i)) * peak;
                isSum = true;

                peak = map.get(indexSet.get(i));
                peakIdx = indexSet.get(i);
            }
            else {
                isSum = false;
            }
        }
        if (isSum == false) {
            area += (peakIdx - indexSet.get(indexSet.indexOf(highestIdx))) * peak;
        }
        System.out.println(area);
    }
}
