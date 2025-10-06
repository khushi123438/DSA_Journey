class Solution {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid; 
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
       
        return low;
    }
    

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n= sc.nextInt();
        int nums[]= new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        searchInsert(nums,target);
    }
}