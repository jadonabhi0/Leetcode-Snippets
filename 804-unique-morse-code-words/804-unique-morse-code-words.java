class Solution {
	public int uniqueMorseRepresentations(String[] words) {
    
    if(words.length == 0)
        return 0;
    if(words.length == 1)
        return 1;
    
    String[] store = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
                      "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--",
                      "--.."};
    HashSet<String> h = new HashSet<>(); //set created for storing unique elements

    for(int i = 0; i < words.length; i++)
    {
        String temp = words[i]; // 
        
        String result = "";
        for(int j = 0; j < temp.length(); j++) //this loop is for traversing each character of the string
        {
            int idx = temp.charAt(j)-'a'; //index for the character
            result += store[idx]; // concatenate the hashcode
        }
        
        if(!h.contains(result)) //storing unique elements
            h.add(result);
        
    }
      
    return h.size(); //size of the hashset will be answer.
}
}