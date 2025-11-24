class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        

        int odd=0;
        int count=0;
        for(int num:nums){
            if(num%2!=0)
            odd++;

            int need = odd - k;

            if (map.containsKey(need)) {
                count += map.get(need);
            }

            map.put(odd, map.getOrDefault(odd, 0) + 1);
        }

        return count;
    }
}