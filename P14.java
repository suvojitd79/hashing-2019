public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isValidSudoku(final String[] A) {
        
        int n = A.length;
        int sq = (int) Math.sqrt(n);
        
        Set<String> set = new HashSet();
        
        for(int i=0;i<A.length;i++){
            
            for(int j=0;j<A[i].length();j++){
                
                Character c = A[i].charAt(j);
                
                if(c != '.'){
                    
                String row = "row-"+i+"-data-"+c; 
                String col = "col-"+j+"-data-"+c;
                String grid = "grid-"+(i/sq)+"-"+(j/sq)+ "-data-"+c;
                
                if(!set.add(row) || !set.add(col) || !set.add(grid))
                    return 0;
                    
                }
                
                
            }   
            
            
        }
        return 1;
    }
}
