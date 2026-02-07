class Solution {
    public int minimumDeletions(String s) {
        int bSeen = 0;
        int del=0;
        
        for(int i=0;i<s.length();i++){
           char ch= s.charAt(i);

           if(ch=='b'){
           
            bSeen++;
           }else{
            if(bSeen>0){
              del++;
              bSeen--;
            }
           }
        }
        return del;
    }
}