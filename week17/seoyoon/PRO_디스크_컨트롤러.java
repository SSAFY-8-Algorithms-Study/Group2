package week17.seoyoon;

import java.util.PriorityQueue;

public class PRO_디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int sum = 0;
        int curTaskTakeTime = 0, curTaskEndTime = 0;

        PriorityQueue<TaskSJF> pqSJF = new PriorityQueue<TaskSJF>();
        PriorityQueue<TaskFIFO> pqFIFO = new PriorityQueue<TaskFIFO>();

        for (int i = 0; i < jobs.length; i++) {
            pqSJF.add(new TaskSJF(jobs[i][0], jobs[i][1]));
            pqFIFO.add(new TaskFIFO(jobs[i][0], jobs[i][1]));
        }

        Task curTask = null;
        while (!pqFIFO.isEmpty() && !pqSJF.isEmpty()) {

            if (pqFIFO.peek().requestTime >= curTaskEndTime) {  // 처리중인 작업이 없다면
                curTask = pqFIFO.poll();       // 먼저 요청이 들어온 작업부터 처리

                while (!pqFIFO.isEmpty() && pqFIFO.peek().requestTime == curTask.requestTime && pqFIFO.peek().takeTime < curTask.takeTime) {    // 요청이 동시에 들어왔다면 -> SJF
                    Task newCurTask = pqFIFO.poll();
                    pqFIFO.add(new TaskFIFO(curTask.requestTime, curTask.takeTime));
                    curTask = newCurTask;
                }

                curTaskTakeTime = curTask.takeTime;    // 해당 작업 요청 ~ 종료까지 걸린 시간
                curTaskEndTime = curTask.requestTime + curTask.takeTime;     // 해당 작업 끝난 시간

                pqSJF.remove(curTask); // pqSJF에서 같은 작업 제거
            }
            else {  // 처리중인 작업이 있다면
                PriorityQueue<TaskSJF> tempPqSJF = new PriorityQueue<TaskSJF>();

                curTask = pqSJF.poll();       // 가장 빨리 끝나는 작업을 뽑아 바로 이어서 시작
                while(!pqSJF.isEmpty()) {
                    if (curTask.requestTime <= curTaskEndTime) {    // 단, 가장 빨리 끝나는 작업이 curTaskEndTime 보다 먼저 요청 들어와야 함
                        break;
                    }
                    tempPqSJF.add(new TaskSJF(curTask.requestTime, curTask.takeTime));      // curTaskEndTime 보다 먼저 요청되지 않았다면 tempPQ에 잠시 저장
                    curTask = pqSJF.poll();
                }
                pqSJF.addAll(tempPqSJF);    // tempPQ 다시 옮겨담기

                curTaskTakeTime = (curTaskEndTime - curTask.requestTime) + curTask.takeTime;    // 해당 작업 요청 ~ 대기 ~ 종료까지 걸린 시간
                curTaskEndTime = curTaskEndTime + curTask.takeTime;

                pqFIFO.remove(curTask); // pqFIFO에서 같은 작업 제거
            }

            sum += curTaskTakeTime;
        }

        return sum / jobs.length;
    }

    public class Task {
        int requestTime, takeTime;

        public Task(int requestTime, int takeTime) {
            this.requestTime = requestTime;
            this.takeTime = takeTime;
        }

        @Override
        public boolean equals (Object o) {       // pq.remove() 메소드 사용을 위한 equals
            if(o instanceof Task) {
                Task t = (Task) o;
                return requestTime == t.requestTime && takeTime == t.takeTime;
            }
            return false;
        }
    }

    public class TaskSJF extends Task implements Comparable<TaskSJF> {
        public TaskSJF(int requestTime, int takeTime) {
            super(requestTime, takeTime);
        }

        @Override
        public int compareTo(TaskSJF o) {
            return this.takeTime - o.takeTime;
        }
    }

    public class TaskFIFO extends Task implements Comparable<TaskFIFO> {
        public TaskFIFO(int requestTime, int takeTime) {
            super(requestTime, takeTime);
        }

        @Override
        public int compareTo(TaskFIFO o) {
            return this.requestTime - o.requestTime;
        }
    }
}
