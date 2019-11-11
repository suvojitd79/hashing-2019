public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        
        Map<String,List<Integer>> map = new LinkedHashMap();
        for(int i=0;i<A.size();i++){
            
            char[] temp = A.get(i).toCharArray();
            Arrays.sort(temp);
            String x = new String(temp);
            if(map.containsKey(x)){
                map.get(x).add(i+1);
            }else{
                map.put(x, new ArrayList<>(Arrays.asList(i+1)));
            }   
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        
        for(String x: map.keySet()){
            ans.add(new ArrayList<>(map.get(x)));
        }
        return ans;
    }
}
