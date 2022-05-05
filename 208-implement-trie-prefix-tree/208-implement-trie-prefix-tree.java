class Trie {
    
    
      public static class Node{
        char ch ;
        HashMap<Character, Node> children;
        boolean isTreminal ;
        public Node(char ch){
            this.ch = ch;
            this.children = new HashMap<>();
            isTreminal = false;
        }

    }
    
    
    

     private Node root;

    public Trie(){
        this.root = new Node('*');
    }
    
    
 public void insert(String word){
        Node curr = this.root;
        for (int i = 0 ; i <word.length() ; i++){
            char ch = word.charAt(i);
            if(curr.children.containsKey(ch)){
                curr = curr.children.get(ch);
            }else{
                Node node = new Node(ch);
                curr.children.put(ch,node);
                curr = node;
            }
        }
        curr.isTreminal = true;
    }

    public boolean search(String word){
        Node curr = this.root;
        for (int i = 0 ; i <word.length() ; i++){
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)){
                return false;
            }else{
                curr = curr.children.get(ch);
            }
        }
       return curr.isTreminal ;
    }

    public boolean startsWith(String prefix) {
        Node curr = this.root;
        for (int i = 0 ; i < prefix.length() ; i++){
            char ch = prefix.charAt(i);
            if(!curr.children.containsKey(ch)){
                return false;
            }else{
                curr = curr.children.get(ch);
            }
        }
        return true ;
    }}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */