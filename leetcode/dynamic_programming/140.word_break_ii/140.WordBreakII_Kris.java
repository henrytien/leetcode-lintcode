// Source : https://leetcode.com/problems/word-break-ii/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add 
 * spaces in s to construct a sentence where each word is a valid dictionary word. Return all such 
 * possible sentences.
 * 
 * Note:
 * 
 * 	The same word in the dictionary may be reused multiple times in the segmentation.
 * 	You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 * 
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 
 * Example 2:
 * 
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 * 
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 ******************************************************************************************************/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return new ArrayList<String>();
        }
        
        var dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (var i = 1; i <= s.length(); i++) {
            for (var j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j + 1 - 1, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // 先判断能不能 break
        if (!dp[s.length()]) {
            System.out.println(dp[s.length()]);
            return new ArrayList<String>();
        }
        
        // [0, s.length()]，都存储一个 String list，最后求 s.length() 位置的
        var list = new ArrayList<List<String>>();
        list.add(new ArrayList<String>());
        for (var i = 1; i <= s.length(); i++) {
            var cur = new ArrayList<String>();
            list.add(cur);
            for (var j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    if (j == 0) {
                        cur.add(s.substring(j, i));
                    } else {
                        for (var str : list.get(j)) {
                            cur.add(str + " " + s.substring(j, i));
                        }
                    }
                }
            }
        }
        
        return list.get(s.length());
    }
}