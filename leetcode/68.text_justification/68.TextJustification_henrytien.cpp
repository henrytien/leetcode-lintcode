// Source : https://leetcode.com/problems/text-justification/
// Author : henrytien
// Date   : 2022-01-13

/*****************************************************************************************************
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has
 * exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each
 * line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on
 * a line does not divide evenly between words, the empty slots on the left will be assigned more
 * spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified and no extra space is inserted between words.
 *
 * Note:
 *
 * 	A word is defined as a character sequence consisting of non-space characters only.
 * 	Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * 	The input array words contains at least one word.
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last
 * line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 *
 * Example 3:
 *
 * Input: words =
 * ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","
 * is","everything","else","we","do"], maxWidth = 20
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
 * Constraints:
 *
 * 	1 <= words.length <= 300
 * 	1 <= words[i].length <= 20
 * 	words[i] consists of only English letters and symbols.
 * 	1 <= maxWidth <= 100
 * 	words[i].length <= maxWidth
 ******************************************************************************************************/

#include "../inc/ac.h"

/// Simulation
/// Time Complexity: O(n)
/// Space Complexity: O(n)
/// From : liuyubobobo
class Solution
{
public:
    vector<string> fullJustify(vector<string> &words, int maxWidth)
    {
        vector<string> res;
        int index = 0;
        while (index < words.size())
        {

            vector<string> linev = {words[index++]};
            int cur = linev[0].size();
            while (index < words.size() && cur + 1 + words[index].size() <= maxWidth)
            {
                linev.push_back(words[index]),
                    cur += (1 + words[index].size()),
                    index++;
            }

            string line = "";
            if (index < words.size())
            {
                int left = maxWidth - cur, space = linev.size() - 1;

                line = linev[0];
                for (int i = 1; i < linev.size(); i++)
                    line += string(1 + left / space + (i - 1 < left % space), ' '),
                        line += linev[i];

                line += string(maxWidth - line.size(), ' ');
            }
            else
            {
                line = linev[0];
                for (int i = 1; i < linev.size(); i++)
                    line += " " + linev[i];
                line += string(maxWidth - line.size(), ' ');
            }

            res.push_back(line);
        }
        return res;
    }
};

void print_text(const vector<string> &text)
{
    for (const string &line : text)
        cout << line << endl;
}

int main()
{
    vector<string> words1 = {"This", "is", "an", "example", "of", "text", "justification."};
    print_text(Solution().fullJustify(words1, 16));
    return 0;
}
