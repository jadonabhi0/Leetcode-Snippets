class Solution {
    public int minLength(String s) {
    int n = s.length();
    if(n<2)
    return n;

    char arr[] = s.toCharArray();
    int write = 0, read=0;
    while(read<s.length())
    {
       arr[write] = s.charAt(read);
       if(write>0 && (arr[write-1]=='A' || arr[write-1]=='C') && (arr[write]-'A') == (arr[write-1]-'A'+1))
       {
         write = write-1; 
       }
       else
           write++;
       read++;     
    } 
    return write;
        
    }
}