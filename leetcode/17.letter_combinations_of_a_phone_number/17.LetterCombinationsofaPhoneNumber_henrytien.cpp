// Source : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Author : henrytien
// Date   : 2022-01-05

/***************************************************************************************************** 
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that 
 * the number could represent. Return the answer in any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does 
 * not map to any letters.
 * 
 * Example 1:
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Example 2:
 * 
 * Input: digits = ""
 * Output: []
 * 
 * Example 3:
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * Constraints:
 * 
 * 	0 <= digits.length <= 4
 * 	digits[i] is a digit in the range ['2', '9'].
 ******************************************************************************************************/

class Solution {
public:
   vector<string> letterCombinations(string digits) {
    res.clear();
    if (digits.size() == 0) {
      return res;
    }

    findCombination(digits, 0, "");

    return res;
  }

 private:
  vector<string> res;
     // Recursion
  void findCombination(string& digits, int index, const string& s) {
    if (index == digits.size()) {
      res.push_back(s);
      return;
    }
    
    // Every time process one character.
    char c = digits[index];
    if (c <= '0' || c == '1' || c > '9') {
      return;
    }

    string letters = phone[c -'0'];
    for (int i = 0; i < letters.size(); ++i)
    {
      findCombination(digits, index + 1, s + letters[i]);
    }
  }

  const string phone[10] = {
      " ",     // 0
      "",      // 1
      "abc",   // 2
      "def",   // 3
      "ghi",   // 4
      "jkl",   // 5
      "mno",   // 6
      "pqrs",  // 7
      "tuv",   // 8
      "wxyz"   // 9
  };
};

