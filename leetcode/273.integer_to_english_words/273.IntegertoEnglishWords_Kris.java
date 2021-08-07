// Source : https://leetcode.com/problems/integer-to-english-words/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be 
 * less than 231 - 1.
 * 
 * Example 1:
 * 
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * 
 * Example 2:
 * 
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * 
 * Example 3:
 * 
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * Example 4:
 * 
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight 
 * Hundred Ninety One"
 * 
 ******************************************************************************************************/

class Solution {
    static final String[] UNITS = new String[] { "", "Thousand", "Million", "Billion" };
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        var sb = new StringBuilder();
        var splitedNum = split(num);
        for (var i = 0; i < splitedNum.size(); i++) {
            var tmp = new StringBuilder();
            if (splitedNum.get(i) != 0) {
                tmp.append(" ");
                tmp.append(subLessThan1k(splitedNum.get(i)));
                tmp.append(" ").append(UNITS[i]);
            }
            sb.insert(0, tmp.toString());
        }
        
        return sb.toString().trim();
    }
    
    String subLessThan1k(int sub) {
        var sb = new StringBuilder();
        if (sub >= 100) {
            sb.append(getSubUnit(sub / 100)).append(" ").append("Hundred");
            sub %= 100;
        }
        
        if (sub >= 20) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            
            sb.append(getSubUnit(sub / 10 * 10));
            sub = sub % 10;
        }
        
        if (sub > 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            
            sb.append(getSubUnit(sub));
        }
        
        return sb.toString();
    }
    
    String getSubUnit(int i) {
        switch (i) {
            case 90:
                return "Ninety";
            case 80:
                return "Eighty";
            case 70:
                return "Seventy";
            case 60:
                return "Sixty";
            case 50:
                return "Fifty";
            case 40:
                return "Forty";
            case 30:
                return "Thirty";
            case 20:
                return "Twenty";
            case 19:
                return "Nineteen";
            case 18:
                return "Eighteen";
            case 17:
                return "Seventeen";
            case 16:
                return "Sixteen";
            case 15:
                return "Fifteen";
            case 14:
                return "Fourteen";
            case 13:
                return "Thirteen";
            case 12:
                return "Twelve";
            case 11:
                return "Eleven";
            case 10:
                return "Ten";
            case 9:
                return "Nine";
            case 8:
                return "Eight";
            case 7:
                return "Seven";
            case 6:
                return "Six";
            case 5:
                return "Five";
            case 4:
                return "Four";
            case 3:
                return "Three";
            case 2:
                return "Two";
            case 1:
                return "One";
        }
        
        return "";
    }
    
    List<Integer> split(int num) {
        var result = new ArrayList<Integer>();
        while (num != 0) {
            result.add(num % 1000);
            num /= 1000;
        }
        return result;
    }
}