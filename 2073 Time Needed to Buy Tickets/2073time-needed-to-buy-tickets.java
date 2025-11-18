class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            q.add(new int[]{i, tickets[i]});
        }

        int time = 0;

          while (!q.isEmpty()) {
            int[] front = q.remove();

            front[1]--;  
            time++;

            if (front[0] == k && front[1] == 0) {
                return time;
            }

             if (front[1] > 0) 
                q.add(front);
            
          }

          return time;
    }
}