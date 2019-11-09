public class Solution {
    
    class Pair{
        int x,y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        
        ArrayList<Integer> ans = new ArrayList();
        
        if(A.size() < 4) return ans;
        
        int x1=-1,x2=-1,x3=-1,x4=-1;
        
        HashMap<Integer,Pair> map = new HashMap<>();
        
        for(int i=0;i<A.size();i++){
            for(int j=i+1;j<A.size();j++){
             
                int sum = A.get(i) + A.get(j);
                
                if(map.containsKey(sum)){
                    
                    Pair p = map.get(sum);
                    
                    if(p.x >= i || p.y == i || p.y == j) continue; 
                    
                    
                    // System.out.println(p.x + " " +p.y + " " +i + " "+j);

                    
                    if(x1 == -1 ||  p.x < x1 || (p.x == x1 && p.y < x2) || (p.x == x1 && p.y == x2 && i < x3) || (p.x == x1 && p.y == x2 && i == x3 && j < x4))
                        {
                            x1 = p.x;
                            x2 = p.y;
                            x3 = i;
                            x4 = j;
                        }
                }else{
                    
                    map.put(sum, new Pair(i,j));
                    
                }
                
            }
            
            
        }
        
        if(x1 != -1){
            
            ans.add(x1);
            ans.add(x2);
            ans.add(x3);
            ans.add(x4);
            
        }        

        return ans;
    }
}
