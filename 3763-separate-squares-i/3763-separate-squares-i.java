class Solution {
    public double separateSquares(int[][] squares) {

        double lo = 0, hi = 2*1e9;

        for(int i = 0 ; i<60 ; i++){
            double mid = (hi + lo) / 2.0;

            double diff = calcAreaDiff(squares, mid);

            if(diff > 0){
                lo = mid;
            }else{
                hi  = mid;
            }

        }
        return hi ;
    }

    private double calcAreaDiff(int[][] squares, double line){
        double aboveA = 0;
        double belowA = 0;
        
        for(int[] sq : squares){
            int y = sq[1];
            int l = sq[2];

            double totalArea = (double)l * l;

            if(line <= y){
                aboveA += totalArea;
            }else if(line >= y+l){
                belowA += totalArea;
            }else{
                double aboveLine = (y+l) - line;
                double belowLine = line - y;
                aboveA += aboveLine * l;
                belowA += belowLine * l;
            }
        }

        return aboveA - belowA;
    }

}