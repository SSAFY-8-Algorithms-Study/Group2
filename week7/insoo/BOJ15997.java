import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * BOJ 15997 Gold 3
 * 승부 예측
 */
public class BOJ_15997_승부예측 {
	static class Game {
		String a, b;
		double[] l;
		Game(String a, String b, double[] l) {
			this.a = a;
			this.b = b;
			this.l = l; // 확률 배열
		}
	}
	
	static String[] countries;
	static Game[] games;
	static double[] percentages;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		countries = br.readLine().split(" ");
		percentages = new double[4];
		games = new Game[6];
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			double W = Double.parseDouble(st.nextToken()); // A가 승리할 확률
			double D = Double.parseDouble(st.nextToken()); // 비길 확률
			double L = Double.parseDouble(st.nextToken()); // 질 확률
			double[] WDL = {W, D, L};
			games[i] = new Game(A, B, WDL);
		}
		
		int[] scores = new int[4];
		btr(0, 0, scores, 1);
		for(double e : percentages) System.out.printf("%.10f%n", e);
	}
	
	static void btr(int x, int y, int[] scores, double prePer) {
		Game game = games[x];
		double per = game.l[y]; // x, y좌표에 맞는 확률
		
		if(y != 2) btr(x, y+1, scores.clone(), prePer); // 각 경우의 수
		if(per == 0) return;
		
		// double형 연산을 위해 BigDecimal 사용
		BigDecimal bigPer = new BigDecimal(String.valueOf(per));
		BigDecimal bigPrePer = new BigDecimal(String.valueOf(prePer));
		per = bigPer.multiply(bigPrePer).doubleValue();
		
		int idxA = Arrays.asList(countries).indexOf(game.a);
		int idxB = Arrays.asList(countries).indexOf(game.b);
		
		switch (y) {
		case 0:
			scores[idxA] += 3;
			break;
		case 1:
			scores[idxA] += 1;
			scores[idxB] += 1;
			break;
		case 2:
			scores[idxB] += 3;
			break;
		}
		
		if(x != 5) btr(x+1, 0, scores, per); // scores를 다음 경기로 전달
		else {
			int matchSize = highScoreTeam(scores, per, true); // 첫 번째 진출 팀
			if(matchSize == 1) highScoreTeam(scores, per, false); // 두 번째 진출 팀
		}
	}
	
	static int highScoreTeam(int[] scores, double per, boolean isHighest) { // 높은 스코어 팀의 확률 저장
		int max = Arrays.stream(scores).max().getAsInt(); // 가장 높은 스코어
		
		ArrayList<Integer> maxMatchList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			if(scores[i] == max) maxMatchList.add(i);
		}
		
		BigDecimal bigPer = new BigDecimal(String.valueOf(per));
		BigDecimal matchSize = new BigDecimal(String.valueOf(maxMatchList.size()));
		BigDecimal divided = bigPer.divide(matchSize, 10, 3);
		if(isHighest && maxMatchList.size() > 1) { // 가장 높은 스코어를 가진 팀이 2팀 이상일 때
			BigDecimal b = new BigDecimal(String.valueOf(2));
			divided = divided.multiply(b);
		}
		
		for (int i = 0; i < maxMatchList.size(); i++) {
			int idxMatch = maxMatchList.get(i);
			BigDecimal v = new BigDecimal(String.valueOf(percentages[idxMatch]));
			percentages[idxMatch] = v.add(divided).doubleValue(); // 경우의 수마다  확률 누적 저장
			scores[idxMatch] = 0; // 두 번째 높은 팀을 구할 때 방해되지 않도록 0 표시
		}
		return matchSize.intValue();
	}
}