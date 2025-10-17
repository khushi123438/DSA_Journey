class Solution {
    public static int maxArea(int[] height) {
        int maxWater=0;
        int lp=0;
        int rp=height.length-1;

        while(lp<rp){
            int h = Math.min(height[lp],height[rp]);
            int w = rp-lp;
            int currWater = h*w;
            maxWater = Math.max(maxWater,currWater);

            if(height[lp]<height[rp])
            lp++;
            else
            rp--;
        }
        return maxWater;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int height[]= new int[n];

        for(int i=0;i<height.length;i++){
            height[i]=sc.nextInt();
        }
        maxArea(height);
    }
}