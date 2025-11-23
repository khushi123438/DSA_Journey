class Solution {
    public int maxSumDivThree(int[] nums) {
          int sum = 0;
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();
        
        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) rem1.add(num);
            else if (num % 3 == 2) rem2.add(num);
        }
        
        Collections.sort(rem1);
        Collections.sort(rem2);
        
        int mod = sum % 3;
        if (mod == 0) return sum;
        else if (mod == 1) {
            int option1 = rem1.size() >= 1 ? sum - rem1.get(0) : 0;
            int option2 = rem2.size() >= 2 ? sum - rem2.get(0) - rem2.get(1) : 0;
            return Math.max(option1, option2);
        } else { 
            int option1 = rem2.size() >= 1 ? sum - rem2.get(0) : 0;
            int option2 = rem1.size() >= 2 ? sum - rem1.get(0) - rem1.get(1) : 0;
          
            return Math.max(option1, option2);}
    }
}