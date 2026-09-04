class Solution {
    public void generate(List<List<String>> li,List<String> l,boolean[] cols,boolean diag1[],boolean diag2[],int n,int r,char[] s)
    {
        if(r==n)
        {
            li.add(new ArrayList<>(l));
            return;
        }

        Arrays.fill(s,'.');
        
        for(int c=0;c<n;c++)
        {
            if(!cols[c] && !diag1[r-c+(n-1)] && !diag2[r+c])
            {
                cols[c]=true;
                diag1[r-c+(n-1)]=true;
                diag2[r+c]=true;
                s[c]='Q';
                l.add(new String(s));
                generate(li,l,cols,diag1,diag2,n,r+1,s);
                cols[c]=false;
                diag1[r-c+(n-1)]=false;
                diag2[r+c]=false;
                s[c]='.';
                l.remove(l.size()-1);
            }
        }
        
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> li=new ArrayList<>();
        List<String> l=new ArrayList<>();
        char s[]=new char[n];
        boolean col[]=new boolean[n];
        boolean diag1[]=new boolean[n*2-1];
        boolean diag2[]=new boolean[n*2-1];
        generate(li,l,col,diag1,diag2,n,0,s);
        return li;
    }
}