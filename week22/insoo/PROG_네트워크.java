class PROG_네트워크 {
	static int[][] _computers;
	static boolean[] visit;
    
    public int solution(int n, int[][] computers) {
        _computers = computers;
		visit = new boolean[computers.length]; // 방문 기록
		int cnt = 0;
		
		for (int i = 0; i < computers.length; i++) {
			if(!visit[i]) cnt++; // 첫 방문 시 카운트
			dfs(i); // 연결된 컴퓨터 탐색
		}
		
		return cnt;
	}
	
	static void dfs(int i) { // 재귀
		visit[i] = true; // 방문 기록
		for (int j = 0; j < _computers.length; j++) {
			if(i != j && _computers[i][j] == 1) {
				_computers[i][j] = 0; // 인접행렬 연결 삭제
				_computers[j][i] = 0;
				dfs(j);
			}
		}
	}
}