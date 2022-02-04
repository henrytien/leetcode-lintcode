// Source : https://leetcode.com/problems/word-ladder/
// Author : henrytine
// Date   : 2020-07-30

/***************************************************************************************************** 
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
 * transformation sequence from beginWord to endWord, such that:
 * 
 * 	Only one letter can be changed at a time.
 * 	Each transformed word must exist in the word list.
 * 
 * Note:
 * 
 * 	Return 0 if there is no such transformation sequence.
 * 	All words have the same length.
 * 	All words contain only lowercase alphabetic characters.
 * 	You may assume no duplicates in the word list.
 * 	You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * Example 1:
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Example 2:
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 ******************************************************************************************************/
#include "../inc/ac.h"
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(),wordList.end());
        if (!dict.count(endWord)) {
            return 0;
        }
        unordered_set<string> q1{beginWord};
        unordered_set<string> q2{endWord};
        int len = endWord.length();
        
        int step = 0;
        while (!q1.empty() && !q2.empty()) {
            ++step;
            
            if(q2.size() > q1.size()) {
                swap(q2, q1);
            }
            
            unordered_set<string> q;
            for(string word:q1) {
                for (int i = 0; i < len; i++) {
                    char ch = word[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[i] = c;
                        if (q2.count(word)) {
                            return step + 1;
                        } 
                        if(!dict.count(word)) {
                            continue;
                        }
                        
                        dict.erase(word);
                        q.insert(word);
                    }
                    word[i] = ch;
                }
            }
            swap(q1, q); 
        }
        
        return 0;
    }
};

int main() {
    string beinWord ="hit",endWord = "cog";
    vector<string> wordList = {"hot","dot","dog","lot","log","cog"};
    cout << Solution().ladderLength(beinWord,endWord,wordList) <<"\n";
}