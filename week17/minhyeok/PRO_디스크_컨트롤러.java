import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    
    /** 
        디스크 컨트롤러가 작업이 끝난 시점을 기준으로 요청이 들어온 작업들을 처리한다.
        작업이 끝난 시점 이전에 요청이 들어온 작업들을 모두 우선순위 큐에 넣는다.
            소요 시간이 가장 짧은 작업을 뽑아 작업을 수행한다.
        작업이 끝난 이후 요청이 들어온 작업들에 대한 처리도 수행한다.
        
    **/
    
    class Job {
        int requestTime;
        int duration;
        
        public Job(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }
        
        @Override
        public String toString() {
            return "Job requestTime: "+this.requestTime+" duration: "+duration;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 작업을 요청 시간 순으로, 소요 시간 순으로 정렬
        Arrays.sort(jobs, (o1,o2) -> (o1[0]==o2[0]) ? o1[1]-o2[1] : o1[0]-o2[0]);
        
        int curTime = jobs[0][0];
        int idx = 0;
        PriorityQueue<Job> pq = new PriorityQueue<Job>((o1,o2)->o1.duration - o2.duration);
        while (idx < jobs.length) {
            // 작업이 끝난 시점 이전에 요청된 작업들을 모두 큐에 넣는다.
            while (idx < jobs.length && jobs[idx][0] <= curTime) {
                pq.add(new Job(jobs[idx][0],jobs[idx][1]));
                idx++;
            }
            
            // 작업이 끝난 이후에 요청된 작업을 처리한다
            if (pq.isEmpty()) {
                curTime = jobs[idx][0]; // 작업 시작 시점을 다음 작업이 요청이 들어온 시점으로 맞춰준다.
                continue;
            }
            
            // 작업을 처리한다.
            Job job = pq.poll();
            curTime += job.duration;
            answer += curTime - job.requestTime;
        }
        
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            curTime = Math.max(curTime, job.requestTime);
            curTime += job.duration;
            answer += curTime - job.requestTime;
        }
        
        return answer/jobs.length;
    }
}