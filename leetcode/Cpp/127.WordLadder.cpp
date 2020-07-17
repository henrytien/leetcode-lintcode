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

// double bfs unordered_set 


class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(),wordList.end());
        if(!dict.count(endWord)){
            return 0;
        }
        unordered_set<string> q1{beginWord};
        unordered_set<string> q2{endWord};
        int len = endWord.length();
        
        int step = 0;
        while (!q1.empty() && !q2.empty()) {
            ++step;
            
            if(q2.size() > q1.size()){
                swap(q2, q1);
            }
            
            unordered_set<string> q;
            for(string word:q1){
                for (int i = 0; i < len; i++) {
                    char ch = word[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[i] = c;
                        if(q2.count(word)){
                            return step + 1;
                        }
                        if(!dict.count(word)){
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

int main(){
    
    string beginWord = "hit";
    string endWord = "cog";
    vector<string> wordList = {"hot","dot","dog","lot","log","cog"};
    Solution s;
    cout <<  s.ladderLength(beginWord, endWord, wordList) << endl;
    cout << "hello" << endl;
    return 0;
}
