class Solution {
     public static int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int a =  0;
        int toprow = 0;
        int downrow = n-1;
        int firstcol = 0;
        int lastcol = n-1;
       while(a!=n*n){

           // to print the first row up to n-1 columns
           for(int i = firstcol ;i < lastcol ; i++){
               if (a == n*n) return array;
               array[toprow][i] = ++a;
           }

           // to print the last com from first row to last row
           for(int i = toprow ; i <= downrow ; i++){
               if (a == n*n) return array;
               array[i][lastcol] = ++a;
           }

           // to print the last row up to n-1 columns
           for(int i = lastcol-1 ; i > firstcol ;i--){
               if (a == n*n) return array;
               array[downrow][i] = ++a;
           }

           // to print the first column from last roq to first row
           for(int i = downrow ; i > toprow ;i--){
               if (a == n*n) return array;
               array[i][firstcol] = ++a;
           }
           toprow++;
           lastcol--;
           firstcol++;
           downrow--;
       }
       return array;
    }
}