class Solution {
    public int bestClosingTime(String customers) {
        int profit = 0;
        int maxProfit = 0;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);

            if (c == 'Y') {
                profit++;
            } else {
                profit--;
            }

            if (profit > maxProfit) {
                maxProfit = profit;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}
