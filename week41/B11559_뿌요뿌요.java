package week43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 시간 : 53m 00s
 * 유형 : 구현 문제
 * 특징 : 중력, DFS
 * 쓸데없는데 디버깅하느라 시간을 씀 ㅠㅠ 복붙 금지!!
 */
public class B11559_뿌요뿌요{
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][];
        for(int i=0; i<12; i++){
            map[i] = br.readLine().toCharArray();
        }
        int answer = 0;
        //연쇄 검사
        while(true){
            //중력 발동
            gyroDrop();

            // 연쇄 확인
            ArrayList<int[]> list = getChainInfo();
            if(list.size() == 0) break;

            for(int[] start : list) {
                char color = map[start[0]][start[1]];

                puyo(color, start[0], start[1]);
            }
            answer++;
        }
        System.out.println(answer);
    }
    static int colorCnt;
    static boolean[][] visited;
    static ArrayList<int[]> getChainInfo(){
        ArrayList<int[]> list = new ArrayList<>();
        visited = new boolean[12][6];
        for(int i=11; i>=0; i--){
            for(int j=0; j<6; j++){
                if(map[i][j] == '.' || visited[i][j]) continue;
                colorCnt = 1;
                visited[i][j] = true;
                dfs(map[i][j], i, j);

                if(colorCnt >= 4){    //4개 이상
                    list.add(new int[]{i, j});    //시작 위치 저장
                }
            }
        }

        return list;
    }
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static void dfs(char color, int nowi, int nowj){

        for(int d=0; d<4; d++){
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti < 0 || nexti >= 12 || nextj < 0 || nextj >= 6) continue;
            if(map[nexti][nextj] != color) continue;    //같은 색
            if(visited[nexti][nextj]) continue;    // 이미 카운트

            visited[nexti][nextj] = true;
            colorCnt++;

            dfs(color, nexti, nextj);
        }
    }
    static void puyo(char color, int nowi, int nowj){
        map[nowi][nowj] = '.';
        for(int d=0; d<4; d++){
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti < 0 || nexti >= 12 || nextj < 0 || nextj >= 6) continue;
            if(map[nexti][nextj] != color) continue;    //같은 색

            puyo(color, nexti, nextj);
        }
    }
    static void gyroDrop(){
        for(int j=0; j<6; j++){
            int zeroCnt = 0;
            for(int i=11; i>=0; i--){
                if(map[i][j] == '.') zeroCnt++;
                else{
                    if(zeroCnt == 0) continue;
                    map[i + zeroCnt][j] = map[i][j];
                    map[i][j] = '.';
                }
            }
        }
    }
    static void print(){
        System.out.println("--------------------");
        for(int i=0; i<12; i++){
            for(int j=0; j<6; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}