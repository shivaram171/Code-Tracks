
class Solution {
    public boolean isPalindrome(int x) {
        String k = String.valueOf(x);
      
        for(int i=0;i<k.length()/2;i++)
        {
            if(k.charAt(i) != k.charAt(k.length()-1-i))
            {
                return false;
            }
        }
        return true;
    }
}
        
    
