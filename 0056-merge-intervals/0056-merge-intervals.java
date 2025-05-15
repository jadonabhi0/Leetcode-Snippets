class Solution {
    public int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
    List<int[]> ans = new ArrayList<>();
    ans.add(intervals[0]);


    for(int[] i : intervals){

        int st = i[0];
        int en = i[1];

        if(ans.getLast()[1] >= st){
            ans.getLast()[0] = Math.min(ans.getLast()[0], st);
            ans.getLast()[1] = Math.max(ans.getLast()[1], en);
        }else{
            ans.add(i);
        }

    }

    int[][] res = new int[ans.size()][2];
    int c = 0;
    for(int[] i : ans){
        res[c++] = i;
    }

    return res;

    }
}