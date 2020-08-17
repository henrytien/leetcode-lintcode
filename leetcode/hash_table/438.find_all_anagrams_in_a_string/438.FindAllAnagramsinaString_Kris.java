// Source : https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both strings s and p will not 
 * be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
 * s: "cbaebabacd" p: "abc"
 * 
 * Output:
 * [0, 6]
 * 
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * Example 2:
 * 
 * Input:
 * s: "abab" p: "ab"
 * 
 * Output:
 * [0, 1, 2]
 * 
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 ******************************************************************************************************/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        var result = new ArrayList<Integer>();
        if (s == null || p == null || p.length() == 0 || p.length() > s.length()) {
            return result;
        }
        
        var src = new int[26];
        var target = new int[26];
        for (var i = 0; i < p.length(); i++) {
            src[s.charAt(i) - 'a']++;
            target[p.charAt(i) - 'a']++;
        }
        
        var left = 0;
        var right = p.length() - 1;
        var len = s.length();
        while (true) {
            if (isOk(src, target)) {
                result.add(left);
            }
            
            src[s.charAt(left) - 'a']--;
            left++;
            right++;
            if (right >= len) {
                break;
            }
            src[s.charAt(right) - 'a']++;
        }
        
        return result;
    }
    
    boolean isOk(int[] src, int[] target) {
        for (var i = 0; i < src.length; i++) {
            if (src[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}