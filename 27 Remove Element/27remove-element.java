class Solution {
    public static int removeElement(int[] nums, int val) {
        int k = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; 
                k++;
            }
        }
        return k; 
       
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int val=sc.nextInt();
        int n=sc.nextInt();
        int nums[]= new int[n];

        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        removeElement(nums,val);
    }
}