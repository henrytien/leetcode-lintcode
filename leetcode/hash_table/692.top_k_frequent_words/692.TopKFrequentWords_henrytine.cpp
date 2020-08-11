// Source : https://leetcode.com/problems/top-k-frequent-words/solution/
// Author : henrytine
// Date   : 2020-08-11

/***************************************************************************************************** 
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same 
 * frequency, then the word with the lower alphabetical order comes first.
 * 
 * Example 1:
 * 
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2:
 * 
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * Note:
 * 
 * You may assume k is always valid, 1 &le; k &le; number of unique elements.
 * Input words contain only lowercase letters.
 * 
 * Follow up:
 * 
 * Try to solve it in O(n log k) time and O(n) extra space.
 * 
 ******************************************************************************************************/

class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string,int> hash_map;
        
        for (auto w : words) {
            hash_map[w] ++;
        }
        priority_queue<pair<string,int>,vector<pair<string,int>>, Comp> pq;
        for (auto e:hash_map) {
            pq.push(e);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        vector<string> res;
        while (!pq.empty()) {
            res.insert(res.begin(),pq.top().first);
            pq.pop();
        }
        
        return res;
    } 
private:
    struct Comp{
        bool  operator() (const pair<string,int>& a, const pair<string,int>& b) {
           return a.second > b.second || (a.second == b.second && a.first < b.first);
        }
    };
};