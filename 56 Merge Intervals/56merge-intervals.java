class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > end){
                List<Integer> list = new ArrayList<>();
                list.add(start);    
                list.add(end);
                ans.add(list);

                start = intervals[i][0];    
                end = intervals[i][1];    
            }
            else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        ans.add(list);

        int[][] res = new int[ans.size()][2];

        for(int i = 0; i < ans.size(); i++){
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }

        return res;
    }
}