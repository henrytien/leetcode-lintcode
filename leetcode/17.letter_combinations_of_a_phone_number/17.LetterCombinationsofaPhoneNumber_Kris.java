// Source : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that 
 * the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does 
 * not map to any letters.
 * 
 * Example:
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 ******************************************************************************************************/

class Solution {
    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        this.phone = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        
        helper(digits, 0, new StringBuilder(), result);
        
        return result;
    }
    
    Map<Character, String> phone;
    
    void helper(String digits, int index, StringBuilder one, List<String> result) {
        if (index == digits.length()) {
            result.add(one.toString());
            return;
        }
        
        var cur = phone.get(digits.charAt(index)).toString().toCharArray();
        for (var ch : cur) {
            one.append(ch);
            helper(digits, index + 1, one, result);
            one.deleteCharAt(one.length() - 1);
        }
    }
}