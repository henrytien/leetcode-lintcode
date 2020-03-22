 // https://leetcode.com/problems/word-ladder/
 #include "ac.h"
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(),wordList.end());
        if(dict.count(endWord) == 0) return 0;
        queue<string> q;
        q.push(beginWord);
       
        int len = beginWord.length();
        int level = 0;
        while (!q.empty()) {
            ++level;
            int size = q.size();
            for (int i = size; i > 0; i--) {
                string word = q.front();
                q.pop();
                
                for (int j = 0; j < len; j++) {
                    char ch = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[j] = c;
                        if(word == endWord){
                            return level + 1;
                        }
                        
                        if(!dict.count(word)){
                            continue;
                        }
                        
                        // Remove the word from dict
                        dict.erase(word);
                        
                        // Add new word from dict
                        q.push(word);
                    }
                    word[j] = ch;
                }
            }
        }
        return 0;
        
    }
};

int main(){
    
    string beginWord = "hit";
    string endWord = "cog";
    vector<string> wordList = {"hot","dot","dog","lot","log","cog"};
    Solution s;
    cout <<  s.ladderLength(beginWord, endWord, wordList) << endl;
    cout << "hello" << endl;
    return 0;
}
