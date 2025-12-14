class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        
        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }
        
      
        if (totalSeats == 0 || totalSeats % 2 == 1) return 0;
        
        long ways = 1;
        int seatCount = 0;
        int plantCount = 0;
        
        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;
                
            
                if (seatCount == 3) {
              
                    ways = (ways * (plantCount + 1)) % MOD;
                    plantCount = 0;
                    seatCount = 1;
                }
            } else if (seatCount == 2) {
                plantCount++;
            }
        }
        
        return (int) ways;
    }
}
