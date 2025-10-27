class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s.toCharArray(), 0, ans);
        return ans;
    }

    void backtrack(char[] ch, int i, List<String> ans) {
        // base case: if we processed all characters
        if (i == ch.length) {
            ans.add(new String(ch));
            return;
        }

        // if current char is a digit, just move to next
        if (Character.isDigit(ch[i])) {
            backtrack(ch, i + 1, ans);
        } else {
            // lowercase branch
            ch[i] = Character.toLowerCase(ch[i]);
            backtrack(ch, i + 1, ans);

            // uppercase branch
            ch[i] = Character.toUpperCase(ch[i]);
            backtrack(ch, i + 1, ans);
            
        }
    }
}
