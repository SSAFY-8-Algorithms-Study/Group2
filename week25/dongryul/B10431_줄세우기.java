package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B10431_줄세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        int P = Integer.parseInt(br.readLine());

        for(int t=1; t<=P; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            LinkedList<Integer> list = new LinkedList<>();
            int move_cnt = 0;
            for(int i=0; i<20; i++){
                int tall = Integer.parseInt(st.nextToken());

                    int insert_index = list.size();
                    if(list.size() == 0){
                        list.add(0,tall);
                        continue;
                    }
                    while(true){
                        if(list.get(insert_index-1) > tall) {  //내가 더 작아..
                            //앞으로 갈게..
                            insert_index--;
                            if(insert_index == 0){
                                move_cnt += (list.size() - insert_index);
                                list.add(insert_index,tall);
                                break;
                            }
                        }else{
                            move_cnt += (list.size() - insert_index);
                            list.add(insert_index,tall);

                            break;
                        }

                    }//end while
            }// end for i
            sb.append(T + " " + move_cnt + "\n");
        }// end for p;
        System.out.println(sb.toString());
    }
}
