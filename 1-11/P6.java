public class Solution {
    
    public int gcd(int x,int y){
        
        if(y==0) return x;
        
        return gcd(y, x % y);
    }
    
    class Point{
        
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode(){
            return this.x ^ this.y;
        }
        
        @Override 
        public boolean equals(Object o){
            if(!(o instanceof Point)) return false;
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }
        
    }
    
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
     
        int global_max = 0;
        
        if(A.size() != B.size() || A.size() == 0 || B.size()==0) return global_max;
     
        Map<Point,Integer> map = new HashMap();
        
        int sameXY,sameX, max; 
        
        for(int i=0;i<A.size();i++){
            
            sameXY = sameX = max = 0;
            
            for(int j= i+1;j<A.size();j++){
                
             if(A.get(i)==A.get(j) && B.get(i)==B.get(j))
                sameXY++;
            else if(A.get(i)==A.get(j))
                sameX++;
            else{
                
                int y = B.get(j) - B.get(i);
                int x = A.get(j) - A.get(i);
                int gcd_val = gcd(x,y);
                y /= gcd_val;
                x /= gcd_val;
                
                Point p = new Point(x,y);
                map.put(p, map.getOrDefault(p, 0) + 1);    
             
               max = Math.max(max, map.get(p));
                
            }    
             
             max = Math.max(max, sameX);
                
            }
            
            global_max = Math.max(global_max, max + sameXY + 1);
            map.clear();
            
        }
        
        
        return global_max;
    }
}
