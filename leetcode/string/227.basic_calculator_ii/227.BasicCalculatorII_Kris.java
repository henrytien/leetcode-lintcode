// Source : https://leetcode.com/problems/basic-calculator-ii/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces  . 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * Input: "3+2*2"
 * Output: 7
 * 
 * Example 2:
 * 
 * Input: " 3/2 "
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: " 3+5 / 2 "
 * Output: 5
 * 
 * Note:
 * 
 * 	You may assume that the given expression is always valid.
 * 	Do not use the eval built-in library function.
 * 
 ******************************************************************************************************/

class Solution {
    public int calculate(String s) {
        var stack = new Stack<Integer>();
        
        var ss = s.replace(" ", "").toCharArray();
        var num = 0;
        var sign = '+';
        for (var i = 0; i < ss.length; i++) {
            if (ss[i] >= '0' && ss[i] <= '9') {
                num = num * 10 + (ss[i] - '0');
            }
            
            if (ss[i] < '0' || ss[i] > '9' || i == ss.length - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                
                num = 0;
                sign = ss[i];
            }
        }
        
        var result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return result;
    }
    
    
    
    
    public int calculate_2(String s) {
        var stack = new Stack<String>();
        
        var ss = s.replace(" ", "").toCharArray();
        var i = 0;
        var num = "";
        var mode = Mode.Normal;
        var symbol = ' ';
        while (i < ss.length) {
            if (mode == Mode.Normal) {
                if (ss[i] >= '0' && ss[i] <= '9') {
                    num += String.valueOf(ss[i]);
                    if (++i == ss.length) {
                        stack.push(num);
                    }
                    continue;
                }

                if (num.length() > 0) {
                    stack.push(num);
                    num = "";
                }

                if (ss[i] == '+' || ss[i] == '-') {
                    stack.push(String.valueOf(ss[i]));
                }
                
                if (ss[i] == '*' || ss[i] == '/') {
                    symbol = ss[i];
                    mode = Mode.MultiplicationAndDivision;
                }
                
                i++;
            } else if (mode == Mode.MultiplicationAndDivision) {
                if (ss[i] >= '0' && ss[i] <= '9') {
                    num += String.valueOf(ss[i]);
                    if (++i < ss.length) {
                        continue;
                    }
                }
                
                if (num.length() > 0) {
                    if (symbol == '*') {
                        stack.push("" + Integer.parseInt(stack.pop()) * Integer.parseInt(num));
                    } else {
                        stack.push("" + Integer.parseInt(stack.pop()) / Integer.parseInt(num));
                    }
                    num = "";
                    mode = Mode.Normal;
                } else {
                    i++;
                }
            }
        }
        
        var result = 0;
        num = "0";
        while (!stack.isEmpty()) {
            var val = stack.pop();
            if (val.equals("+")) {
                result += Integer.parseInt(num);
            } else if (val.equals("-")) {
                result -= Integer.parseInt(num);
            } else {
                num = val;
            }
        }
        result += Integer.parseInt(num);
        
        return result;
    }
}

enum Mode {
    Normal,
    MultiplicationAndDivision
}