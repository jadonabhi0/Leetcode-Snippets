class Solution {
    
    public static boolean helper(String[] array, Map<Character, String> map, String pattern){
        if(array.length != pattern.length()){
            return false;
        }
        
        for(int i = 0 ; i < array.length ; i++ ){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                String str = map.get(ch);
                if(!str.equals(array[i])){
                    return false;
                }
            }else if(map.containsValue(array[i])){
                return false;
            }
            else{
                map.put(ch, array[i]);
                }
            }
        return true;
        }
        
    public boolean wordPattern(String pattern, String s) {
        
        String[] st = s.split(" ");

        return helper(st, new HashMap<Character, String>(), pattern);
        
        
        
    }
}