package week25.minhyeok;

import javax.management.modelmbean.ModelMBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ8979 {

    /**
     * Tier: Silver 5
     * Title: 올림픽
     * Category: 구현, 정렬
     *
     * 금, 은, 동 기준으로 나라를 정렬하고 등수를 센다.
     *
     */

    static class MedalInfo {
        int country;
        int gold;
        int silver;
        int bronze;

        public MedalInfo(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<MedalInfo> info = new ArrayList<MedalInfo>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            MedalInfo medalInfo = new MedalInfo(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            info.add(medalInfo);
        }

        Collections.sort(info, new Comparator<MedalInfo>() {
            @Override
            public int compare(MedalInfo o1, MedalInfo o2) {
                if (o1.gold == o2.gold) {
                    if (o1.silver == o2.silver) {
                        return o2.bronze - o1.bronze;
                    }
                    return o2.silver-o1.silver;
                }
                return o2.gold-o1.gold;
            }
        });

        int cnt = 0;
        int rank = 0;
        MedalInfo prevMedalInfo = info.get(0);
        for (MedalInfo medalInfo : info) {
            if (medalInfo.gold == prevMedalInfo.gold && medalInfo.silver == prevMedalInfo.silver && medalInfo.bronze == prevMedalInfo.bronze) {
                cnt++;
            } else {
                rank += cnt;
                cnt = 1;
                prevMedalInfo = medalInfo;
            }
            if (medalInfo.country == K) {
                System.out.println(rank+1);
                break;
            }
        }
    }
}
