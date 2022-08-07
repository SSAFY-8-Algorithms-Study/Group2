package donghun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2304_창고다각형 {
    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int maxIdx, lSum, rSum, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<XY> lxy = new ArrayList<XY>();
        ArrayList<XY> rxy = new ArrayList<XY>();
        ArrayList<XY> All = new ArrayList<XY>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            All.add(new XY(x1, y1));
        }

        All.sort((o1, o2) -> o1.x - o2.x);

        int max = 0, count = 0;
        for (int i = 0; i < All.size(); i++) {
            if (max < All.get(i).y) {
                max = All.get(i).y;
                maxIdx = i;
            } else if (max == All.get(i).y) {
                count++;
            }
        }

//        for (int i = 0; i < All.size(); i++) {
//            System.out.println("(" + All.get(i).x + "," + All.get(i).y + ")");
//        }
//        System.out.println(maxIdx);

        for (int i=0; i<maxIdx; i++) {
            if (All.get(i).y > All.get(i+1).y) {
                All.remove(i+1);
            }
        }

        for (int i=All.size()-1; i> maxIdx; i--) {
            if (All.get(i).y > All.get(i-1).y) {
                All.remove(i-1);
            }
        }

        // max 다시
        max = 0;
        for (int i = 0; i < All.size(); i++) {
            if (max < All.get(i).y) {
                max = All.get(i).y;
                maxIdx = i;
            }
        }

        for (int i=0; i<=maxIdx; i++) {
            lxy.add(All.get(i));
        }

        for (int i=All.size()-1; i>=maxIdx; i--) {
            rxy.add(All.get(i));
        }


//        for (int i = 0; i < lxy.size(); i++) {
//            System.out.println("(" + lxy.get(i).x + "," + lxy.get(i).y + ")");
//        }
//        System.out.println("-------");
//        for (int i = 0; i < rxy.size(); i++) {
//            System.out.println("(" + rxy.get(i).x + "," + rxy.get(i).y + ")");
//        }

        for (int i = 0; i < lxy.size()-1; i++) {
            lSum += (lxy.get(i+1).x - lxy.get(i).x) * lxy.get(i).y;
        }

        for (int i = 0; i < rxy.size()-1; i++) {
            rSum += (rxy.get(i).x - rxy.get(i+1).x) * rxy.get(i).y;
        }

//        System.out.println("------");
        System.out.println(lSum+rSum+(All.get(maxIdx).y*(count+1)));
    }
}