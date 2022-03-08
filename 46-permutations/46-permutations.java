class Solution {
//     static List<List<Integer>> result;
//     static LinkedList<Integer> list;
//    public Solution(){
//         this.result = new LinkedList<>();
//          this.list = new LinkedList<>();
//    }
//     static List<List<Integer>> perm(String str,String newStr){
//         if(str.length() == 0){
//                 for(int i = 0 ; i < newStr.length() ; i++){
//                 int a = Integer.parseInt(newStr.charAt(i)+"");
//                 list.add(a);
//             }
           
//             result.add(list);
//             list = new LinkedList<>();
//             return result;
//         }
//         for(int i = 0 ; i < str.length() ; i++){
//             char c = str.charAt(i);
//             String sub = str.substring(0,i)+str.substring(i+1);
//             perm(sub,newStr+c);
//         }
//         return result;
//     }
    
//     public List<List<Integer>> permute(int[] nums) {
//         if (nums.length == 1){
//             list.add(nums[0]);
//             result.add(list);
//             list = new LinkedList<>();
//             return result;
//         } 
//         StringBuilder sb = new StringBuilder();
//         for(int i : nums){
//             sb.append(i);
//         }
//         String str = sb.toString();
//         List<List<Integer>> listt = perm(str,"");
//         return listt;
     // }
    
    
    public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> allList = new ArrayList<>();
		helper(nums, 0, new ArrayList<>(), allList);
		return allList;
	}

	public void helper(int[] nums, int from, List<Integer> cur, List<List<Integer>> allList) {
		if(cur.size() == nums.length) {
			allList.add(new ArrayList<Integer>(cur));
			return;
		}
		for(int i = from; i < nums.length; ++i) {
			swap(nums, from, i);
			cur.add(nums[from]);
			helper(nums, from+1, cur, allList);
			cur.remove(cur.size()-1);
			swap(nums, from, i);
		}
	}
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
    
    
    
    
}