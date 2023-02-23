package group.week_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292_벌집 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 1; // 시작 깊이
        int roomNum = 1; // 시작 방 번호
        int addNum = 6; // 계차마다 6씩 더 증가

        while (n > roomNum) {
            roomNum += addNum; // 방 계층 이동
            addNum += 6; // 보정값 추가
            result++; // 계층 깊이 ++
        }

        System.out.println(result);
    }
}
