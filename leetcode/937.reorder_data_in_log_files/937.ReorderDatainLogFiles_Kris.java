// Source : https://leetcode.com/problems/reorder-data-in-log-files/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * You have an array of logs.  Each log is a space delimited string of words.
 * 
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * 
 * 	Each word after the identifier will consist only of lowercase letters, or;
 * 	Each word after the identifier will consist only of digits.
 * 
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each 
 * log has at least one word after its identifier.
 * 
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are 
 * ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The 
 * digit-logs should be put in their original order.
 * 
 * Return the final order of the logs.
 * 
 * Example 1:
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 
 * Constraints:
 * 
 * 	0 <= logs.length <= 100
 * 	3 <= logs[i].length <= 100
 * 	logs[i] is guaranteed to have an identifier, and a word after the identifier.
 ******************************************************************************************************/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            var x = a.substring(a.indexOf(' ') + 1);
            var y = b.substring(b.indexOf(' ') + 1);
            
            if ((x.charAt(0) < 'a' || x.charAt(0) > 'z')
                && (y.charAt(0) < 'a' || y.charAt(0) > 'z')) {
                return 0;
            } else if (x.charAt(0) < 'a' || x.charAt(0) > 'z') {
                return 1;
            } else if (y.charAt(0) < 'a' || y.charAt(0) > 'z') {
                return -1;
            } else {
                var result = x.compareTo(y);
                return result != 0 ? result : a.compareTo(b);
            }
        });
        
        return logs;
    }
}