class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list=new ArrayList<>();
        for(int[] arr:buildings)
        {
            int st=arr[0];
            int end=arr[1];
            int ht=arr[2];
            list.add(new Pair(st,-ht));
            list.add(new Pair(end,ht));
        }

        Collections.sort(list);
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);  // adding current height that is in 0
        int currHt=0;
        for(int i=0;i<list.size();i++)
        { 
            int x=list.get(i).x;
            int ht=list.get(i).ht;
            
            if(ht<0)
            {
                maxHeap.add(-ht); // building started
            }
            else
            {
                // building end
                maxHeap.remove(ht);
            }

            if(currHt!=maxHeap.peek())
            {
                List<Integer> temp=new ArrayList<>();
                temp.add(x);
                temp.add(maxHeap.peek());
                ans.add(temp);

                currHt=maxHeap.peek();
            }
        }

        return ans;
    }
}

class Pair implements Comparable<Pair>
{
    int x,ht;
    Pair(int x,int ht)
    {
        this.x=x;
        this.ht=ht;
    }

    public int compareTo(Pair a)
    {
        if(a.x!=this.x)
        {
            return this.x-a.x;
        }
        else
        {
            return this.ht-a.ht;
        }
    }
}