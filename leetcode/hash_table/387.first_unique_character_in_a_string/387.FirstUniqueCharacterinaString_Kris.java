// Source : https://leetcode.com/problems/first-unique-character-in-a-string/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't 
 * exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode"
 * return 2.
 * 
 * Note: You may assume the string contains only lowercase English letters.
 ******************************************************************************************************/

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        var map = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++) {
            var count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }
        
        for (var i = 0; i < s.length(); i++) {
            var count = map.get(s.charAt(i));
            if (count == 1) {
                return i;
            }
        }
        
        return -1;
    }
}