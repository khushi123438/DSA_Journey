class Solution {
    public static int maxSubArray(int[] num) {
        int n=num.length;
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        for(int i=0;i<n;i++){
            currSum+=num[i];
            if(currSum>maxSum){
                maxSum=currSum;
            }
            if(currSum<0)
            currSum=0;
        }
        return maxSum;
    }

    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int num[] = new int[n];
        for (int i = 0; i < n; i++) {
           num[i] = sc.nextInt(); 
        }

        int result = maxSubArray(num);    
        System.out.println(result);    
    }
    
}