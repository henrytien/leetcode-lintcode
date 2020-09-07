// Source : https://leetcode.com/problems/group-anagrams/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * Constraints:
 * 
 * 	1 <= strs.length <= 104
 * 	0 <= strs[i].length <= 100
 * 	strs[i] consists of lower-case English letters.
 ******************************************************************************************************/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (var i = 0; i < strs.length; i++) {
            var chs = strs[i].toCharArray();
            Arrays.sort(chs);
            var key = new String(chs);
            var list = map.getOrDefault(key, new ArrayList<String>());
            list.add(strs[i]);
            map.put(key, list);
        }
        
        return map.values().stream().collect(Collectors.toList());
    }
}