// Source : https://leetcode.com/problems/verifying-an-alien-dictionary/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a 
 * different order. The order of the alphabet is some permutation of lowercase letters.
 * 
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true 
 * if and only if the given words are sorted lexicographicaly in this alien language.
 * 
 * Example 1:
 * 
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * 
 * Example 2:
 * 
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence 
 * is unsorted.
 * 
 * Example 3:
 * 
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) 
 * According to lexicographical rules "apple" > "app", because 'l' > '&empty;', where '&empty;' is 
 * defined as the blank character which is less than any other character (More info).
 * 
 * Constraints:
 * 
 * 	1 <= words.length <= 100
 * 	1 <= words[i].length <= 20
 * 	order.length == 26
 * 	All characters in words[i] and order are English lowercase letters.
 ******************************************************************************************************/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length <= 1) {
            return true;
        }
        
        var map = new int[26];
        for (var i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        
        for (var i = 0; i < words.length; i++) {
            for (var j = i + 1; j < words.length; j++) {
                if (compare(map, words[i], words[j]) > 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    int compare(int[] map, String s1, String s2) {
        var i = 0;
        var len1 = s1.length();
        var len2 = s2.length();
        while (i < len1 && i < len2) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                return map[s1.charAt(i) - 'a'] - map[s2.charAt(i) - 'a'];
            }
        }
        
        // 前i个全部相等，此时 length 长的更大
        return len1 - len2;
    }
}