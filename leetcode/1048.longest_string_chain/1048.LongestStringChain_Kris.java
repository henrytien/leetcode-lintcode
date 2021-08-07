// Source : https://leetcode.com/problems/longest-string-chain/
// Author : Kris
// Date   : 2020-08-17

/***************************************************************************************************** 
 *
 * Given a list of words, each word consists of English lowercase letters.
 * 
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in 
 * word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".
 * 
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a 
 * predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 * 
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 * 
 * Example 1:
 * 
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 * 
 * Note:
 * 
 * 	1 <= words.length <= 1000
 * 	1 <= words[i].length <= 16
 * 	words[i] only consists of English lowercase letters.
 * 
 ******************************************************************************************************/

class Solution {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        var dp = new int[words.length];
        Arrays.fill(dp, 1);
        
        var max = 1;
        for (var i = 1; i < words.length; i++) {
            for (var j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
    
    boolean isPredecessor(String src, String dest) {
        if (src.length() + 1 != dest.length()) {
            return false;
        }
        
        var diff = 0;
        var p = 0;
        var q = 0;
        while (p < src.length() && q < dest.length()) {
            if (src.charAt(p) == dest.charAt(q)) {
                p++;
                q++;
            } else if (diff == 0) {
                diff++;
                q++;
            } else {
                return false;
            }
        }
        
        // System.out.println(src + ":" + dest);
        return true;
    }
}