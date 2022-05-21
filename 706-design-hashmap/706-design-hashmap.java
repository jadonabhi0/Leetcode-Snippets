import java.lang.Object.*;
class MyHashMap {

    class HmNode{
        int key;
        int value;
        
        public HmNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    
    
    private LinkedList<HmNode>[] bucket;
    private int size;
    
    private void init(int n){
        this.bucket = new LinkedList[n];
        this.size = 0;
        for(int i = 0 ; i < n ; i++){
            bucket[i] = new LinkedList<>();
        }
    }
    
    
    
    public MyHashMap() {
        init(4);
    }
    
    private void reHash(){
        LinkedList<HmNode>[] oldbucket = bucket;
        init(bucket.length * 2);
        size = 0;
        for(int i = 0 ; i < oldbucket.length ; i++){
            for(HmNode node : oldbucket[i]){
                put(node.key, node.value);
            }
        }
    }
    
    
    public int hashFun(int key){
        int hash = key;
        return  Math.abs(hash) % bucket.length;
    }
    
    public int insideBucketIndex(int key, int bi){
        int di = 0;
        for(HmNode node : bucket[bi]){
            if(node.key == key){
                return di;
            }
            di++;
        }
        return -1;
    }
    
    
    public void put(int key, int value) {
        int bi = hashFun(key);
        int di = insideBucketIndex(key, bi);
        
        if(di != -1){
            HmNode node = bucket[bi].get(di);
            node.value = value;
        }else{
            HmNode node = new HmNode(key, value);
            bucket[bi].add(node);
            size++;
        }
        double lambda = size *1.0 / bucket.length;
        if (lambda >= 2.0){
            reHash();
        }
    }
    
    public int get(int key) {
        int bi = hashFun(key);
        int di = insideBucketIndex(key, bi);
        
        if(di != -1){
            HmNode node = bucket[bi].get(di);
            return node.value;
        }else{
           return -1;
        }
    }
    
    public void remove(int key) {
        int bi = hashFun(key);
        int di = insideBucketIndex(key, bi);
        
        if(di != -1){
            HmNode node = bucket[bi].remove(di);
            size--;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */