class PROG_타겟넘버 {
	static int _target, cnt;
	static int[] _numbers;
    
    public int solution(int[] numbers, int target) {
        _numbers = numbers; // 파라미터로 넘기는 거보다 static이 편함
		_target = target;
		
		dfs(0,0);
		
		return cnt;
	}
	
	static void dfs(int idx, int sum) { // 재귀 DFS
		if(idx == _numbers.length) { // 탐색 완료
			if(sum == _target) cnt++; // 합 검사
			return;
		}
		
		dfs(idx+1, sum + _numbers[idx]); // +로 추가
		dfs(idx+1, sum + (_numbers[idx] * -1)); // -로 추가
	}
}