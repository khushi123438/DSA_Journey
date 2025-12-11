class Solution {
    static final long MOD = 1_000_000_007;

    long[] fact, invFact;

    long modPow(long a, long b){
        long r = 1;
        while(b > 0){
            if((b & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return r;
    }

    void buildFactorial(int n){
        fact = new long[n+1];
        invFact = new long[n+1];
        fact[0] = 1;
        for(int i=1;i<=n;i++)
            fact[i] = (fact[i-1]*i)%MOD;

        invFact[n] = modPow(fact[n], MOD-2);
        for(int i=n-1;i>=0;i--)
            invFact[i] = (invFact[i+1]*(i+1))%MOD;
    }

    long nCr(int n, int r){
        if(r<0 || r>n) return 0;
        return (((fact[n]*invFact[r])%MOD)*invFact[n-r])%MOD;
    }

    
    long[] dfs(int u, List<Integer>[] tree){
        long ways = 1;
        int totalSize = 1;

        for(int v : tree[u]){
            long[] child = dfs(v, tree);
            int sz = (int)child[0];
            long w = child[1];

            ways = (ways * w) % MOD;

            ways = (ways * nCr(totalSize + sz - 1, sz)) % MOD;

            totalSize += sz;
        }

        return new long[]{ totalSize, ways };
    }


    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        buildFactorial(n);

        int[] parent = new int[n];
        parent[0] = -1;

        for(int i = 1; i < n; i++){
            int p = -1;
            for(int j = 0; j < i; j++){
                if(complexity[j] < complexity[i]) {
                    p = j;
                    break;
                }
            }
            if(p == -1) return 0;
            parent[i] = p;
        }

        List<Integer>[] tree = new ArrayList[n];
        for(int i=0;i<n;i++) tree[i] = new ArrayList<>();

        for(int i=1;i<n;i++)
            tree[parent[i]].add(i);

        long[] res = dfs(0, tree);
        return (int)res[1];
    }
}
