public class Solution {
    public String minWindow(String A, String T) {
        
        Map<Character,Integer> pat = new HashMap();
        Map<Character,Integer> ori = new HashMap();
        
        for(int i=0;i<T.length();i++)
            pat.put(T.charAt(i), pat.getOrDefault(T.charAt(i), 0) + 1);
        
        int index = 0, len = 0, start = -1;
        String ans = "";
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length();i++){
            
            ori.put(A.charAt(i), ori.getOrDefault(A.charAt(i), 0) + 1);

            
            if(pat.getOrDefault(A.charAt(i), 0) != 0 && ori.get(A.charAt(i)) <= pat.getOrDefault(A.charAt(i), 0))
                len++;
            
            if(len == T.length()){
                
                
                while((pat.getOrDefault(A.charAt(index), 0) != 0 && ori.get(A.charAt(index)) > pat.getOrDefault(A.charAt(index), 0)) || pat.getOrDefault(A.charAt(index), 0) == 0) {
                    
                     if((pat.getOrDefault(A.charAt(index), 0) != 0 && ori.get(A.charAt(index)) > pat.getOrDefault(A.charAt(index), 0)))
                                ori.put(A.charAt(index),ori.get(A.charAt(index))-1);
                    index++;        
                    
                }
                
                int win = i - index + 1;
                if(min > win) {
                    
                    min = win;
                    ans = A.substring(index, i+1);
                    start = index;
                }
                
                
            }
            
            
        }
        
        return ans;
    }
}
