// Source : https://leetcode.com/problems/text-justification/
// Author : Kris
// Date   : 2020-09-05

/***************************************************************************************************** 
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly 
 * maxWidth characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each 
 * line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on 
 * a line do not divide evenly between words, the empty slots on the left will be assigned more spaces 
 * than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * Note:
 * 
 * 	A word is defined as a character sequence consisting of non-space characters only.
 * 	Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * 	The input array words contains at least one word.
 * 
 * Example 1:
 * 
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 
 * Example 2:
 * 
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 * 
 * Example 3:
 * 
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * 
 ******************************************************************************************************/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        var result = new ArrayList<String>();
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return result;
        }
        
        // 把单词按行分组
        var groups = new ArrayList<List<String>>();
        var group = new ArrayList<String>();
        var lens = new ArrayList<Integer>();
        var len = 0;
        for (var i = 0; i < words.length; i++) {
            if (group.isEmpty()) {
                group.add(words[i]);
                len = words[i].length();
            } else if (len + 1 + words[i].length() <= maxWidth) {
                group.add(words[i]);
                len += words[i].length() + 1; // 计算单词前面加了个空格之后的长度
            } else {
                groups.add(group);
                lens.add(len);
                group = new ArrayList<String>();
                len = 0;
                i--;
            }
        }
        
        // 最后一个 group 可能未被加入 groups
        // lens 就不用加了，因为最后一行处理方式不同
        if (groups.size() == 0 || !groups.get(groups.size() - 1).equals(group)) {
            groups.add(group);
        }
        
        // 处理除了最后一行以外的
        for (var i = 0; i < groups.size() - 1; i++) {
            var count = groups.get(i).size();
            // 减掉 len 里面本身包含的空格数 count - 1
            var spaces = maxWidth - (lens.get(i) - (count - 1));
            
            var sb = new StringBuilder();
            sb.append(groups.get(i).get(0));
            
            if (count > 1) {
                var average = spaces / (count - 1);
                var leftSpaces = spaces % (count - 1);
                var spacesArr = new int[count - 1];
                Arrays.fill(spacesArr, average);
                for (var j = 0; j < leftSpaces; j++) {
                    spacesArr[j]++;
                }


                for (var j = 0; j < count - 1; j++) {
                    for (var k = 0; k < spacesArr[j]; k++) {
                        sb.append(' ');
                    }
                    if (j + 1 < groups.get(i).size()) {
                        sb.append(groups.get(i).get(j + 1));
                    }
                }
            } else {
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            }
            
            result.add(sb.toString());
        }
        
        // 单独处理最后一行
        var lastRow = groups.get(groups.size() - 1);
        var sb = new StringBuilder();
        sb.append(lastRow.get(0));
        for (var i = 1; i < lastRow.size(); i++) {
            sb.append(' ');
            sb.append(lastRow.get(i));
        }

        while (sb.length() < maxWidth) {
            sb.append(' ');
        }
        result.add(sb.toString());
        
        return result;
    }
}