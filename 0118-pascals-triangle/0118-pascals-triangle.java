class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int row = 0 ; row < numRows ; row++){
            ans.add(generateRow(row));
        }

        return ans;
        
    }


    private List<Integer> generateRow(int row){
        List<Integer> rowAns = new ArrayList<>();

        int ans = 1;
        rowAns.add(ans);

        for(int i = 0 ; i < row ; i++){
            ans = ans * (row - i);
            ans = ans/(i + 1);
            rowAns.add(ans);
        }

        return rowAns;
    }
}