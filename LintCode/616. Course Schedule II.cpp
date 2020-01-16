
// 这一题只要稍微改改就可以了

class Solution {
public:
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    vector<int> findOrder(int numCourses, vector<pair<int, int>> &prerequisites) {
        vector<int> res;
        vector<unordered_multiset<int>> edges(numCourses);
        vector<int> d(numCourses,0);
        
        // 相邻的边的关系存起来
        for (int i = 0; i < prerequisites.size(); i++) {
            edges[prerequisites[i].second].insert(prerequisites[i].first);
            d[prerequisites[i].first] += 1;
        }
        
        std::queue<int> Q;
        for (int i = 0; i < numCourses; i++) {
            if(d[i] == 0){
                Q.push(i);
            }
        }
        
        vector<int> order;
        while(!Q.empty())
        {
            int x = Q.front();
            std::cout << "x: " << x << std::endl;
            Q.pop();
            order.push_back(x);
            for (auto iter = edges[x].begin(); iter != edges[x].end(); ++iter) {
                d[*iter] --;
                if(d[*iter] == 0){
                    Q.push(*iter);
                }
            }
        }
        if(order.size() == numCourses)
        {
            return order;
        }
        
        return res;
        
    }
};