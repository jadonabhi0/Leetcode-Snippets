class Solution {
    public int[] intersect(int[] num1, int[] num2) {
//         LinkedList<Integer> list = new LinkedList<>();
//         if(num1.length == 0) return num1;
//         for(int i = 0 ; i < num1.length ; i++){
//             for(int j = 0 ; j < num2.length ; j++){
//                 if(num1[i] == num2[j]){
//                     list.add(num1[i]);
//                     num2[j] = Integer.MAX_VALUE;
//                     num1[i] = Integer.MAX_VALUE;
//                     break;
//                 }
//             }
//         }
//         int[] array = new int[list.size()];
//         int c = 0 ;
//         for(int i : list){
//             array[c++] = i;
//         }
        
//         return array;
        
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : num1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i : num2){
            if(map.containsKey(i) && map.get(i) > 0){
                list.add(i);
                map.put(i,map.get(i)-1);
            }
        }
         int[] array = new int[list.size()];
         int c = 0 ;         
        for(int i : list){
             array[c++] = i;
         }
       
        return array;
        
    }
}