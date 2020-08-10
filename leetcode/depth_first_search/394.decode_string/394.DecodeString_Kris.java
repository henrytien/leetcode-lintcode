// Source : https://leetcode.com/problems/decode-string/
// Author : Kris
// Date   : 2020-08-10

/***************************************************************************************************** 
 *
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
 * being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces, square brackets are 
 * well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any digits and that digits are 
 * only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * 
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 ******************************************************************************************************/

class Solution {
    public String decodeString(String s) {
        var result = new StringBuilder();
        
        var chs = s.toCharArray();
        var stack = new Stack<Character>();
        var mode = Mode.Read;
        var repeatStr = "";
        var times = "";
        var i = 0;
        while (i < chs.length) {
            if (mode == Mode.Read) {
                if (chs[i] != ']') {
                    stack.push(chs[i]);
                    i++; // ] 会在处理完成后被跳过
                } else {
                    mode = Mode.PopStr;
                }
            } else if (mode == Mode.PopStr) {
                var ch = stack.pop();
                if (ch != '[') {
                    repeatStr += ch;
                } else {
                    repeatStr = (new StringBuilder(repeatStr)).reverse().toString();
                    mode = Mode.PopNum;
                }
            } else if (mode == Mode.PopNum) {
                if (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    times = stack.pop() + times;
                } else {
                    for (var j = 0; j < Integer.valueOf(times); j++) {
                        for (var repeatChar : repeatStr.toCharArray()) {
                            stack.push(repeatChar);
                        }
                    }
                    times = "";
                    repeatStr = "";
                    mode = Mode.Read;
                    i++; // 处理完成后，需要跳过 ]
                }
            }
        }
        
        for (var ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

}

enum Mode {
    Read,
    PopStr,
    PopNum
}