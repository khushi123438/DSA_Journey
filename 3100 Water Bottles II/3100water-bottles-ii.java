class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles;
        int empty = 0;
        int total = 0;
        int exchange = numExchange;

        while (full > 0 || empty >= exchange) {
            // Drink all full bottles
            total += full;
            empty += full;
            full = 0;

            // Exchange if possible
            if (empty >= exchange) {
                full = 1;           // get one full bottle
                empty -= exchange;  // spend empty bottles
                exchange++;         // increase exchange requirement
            } else {
                break; // cannot exchange
            }
        }

        return total;
    }
}
