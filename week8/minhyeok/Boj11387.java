package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Boj11387 { // 님 무기가 좀 나쁘시네여 
	
	static BigDecimal getStat(BigDecimal[] bd) { // 전투력 측정 
		BigDecimal attack = bd[0];
		BigDecimal power = bd[1];
		BigDecimal pcnt1 = bd[2].divide(new BigDecimal("100"));
		BigDecimal pcnt2 = bd[3].divide(new BigDecimal("100"));
		BigDecimal speed = bd[4].divide(new BigDecimal("100"));
		
		return attack.multiply(
				new BigDecimal("1").add( power.divide( new BigDecimal("100") ) ).multiply( new BigDecimal("1").subtract( pcnt1.min(new BigDecimal("1")) ).add( pcnt1.min(new BigDecimal("1") ).multiply( pcnt2 ) ).multiply( speed.add( new BigDecimal("1") ) ) ) 
				); // 쓰다가 자괴감 max 
	}

	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigDecimal[] cri = new BigDecimal[5];
		BigDecimal[] fabu = new BigDecimal[5];
		String[] strCri = br.readLine().split(" ");
		String[] strFabu = br.readLine().split(" ");
		
		for (int i=0; i<5; i++) {
			cri[i] = new BigDecimal(strCri[i]); // 크리 전투력 
			fabu[i] = new BigDecimal(strFabu[i]); // 파부 전투력 
		}
		
		BigDecimal criStat = getStat(cri);
		BigDecimal fabuStat = getStat(fabu);
		
		String[] strWpCri = br.readLine().split(" ");
		String[] strWpFabu = br.readLine().split(" ");
		
		for (int i=0; i<5; i++) {
			cri[i] = cri[i].subtract(new BigDecimal(strWpCri[i])); // 크리 무기 빼주고 
			cri[i] = cri[i].add(new BigDecimal(strWpFabu[i])); // 파부 무기 장착 
			
			fabu[i] = fabu[i].subtract(new BigDecimal(strWpFabu[i])); // 파부 무기 빼주고 
			fabu[i] = fabu[i].add(new BigDecimal(strWpCri[i])); // 크리 무기 장착 
		}
		
		BigDecimal newCriStat = getStat(cri); // 전투력 다시 측정 
		BigDecimal newFabuStat = getStat(fabu);
		
		if (criStat.compareTo(newCriStat) > 0) {
			System.out.println("-");
		} else if (criStat.compareTo(newCriStat) == 0) {
			System.out.println("0");
		} else {
			System.out.println("+");
		}
		
		if (fabuStat.compareTo(newFabuStat) > 0) {
			System.out.println("-");
		} else if (fabuStat.equals(newFabuStat)) {
			System.out.println("0");
		} else {
			System.out.println("+");
		}
		
	}

}
