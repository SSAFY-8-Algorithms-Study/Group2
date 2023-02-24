import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int num = 1;
        int index = 1;
        while(num < input){
            num += index * 6;
            index++;
        }
        System.out.println(index);
    }

}
