// https://www.lintcode.com/problem/word-ladder-ii/description?_from=ladder&&fromId=1

class Solution {
public:
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    vector<vector<string>> findLadders(string &start, string &end, unordered_set<string> &dict) {
        unordered_map<string,vector<string>> marked;
        unordered_map<string,int> distance;
        vector<vector<string>> result;
        vector<string> path;
        path.emplace_back(start);
        dict.insert(start);
        dict.insert(end);
        bfs(start,end,dict,distance,marked);
        dfs(result,path,start,end,distance,marked);
        return result;
    }
    
private:
    vector<string> findNeighbors(const string &word, unordered_set<string> &dict){
        vector<string> neighbors;
        for (int i = 0; i < word.length(); i++) {
            for(char c = 'a'; c <= 'z'; ++c){
                string new_word = word;
                new_word[i] = c;
                if(dict.find(new_word) == dict.end() || word[i] == c) continue;
                neighbors.push_back(new_word);
            }
        }
        return neighbors;
    }


    void bfs(string &start,
             string &end,
             unordered_set<string> &dict,
             unordered_map<string,int> &distance,
             unordered_map<string,vector<string>> &marked
             ){
        std::queue<string> q;
        q.push(start);
        distance[start] = 0;
        while(!q.empty()){
            int length = q.size();
            for (int i = 0; i < length; i++) {
                string word = q.front(); q.pop();
                if(word == end) break;
                vector<string> neighbors = findNeighbors(word,dict);
                if(marked.find(word) == marked.end()) marked[word] = neighbors;
                for (auto& neighbor : neighbors) {
                    if(distance.find(neighbor) != distance.end()) continue;
                    distance[neighbor] = distance[word] + 1;
                    q.push(neighbor);
                }
            }
        }
    }

    void dfs(vector<vector<string>> &result,
             vector<string> &path,
             string &start, 
             string &end, 
             unordered_map<string,int> &distance,
             unordered_map<string,vector<string>> &marked){
        if(start == end){
            result.push_back(path);
            return;
        }
        
        for (auto neighbor : marked[start]) {
            if(distance[neighbor] != distance[start] + 1) continue;
            path.push_back(neighbor);
            dfs(result,path,neighbor,end,distance,marked);
            path.pop_back();
        }
    }
};