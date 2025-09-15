class Solution {
    public static int majorityElement(int[] nums) {
        // HashMap<Integer,Integer> map= new HashMap<>();

        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        // }

        // Set<Integer> keySet = map.keySet();
        // for(Integer key: keySet){
        //     if(map.get(key)>nums.length/2)
        //     return key;
        // }
        // return -1; 

        int count = 0;
        Integer cand= null;
        for(int num:nums){
            if(count==0){
            count=1;
            cand=num;
            }
            else if(num==cand){
                count++;
            }else{
                count--;
            }

        }
        return cand;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int nums[]= new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        majorityElement(nums);
    }

}