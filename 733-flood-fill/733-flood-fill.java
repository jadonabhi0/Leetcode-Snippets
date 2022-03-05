class Solution {
    public void fill(int[][] image, int sr, int sc, int newcol, int cur){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[sr].length || image[sr][sc]==newcol || image[sr][sc]!=cur)
            return;
        image[sr][sc] = newcol;
        fill(image,sr+1,sc,newcol,cur);
        fill(image,sr,sc+1,newcol,cur);
        fill(image,sr-1,sc,newcol,cur);
        fill(image,sr,sc-1,newcol,cur);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
}