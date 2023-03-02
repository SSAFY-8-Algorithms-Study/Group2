import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4659_비밀번호_발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if(str.equals("end")) break;

            if(!str.contains("a") && !str.contains("e") && !str.contains("i") && !str.contains("o") && !str.contains("u")) {
                sb.append("<" + str + "> " + "is not acceptable.").append('\n');
                continue;
            }

            int cnt = 1;
            int mCnt = 0;
            int sCnt = 0;
            char past = ' ';
            boolean isAcceptable = true;

            for (char chr : str.toCharArray()) {
                if(chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u') {
                    mCnt++;
                    sCnt = 0;
                } else {
                    sCnt++;
                    mCnt = 0;
                }

                if(mCnt == 3 || sCnt == 3) {
                    isAcceptable = false;
                    break;
                }

                if(chr != 'e' && chr != 'o' && chr == past) cnt++;
                else cnt = 1;

                past = chr;

                if(cnt == 2) {
                    isAcceptable = false;
                    break;
                }
            }

            if(isAcceptable) sb.append("<" + str + "> " + "is acceptable.").append('\n');
            else sb.append("<" + str + "> " + "is not acceptable.").append('\n');
        }

        System.out.println(sb);
    }
}