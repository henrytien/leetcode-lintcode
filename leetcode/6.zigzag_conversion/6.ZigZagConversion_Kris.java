// Source : https://leetcode.com/problems/zigzag-conversion/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string s, int numRows);
 * 
 * Example 1:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2:
 * 
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * 
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 ******************************************************************************************************/

class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }
        
        var ss = s.toCharArray();
        var sbs = new StringBuilder[numRows];
        for (var i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        
        var row = 0;
        var down = false;
        for (var i = 0; i < ss.length; i++) {
            sbs[row].append(ss[i]);
            if (row == 0 || row == numRows - 1) {
                down = !down;
            }
            
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        
        var sb = new StringBuilder();
        for (var i = 0; i < numRows; i++) {
            sb.append(sbs[i]);
        }
        
        return sb.toString();
    }
    
    public String convert_2D_Array(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }
        
        var ss = s.toCharArray();
        var cache = new char[numRows][ss.length];
        
        var x = 0;
        var y = 0;
        var down = false;
        for (var i = 0; i < ss.length; i++) {
            cache[x][y] = ss[i];
            if (x == 0 || x == numRows - 1) {
                down = !down;
            }
            
            if (down) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        
        var sb = new StringBuilder();
        for (var i = 0; i < numRows; i++) {
            for (var j = 0; j < ss.length; j++) {
                if (cache[i][j] != (char) 0) {
                    sb.append(cache[i][j]);
                }
            }
        }
        
        return sb.toString();
    }
}