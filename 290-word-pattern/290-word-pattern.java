class Solution {
    
    public static boolean pattern(String[] array, String pattern, HashMap<Character, String> map){
        
        if(array.length != pattern.length()){
            return false;
        }
        
        
        for(int i = 0 ; i < array.length ; i++){
            char ch = pattern.charAt(i);
            String rop = pattern.substring(i);
            
            if(map.containsKey(ch)){
                String st = map.get(ch);
                if(!st.equals(array[i])){
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
        String[] array  = s.split(" ");
        return pattern(array, pattern, new HashMap<>());
    }
}