class Solution {
    public void duplicateZeros(int[] arr) {
        int zero=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0)
            zero++;
        }
        int lastIdx=n-1;
        int newIdx=n-1+zero;

        while(lastIdx>=0){
            if(newIdx<n)
            arr[newIdx]=arr[lastIdx];

            if(arr[lastIdx]==0){
            newIdx--;
                   if(newIdx<n)
                   arr[newIdx]=0;
            }

            lastIdx--;
            newIdx--;

        }


    }
}