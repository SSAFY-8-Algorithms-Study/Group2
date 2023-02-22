import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        boolean[] set = new boolean[21];
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<K; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            if(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(oper.equals("add")){
                    set[num] = true;
                }else if(oper.equals("remove")){
                    set[num] = false;
                }else if(oper.equals("check")){
                    if(set[num]) sb.append("1\n");
                    else sb.append("0\n");

                }else if(oper.equals("toggle")){
                    if(set[num]) set[num] = false;
                    else set[num] = true;
                }
            }
            if(oper.equals("all")){
                for(int s=1; s<=20; s++){
                    set[s] = true;
                }
            }
            else if(oper.equals("empty")){
                for(int s=1; s<=20; s++){
                    set[s] = false;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
