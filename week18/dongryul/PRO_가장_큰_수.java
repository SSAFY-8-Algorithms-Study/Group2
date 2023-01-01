package programmers.sort;

import java.util.PriorityQueue;

public class PRO_가장_큰_수 {
	public static void main(String[] args) {
		solution(new int[] {3, 0, 4, 5, 9});
	}
	public static String solution(int[] numbers) {
        String answer = "";

        PriorityQueue<char[]> pq = new PriorityQueue<>((n1, n2)->{
            int c1_length = n1.length;
            int c2_length = n2.length;
            int min = 0;
            if(c1_length >= c2_length){
                min = c2_length;
            }else{
                min = c1_length;
            }
            int index=0;
            //앞자리 부터 검사
            for(int i=0; i<min; i++){
                if(n1[i] > n2[i]){
                	System.out.println(n1[i] + "," + n2[i]);
                    return n1[i] - n2[i];
                }else if(n1[i] < n2[i]){
                    return n2[i] - n1[i];
                }
                index++;
            }
            System.out.println("asdf");
            //Return 하지 못하였다면 그 뒤에 자리 확인
            if(c1_length > c2_length){
                return  n1[index] - n2[index - 1];
            }else{
                return  n2[index] - n1[index - 1];
            }
        });
        for(int number : numbers){
            char[] charArr = (number + "").toCharArray();
            pq.add(charArr);
        }
        while(!pq.isEmpty()) {
        	char[] arr = pq.poll();
        	System.out.println(new StringBuilder().append(arr).toString());
        }
        return answer;
    }
}
