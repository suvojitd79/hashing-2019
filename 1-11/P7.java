public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer,Integer> x = new HashMap();
        Map<Integer,Integer> y = new HashMap();
        
        for(int i=0;i<A.size();i++){
            
            x.put(A.get(i), x.getOrDefault(A.get(i), 0) +1 );
            y.put(B.get(i), y.getOrDefault(B.get(i), 0) +1 );
        }
        
        int ans = 0;
        
        for(int i=0;i<A.size();i++){
            ans += ((x.get(A.get(i))-1) * (y.get(B.get(i))-1)) % 1000000007;
        }
        
        return ans %  1000000007;
    }
}
