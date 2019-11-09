public class Solution {
    public int lengthOfLongestSubstring(String A) {
        
        if(A.length() == 0) return 0; // edge case
        
        int max = 0; 
        
        Map<Character,Integer> map = new HashMap();
        
        for(int left=0,right=0; right<A.length();right++){
        
            if(map.containsKey(A.charAt(right))){
                
                left = Math.max(left, map.get(A.charAt(right)) + 1);    
                
            }
            map.put(A.charAt(right), right);
            max = Math.max(max, right - left + 1);
            
        }
        
        return max;
        
    }
    
    
}
