class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);

        int sum=0;
        int ans=0;

        for(int j=0;j<nums.length;j++){
            sum+= nums[j];

            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n= sc.nextInt();
        int nums[]= new int[n];

        for(int i=0;i<nums.length;i++){
            nums[i]= sc.nextInt();
        }

        
        int result = new Solution().subarraySum(nums, k);
        System.out.println(result);

        sc.close();
    }
}