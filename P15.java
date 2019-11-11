public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        Set<Integer> set = new HashSet(A);
        int ans = 0;
        
        for(int i=0;i<A.size();i++){
            for(int j=i+1;j<A.size();j++){
                if(set.contains(A.get(i) + A.get(j))) ans += 1;
            }
        }
        return ans;
    }
}
