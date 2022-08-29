import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * BOJ 16235 Gold 3
 * 나무재테크
 * 1. 입력 시 우선순위 큐를 사용해 자동 정렬하고
 * 2. 재테크 수행 큐에는 어레이덱 <뒤에 삽입하는 add>와 <앞에 삽입하는 push>를 사용
 */
public class BOJ_16235_나무재테크 {
	static int N;
	static int[] dir = {-1, 0, 1};
	static int[][] nutriMap, mapS2D2;
	static ArrayDeque<Tree>[][] treeList;
	
	static class Tree {
		int x, y, age;
		Tree(int age) {
			this.age = age;
		}
		Tree(int x, int y, int age) {
			this.x = x; // x좌표
			this.y = y; // y좌표
			this.age = age; // 나이
		}
	}
	
	static void treeManagement() {
		ArrayDeque<Tree> temp = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!treeList[i][j].isEmpty()) {
					ArrayDeque<Tree> trees = treeList[i][j];

					int size = trees.size(); // 칸당 나무 수
					
					int deadTreeNutri = 0; // 죽은 나무 양분
					
					for (int k = 0; k < size ; k++) { // 여러 나무 수행
						Tree tree = trees.poll();
						
						int age = tree.age;
						if(nutriMap[i][j] >= age) {
							nutriMap[i][j] -= age++; // 봄
							temp.add(new Tree(i, j, age)); // 뒤에 삽입
							if(age % 5 == 0) {
								for (int dx = 0; dx < 3; dx++) {
									for (int dy = 0; dy < 3; dy++) {
										if(dx == 1 && dy == 1) continue;
										int xx = i + dir[dx];
										int yy = j + dir[dy];
										
										if(xx>=0 && xx<N && yy>=0 && yy<N) { // 가을 준비
											temp.push(new Tree(xx ,yy, 1)); // age가 1이니까 가장 앞에 삽입
										}
									}
								}
							}
						}
						else deadTreeNutri += age / 2; // 여름 준비
					}
					nutriMap[i][j] += deadTreeNutri; // 여름 반영
				}
				nutriMap[i][j] += mapS2D2[i][j]; // 겨울
			}
		}
		for(Tree e : temp) treeList[e.x][e.y].add(new Tree(e.age)); // 가을 반영
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 땅의 크기 N*N
		int M = Integer.parseInt(st.nextToken()); // 나무의 수
		int K = Integer.parseInt(st.nextToken()); // K년이 지난 후
		
		nutriMap = new int[N][N]; // 땅 양분 맵
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nutriMap[i][j] = 5; // 처음 양분의 양 5
			}
		}
		
		mapS2D2 = new int[N][N]; // S2D2 로봇이 추가하는 양분 맵
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				mapS2D2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		treeList = new ArrayDeque[N][N]; // 트리 목록 어레이덱
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				treeList[i][j] = new ArrayDeque<>();
			}
		}

		PriorityQueue<Tree> temp = new PriorityQueue<>((a,b) -> a.age - b.age); // 우선 순위 큐 사용
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) -1; // 나무 x 좌표
			int y = Integer.parseInt(st.nextToken()) -1; // 나무 y 좌표
			int age = Integer.parseInt(st.nextToken()); // 나무 나이
			
			temp.add(new Tree(x, y, age));
		}
		for(Tree e : temp) treeList[e.x][e.y].add(new Tree(e.age)); // 정렬 후 저장
		
		for (int i = 0; i < K; i++) {
			treeManagement(); // 수행 메서드 호출
		}
		int cnt = 0;
		for(ArrayDeque[] e : treeList) for(ArrayDeque el : e) cnt += el.size();
		System.out.print(cnt);
	}
}