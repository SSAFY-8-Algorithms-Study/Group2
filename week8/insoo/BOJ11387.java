package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;
/*
 * BOJ 11387 Silver 3
 * 님 무기가 좀 나쁘시네여
 */
public class BOJ_11387_님무기가좀나쁘시네여 {
	static class Info {
		int power, str;
		double cri, damage, attackSpeed;
		Info(int power, int str, double cri, double damage, double attackSpeed) {
			this.power = power; // 공격력
			this.str = str; // 힘
			this.cri = cri; // 치명타 확률
			this.damage = damage; // 치명타 피해비율
			this.attackSpeed = attackSpeed; // 공격속도 증가
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Info Kri = null;
		Info Paboo = null;
		Info weaponKri = null;
		Info weaponPaboo = null;
		Info[] list = {Kri, Paboo, weaponKri, weaponPaboo};
		double[] listBattle = new double[4]; // 전투력
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int power = Integer.parseInt(st.nextToken());
			int str = Integer.parseInt(st.nextToken());
			int cri = Integer.parseInt(st.nextToken());
			int damage = Integer.parseInt(st.nextToken());
			int attackSpeed = Integer.parseInt(st.nextToken());
			
			list[i] = new Info(power, str, (double)cri/100, (double)damage/100, (double)attackSpeed/100);
		}
		
		for (int i = 0; i < 2; i++) { // 기본 전투력 구하기
			listBattle[i] = getBattle(list[i]);
		}
		
		for (int i = 2; i < 4; i++) { // 변화된 전투력 구하기
			Info info = list[i-2];
			Info weaponInfo = list[i];
			Info weaponTheotherInfo = i == 2 ? list[3] : list[2];
			
			int newPower = info.power - weaponInfo.power + weaponTheotherInfo.power;
			int newStr = info.str - weaponInfo.str + weaponTheotherInfo.str;
			BigDecimal aCri = BigDecimal.valueOf(info.cri);
			BigDecimal bCri = BigDecimal.valueOf(weaponInfo.cri);
			BigDecimal cCri = BigDecimal.valueOf(weaponTheotherInfo.cri);
			double newCri = aCri.subtract(bCri).add(cCri).doubleValue();
			BigDecimal aDamage = BigDecimal.valueOf(info.damage);
			BigDecimal bDamage = BigDecimal.valueOf(weaponInfo.damage);
			BigDecimal cDamage = BigDecimal.valueOf(weaponTheotherInfo.damage);
			double newDamage = aDamage.subtract(bDamage).add(cDamage).doubleValue();
			BigDecimal aAttackSpeed = BigDecimal.valueOf(info.attackSpeed);
			BigDecimal bAttackSpeed = BigDecimal.valueOf(weaponInfo.attackSpeed);
			BigDecimal cAttackSpeed = BigDecimal.valueOf(weaponTheotherInfo.attackSpeed);
			double newAttackSpeed = aAttackSpeed.subtract(bAttackSpeed).add(cAttackSpeed).doubleValue();
			
			Info newInfo = new Info(newPower, newStr, newCri, newDamage, newAttackSpeed);
			listBattle[i] = getBattle(newInfo);
		}
		System.out.println(listBattle[0] == listBattle[2] ? '0' : listBattle[2] > listBattle[0] ? '+' : '-');
		System.out.print(listBattle[1] == listBattle[3] ? '0' : listBattle[3] > listBattle[1] ? '+' : '-');
	}
	
	/** 전투력 구하는 공식 */
	static double getBattle(Info info) {
		BigDecimal power = BigDecimal.valueOf(info.power);
		
		BigDecimal str = BigDecimal.valueOf(info.str);
		BigDecimal hundred = BigDecimal.valueOf(100);
		BigDecimal strong = str.divide(hundred).add(BigDecimal.ONE);
		
		BigDecimal cri = BigDecimal.valueOf(Math.min(info.cri, 1));
		BigDecimal damage = BigDecimal.valueOf(info.damage);
		BigDecimal critical = BigDecimal.ONE.subtract(cri);
		BigDecimal criDamage = cri.multiply(damage);
		BigDecimal realDamage = critical.add(criDamage);
		
		BigDecimal attackSpeed = BigDecimal.valueOf(info.attackSpeed).add(BigDecimal.ONE);
		
		return power.multiply(strong).multiply(realDamage).multiply(attackSpeed).doubleValue();
	}
}