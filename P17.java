public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<A.size();i++) map.put(A.get(i), i);
        
        for(int i=0;i<A.size();i++){
            if(map.containsKey(A.get(i)+B) && map.get(A.get(i)+B) != i) return 1;
        }
        return 0;
    }
}
