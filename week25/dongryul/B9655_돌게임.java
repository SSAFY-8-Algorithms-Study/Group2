import java.util.Scanner;                                                                                                                       
                                                                                                                                                
public class Main {                                                                                                                            
	public static void main(String[] args) {                                                                                                    
		Scanner sc = new Scanner(System.in);                                                                                                    
		int N = sc.nextInt();                                                                                                                   
		                                                                                                                                        
		int cnt = 0;                                                                                                                            
		                                                                                                                                        
		cnt += N / 3;                                                                                                                           
		N = N % 3;                                                                                                                              
		                                                                                                                                        
		cnt += N / 1;                                                                                                                           
		                                                                                                                                        
		if(cnt % 2 == 0) {	//짝수면 창영                                                                                                            
			System.out.println("CY");                                                                                                           
		}else {		// 홀수면 상근                                                                                                                   
			System.out.println("SK");                                                                                                           
		}                                                                                                                                       
	}                                                                                                                                           
}
