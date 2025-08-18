class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        Set<Integer> resultSet = new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                resultSet.add(nums2[i]);
            }
           
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int nums1[]= new int[n];
        int m=sc.nextInt();
        int nums2[]= new int[m];

        for(int i=0;i<n;i++){
            nums1[i]=sc.nextInt();
        }
        
        for(int i=0;i<m;i++){
            nums2[i]=sc.nextInt();
        }
        
        int[] ans = intersection(nums1, nums2);
        System.out.println(ans);
    }
}