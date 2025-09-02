class Solution {
    public static int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int t : time) {
            int r = t % 60;
            int complement = (60 - r) % 60;
            
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        
        return count;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int time[]= new int[n];

        for(int i=0;i<n;i++){
            time[i]=sc.nextInt();
        }

        numPairsDivisibleBy60(time);
    }
}