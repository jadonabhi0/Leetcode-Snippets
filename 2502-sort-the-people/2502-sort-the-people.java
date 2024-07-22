 class Solution {

    static class Pair{
        String name;
        int ht;
        Pair(String name, int ht){
            this.name = name;
            this.ht = ht;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        LinkedList<Pair> list = new LinkedList<>();
        for(int i = 0 ; i < names.length ; i++){
            list.add(new Pair(names[i], heights[i]));
        }

        Collections.sort(list, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p2.ht - p1.ht;
            }
        });

        String[] arr = new String[names.length];
        int a = 0;


        for(Pair p : list){
            arr[a++] = p.name;
        }

        return arr;

    }
}