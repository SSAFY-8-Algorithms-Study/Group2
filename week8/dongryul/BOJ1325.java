import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1325 {
   static ArrayList<Integer>[] adjList;
   static int N;
   static int M;
   static boolean[] visited;
   static int[] hackStreak;
   static StringBuilder sb;
   static int maxStreak = -1;

   public static void hack(int n) {
      Queue<Integer> q = new LinkedList<>();
      
      q.add(n);
      visited[n]=true;
      
      while(!q.isEmpty()) {
         int tempN = q.poll();
         for(int s: adjList[tempN]) {
            if(visited[s]) continue;
            visited[s] =true;
            q.add(s);
            hackStreak[s]++;
         }
      }
   }
   
   public static void simul() {
      for (int i = 1; i <= N; i++) {
         visited = new boolean[N + 1];
         hack(i);
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      sb = new StringBuilder();
      N = sc.nextInt();
      M = sc.nextInt();
      adjList = new ArrayList[N + 1];
      hackStreak = new int[N + 1];
      for (int i = 0; i <= N; i++) {
         adjList[i] = new ArrayList<Integer>();
      }
      for (int i = 0; i < M; i++) {
         adjList[sc.nextInt()].add(sc.nextInt());
      } // end input
      
      simul();
      
      
      for (int i = 1; i <= N; i++) {
         if (maxStreak < hackStreak[i]) {
            maxStreak = hackStreak[i];
         }
      }
      for (int i = 1; i <= N; i++) {
         if(maxStreak== hackStreak[i])
            sb.append(i+" ");
      }
      
      System.out.println(sb);
   }

}
