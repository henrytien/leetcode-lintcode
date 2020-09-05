// Source : https://leetcode.com/problems/minimum-window-substring/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters 
 * in T in complexity O(n).
 * 
 * Example:
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * Note:
 * 
 * 	If there is no such window in S that covers all characters in T, return the empty string "".
 * 	If there is such window, you are guaranteed that there will always be only one unique 
 * minimum window in S.
 * 
 ******************************************************************************************************/

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.equals("") || s.length() < t.length()) {
            return "";
        }
        
        var src = s.toCharArray();
        var target = t.toCharArray();
        var map_target = new HashMap<Character, Integer>();
        var map_window = new HashMap<Character, Integer>();
        for (var c : target) {
            map_target.put(c, map_target.getOrDefault(c, 0) + 1);
        }
        var required = map_target.size();
        
        int[] result = { 0, Integer.MAX_VALUE };
        var left = 0;
        var right = 0;
        var cur = 0;
        while (left < src.length) {
            if (cur == required) {
                if (right - left < result[1] - result[0]) {
                    result[0] = left;
                    result[1] = right;
                }
                
                if (map_target.containsKey(src[left])) {
                    var value = map_window.get(src[left]) - 1;
                    map_window.put(src[left], value);
                    cur = value < map_target.get(src[left]) ? cur - 1 : cur;
                }
                
                left++;
            } else {
                if (right >= src.length) {
                    break;
                }
                
                if (map_target.containsKey(src[right])) {
                    var value = map_window.getOrDefault(src[right], 0) + 1;
                    map_window.put(src[right], value);
                    cur = value == map_target.get(src[right]) ? cur + 1 : cur;
                }
                
                right++;
            }
        }
        
        return result[1] != Integer.MAX_VALUE ? s.substring(result[0], result[1]) : "";
    }
    
    
    
    public String minWindow_2(String s, String t) {
        if (s == null || t == null || t.equals("") || s.length() < t.length()) {
            return "";
        }
        
        var src = s.toCharArray();
        var target = t.toCharArray();
        var map_t = new char[128];
        var map_result = new char[128];
        for (var c : target) {
            map_t[c]++;
        }
        
        var result = new int[] { 0, Integer.MAX_VALUE };
        var left = 0;
        var right = 0;
        while (left < src.length) {
            if (isOk(map_result, map_t)) {
                if (right - left < result[1] - result[0]) {
                    result[0] = left;
                    result[1] = right;
                }
                map_result[src[left]]--;
                left++;
            } else {
                if (right >= src.length) {
                    break;
                }
                map_result[src[right]]++;
                right++;
            }
        }
        
        return result[1] != Integer.MAX_VALUE ? s.substring(result[0], result[1]) : "";
    }
    
    boolean isOk(char[] result, char[] target) {
        for (var i = 0; i < target.length; i++) {
            if (result[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}