class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i : nums){
            if(list.isEmpty()){
                list.add(i);
            }
            else if(list.getLast() != i){
                list.add(i);
            }
        }
        Collections.sort(list,Comparator.reverseOrder());
        if(list.size() <= 2){
            return Collections.max(list);
        }
        return list.get(2);
    }
}