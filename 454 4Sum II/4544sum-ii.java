class Solution {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
       
        HashMap<Integer,Integer> map= new HashMap<>();
        
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

         int count = 0;
        
        
        for (int c : nums3) {
            for (int d : nums4) {
                int sum = c + d;
                count += map.getOrDefault(-sum, 0);
            }
        }
        
        return count;
        
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int nums1[] = new int[n];
         int nums2[] = new int[n];
          int nums3[] = new int[n];
           int nums4[] = new int[n];

        for(int i=0;i<n;i++){
            nums1[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            nums2[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            nums3[i]=sc.nextInt();
        }
    
          for(int i=0;i<n;i++){
            nums4[i]=sc.nextInt();
        }

        fourSumCount(nums1,nums2,nums3,nums4);

    
    }
}