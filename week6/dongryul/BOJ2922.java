package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B2922즐거운단어 {
    static int[] arr = {1,0};    // 1 모음, 2 자음
    static int[] stringArr;	//입력 배열
    static int[] output;
    static ArrayList<Integer> index;
    static boolean isL = false;
    static long ans=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.next();
        index = new ArrayList<>();
        
        stringArr = new int[input.length()];	//입력 배열
        
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(c == 'L') {        // L이 포함되어 있으면
                isL = true;
            }
            if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                stringArr[i] = 1;        //모음
            }else if(c == '_'){
                index.add(i);
            }else {
                stringArr[i] = 0;        //자음
            }
        }// end for
        
        output = new int[index.size()];    //빈칸 갯수만큼
        
        perm(0);
        System.out.println(ans);
    }

    static void perm(int idx) {    // 0과 1 중복 순열
        if(idx == index.size()) {        //빈칸 갯수만큼 뽑으면
            func(output);
            return;
        }
        for(int i=0; i<2; i++) {
            output[idx] = arr[i];
            perm(idx+1);
        }
    }
    static void func(int[] temp) {
    	int jaCnt = 0;	//자음 갯수
    	int moCnt = 0;  // 모음 갯수
        //중복 순열 가지고 문자열에 대입해서 체크한다.
        //대입
        for(int i=0; i<temp.length; i++) {
            int idx = index.get(i);    // 빈칸 인덱스
            stringArr[idx] = temp[i];    // 빈칸에 자음, 모음 넣기
            if(temp[i] == 0) {	//자음 일때
            	jaCnt++;
            }else {		//모음 갯수
            	moCnt++;
            }
        }
        
        // 체크
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<stringArr.length; i++) {
            sb.append(stringArr[i]);
        }
        String str = sb.toString();
        
        


      //조건 체크
        if(str.contains("000") || str.contains("111")) {
            return;
        }

        long count = 1;
        if(isL) {    //원래 L이 포함되어 있었으면
            for(int i=0; i<temp.length; i++) {
                if(temp[i] == 1) {    //모음
                    count*=5;
                }else {
                    count*=21;    // L포함 자음
                }
            }
            ans += count;
        }else {
        	//부분집합 시작
        	selected = new boolean[temp.length];
        	subset(0, jaCnt, moCnt);
        }
    }
    static boolean[] selected;
    static void subset(int idx, int jaCnt, int moCnt) {
    	if(idx == jaCnt) {
    		int cnt = 0;
    		for(int i=0; i<jaCnt; i++) {
    			if(selected[i]) {
    				cnt++;
    			}
    		}
			long result = 1;

    		if(cnt != 0) {
    			//모음갯수만큼 5 곱해
    			for(int i=0; i<moCnt; i++) {
    				result *= 5;
    			}
    			
    			//cnt 만큼 L을 뽑을 거야.
    			for(int i=0; i<jaCnt - cnt; i++) {
    				result *= 20;
    			}
    			ans += result;
    		}
    		
    		return;
    	}
    	selected[idx] = true;
    	subset(idx+1, jaCnt,moCnt);
    	
    	selected[idx] = false;
    	subset(idx+1, jaCnt, moCnt);
    }
}