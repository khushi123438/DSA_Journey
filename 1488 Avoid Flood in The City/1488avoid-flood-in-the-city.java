class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1); 
        
        Map<Integer, Integer> lakeToLastRain = new HashMap<>();
        TreeSet<Integer> zeroDays = new TreeSet<>();
        
        for(int i = 0; i < n; i++) {
            int lake = rains[i];
            if(lake == 0) {
                zeroDays.add(i); 
            } else {
                if(lakeToLastRain.containsKey(lake)) {
                    int lastRainDay = lakeToLastRain.get(lake);
                    Integer dryDay = zeroDays.higher(lastRainDay);
                    if(dryDay == null) {
                        return new int[0]; 
                    }
                    ans[dryDay] = lake; 
                    zeroDays.remove(dryDay); 
                }
                lakeToLastRain.put(lake, i);
                ans[i] = -1; 
            }
        }
        
        return ans;
    }
}