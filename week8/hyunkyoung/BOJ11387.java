package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11387 { // 님 무기가 좀 나쁘시네여
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] info = new int[4][5];
		
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
			info[i][3] = Integer.parseInt(st.nextToken());
			info[i][4] = Integer.parseInt(st.nextToken());
		} // end input
		
		// 크리의 크리 무기 장착시 전투력
		int attack = info[0][0];
		float power = (float)(info[0][1]) / 100;
		float critical = (float)(info[0][2]) / 100;
		float damage = (float)(info[0][3]) / 100;
		float speed = (float)(info[0][4]) / 100;
		float min = critical; if(critical >= 1) min = 1;
		float c_default = attack * (1 + power) * ((1 - min) + min * damage) * (1 + speed);
		
		// 크리가 파부 무기 장착시 전투력
		attack = info[0][0] - info[2][0] + info[3][0];
		power = (float)(info[0][1] - info[2][1] + info[3][1]) / 100;
		critical = (float)(info[0][2] - info[2][2] + info[3][2]) / 100;
		damage = (float)(info[0][3] - info[2][3] + info[3][3]) / 100;
		speed = (float)(info[0][4] - info[2][4] + info[3][4]) / 100;
		min = critical; if(critical >= 1) min = 1;
		float c_change = attack * (1 + power) * ((1 - min) + min * damage) * (1 + speed);
		
		if(c_default < c_change) System.out.println("+");
		else if(c_default > c_change) System.out.println("-");
		else System.out.println(0);
		
		// 파부의 파부 무기 장착시 전투력
		attack = info[1][0];
		power = (float)(info[1][1]) / 100;
		critical = (float)(info[1][2]) / 100;
		damage = (float)(info[1][3]) / 100;
		speed = (float)(info[1][4]) / 100;
		min = critical; if(critical >= 1) min = 1;
		float f_default = attack * (1 + power) * ((1 - min) + min * damage) * (1 + speed);
		
		// 파부가 크리 무기 장착시 전투력
		attack = info[1][0] - info[3][0] + info[2][0];
		power = (float)(info[1][1] - info[3][1] + info[2][1]) / 100;
		critical = (float)(info[1][2] - info[3][2] + info[2][2]) / 100;
		damage = (float)(info[1][3] - info[3][3] + info[2][3]) / 100;
		speed = (float)(info[1][4] - info[3][4] + info[2][4]) / 100;
		min = critical; if(critical >= 1) min = 1;
		float f_change = attack * (1 + power) * ((1 - min) + min * damage) * (1 + speed);
		
		if(f_default < f_change) System.out.println("+");
		else if(f_default > f_change) System.out.println("-");
		else System.out.println(0);
	}
}
