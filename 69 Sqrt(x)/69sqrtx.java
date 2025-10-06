class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1)
        return x;

        int l=1,h=x, ans=0;

        while(l<=h){
            int mid = l+(h-l)/2;
            if(mid<=x/mid){
                ans=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }

        }
        return ans;
    }
}