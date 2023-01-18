package temp_pro.week20;

import java.io.IOException;

public class pro_큰수만들기 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        // 출력
        pro_큰수만들기 S = new pro_큰수만들기();
        System.out.println(S.solution("1924", 2)); // "94"
        System.out.println(S.solution("1231234", 3)); // "3234"
        System.out.println(S.solution("41772993429952841", 10)); // "775841"

    }

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        // prefix 길이
        int len = number.length() - k;

        // prefix String
        String prefix = number.substring(0, len);

        // 맨 앞값 fix
        int maxIdx = -1, max = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int val = prefix.charAt(i) - '0';
            if (val > max) {
                max = val;
                maxIdx = i;
            }
        }

//        System.out.println("maxIdx:" + maxIdx + ", max:" + max); // 디버깅

        ////////////////////////////////////////////////////////////////////////////////

        // 첫자리 이후로 쭉 이어진 String
        String suffix = number.substring(maxIdx);

        // sb에 append
        sb.append(suffix);

        // 지워야되는 횟수
        int del = k - maxIdx;

        // 지워야할 갯수만큼 선별해서 deleteCharAt
        for (int i = 0; i < sb.length()-1; i++) {
            if(sb.charAt(i)<sb.charAt(i+1)) {
                sb.deleteCharAt(i);
//                sb.setCharAt(i, ' '); // 밑의 for문과 연동
                del--;
            }
            if (del <= 0) break;
        }

        // 실패 탓에 따로 빼본 코드
//        for (int i=sb.length()-1; i>=0; i--) {
//            if (sb.charAt(i) == ' ') {
//                sb.deleteCharAt(i);
//            }
//        }

        return sb.toString();
    }
}
