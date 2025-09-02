class Solution {
    public static int findDuplicate(int[] nums) {
       boolean[] seen = new boolean[nums.length]; 
        for (int num : nums) {
            if (seen[num]) {
                return num; 
            }
            seen[num] = true;
        }
        return -1;

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int nums[]= new int[n+1];

        for(int i=1;i<n+1;i++){
            nums[i]=sc.nextInt();
        }

        findDuplicate(nums);
    }
}
