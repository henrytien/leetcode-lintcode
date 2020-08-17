// Source : https://leetcode.com/problems/group-anagrams/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 * Note:
 * 
 * 	All inputs will be in lowercase.
 * 	The order of your output does not matter.
 * 
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