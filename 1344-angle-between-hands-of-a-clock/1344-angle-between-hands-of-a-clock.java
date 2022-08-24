class Solution {
    public double angleClock(int hr,int mn) {
       
        double hrAng = hr * 30 + 0.5 * mn;
        double minAng = 6 * mn;
        
        double total = Math.abs(hrAng - minAng);
        
        if(total <= 180) return total;
        else return 360.0 - total;
        
    }
}