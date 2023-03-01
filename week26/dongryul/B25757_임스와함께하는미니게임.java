package week25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        Set<String> set = new HashSet<>();
        for(int n=0; n<N; n++){
            set.add(br.readLine());
        }
        int answer = 0;
        if(game.equals("Y")){
            answer = set.size() / 1;
        }else if(game.equals("F")){
            answer = set.size() / 2;
        }else{
            answer = set.size() / 3;
        }
        System.out.println(answer);
    }
}