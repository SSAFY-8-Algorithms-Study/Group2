import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
      // 이게 왜 되지??? 일단 통과
        if (n > m) {
            System.out.println(n+m+m/10);
        } else {
            System.out.println(n+m+n/10);
        }
    }
}
