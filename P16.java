public class Solution {
    
    // O(N^2)
    public int solve(ArrayList<Integer> A, int B) {
        
        int[] temp = new int[A.size()+1];
        Arrays.fill(temp, 0);
        
        int max = 0;
        
        for(int i=0;i<A.size();i++)
            temp[i+1] = temp[i] + A.get(i);
        
        for(int i=A.size();i>=1;i--){
            for(int j = 1; j<=i;j++){
                
                if((temp[i]-temp[j-1]) == B){
                    
                    if(max < (i-j+1)){
                        max = i - j + 1;
                        break;
                    }
                    
                }      
                
            }
        }
        
        return max == 0 ? -1 : max;
    }


    //O(N)
    public int solve(ArrayList<Integer> A, int B) {
        
        Map<Integer,Integer> map = new HashMap();
        
        int max = -1;
        
        int sum = 0;
        
        for(int i=0;i<A.size();i++){
            sum += A.get(i);
            if(sum == B) max = i + 1;
            if(!map.containsKey(sum))
                map.put(sum, i);
            if(map.containsKey(sum-B))
                max = Math.max(max, i - map.get(sum-B));
        }
        
        return max;
    }




}
