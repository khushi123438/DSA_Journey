class Solution {
    public int findJudge(int n, int[][] trust) {
        for(int person =1;person<=n;person++){
            int px=0, xp=0;

            for(int t[]:trust){
                if(t[0]==person) px++;

                else if(t[1]==person) xp++;
            }
            if(px==0 && xp==n-1) return person;

        }
        return -1;
    }
}