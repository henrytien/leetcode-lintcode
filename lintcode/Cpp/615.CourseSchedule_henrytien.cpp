//https://www.lintcode.com/problem/course-schedule/description?_from=ladder&&fromId=1
class Solution
{
public:
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    bool canFinish(int numCourses, vector<pair<int, int>> &prerequisites)
    {
        if (prerequisites.size() == 0)
        {
            return true;
        }

        vector<unordered_multiset<int>> edges(numCourses);
        vector<int> d(numCourses, 0);
        for (int i = 0; i < prerequisites.size(); i++)
        {
            edges[prerequisites[i].second].insert(prerequisites[i].first);
            d[prerequisites[i].first]++; // 统计该点的度
            //std::cout << prerequisites[i].second  << prerequisites[i].first << std::endl;
        }

        std::queue<int> q;
        for (int i = 0; i < numCourses; i++)
        {
            if (d[i] == 0)
            {
                q.push(i);
            }
        }

        //bfs
        int node = 0;
        while (!q.empty())
        {
            int x = q.front();
            q.pop();
            node++;
            for (auto iter = edges[x].begin(); iter != edges[x].end(); ++iter)
            {
                --d[*iter];
                if (d[*iter] == 0)
                {
                    std::cout << *iter << std::endl;
                    q.push(*iter);
                }
            }
        }
        return node == numCourses;
    }
};

// Leetcode 
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if(prerequisites.size() == 0){
            return true;
        }
       
        vector<unordered_multiset<int>> edges(numCourses);
        vector<int> d(numCourses,0);
        for(int i = 0; i < prerequisites.size(); ++i){
            edges[prerequisites[i][1]].insert(prerequisites[i][0]);
            cout<< prerequisites[i][1] << " "<< prerequisites[i][0] << endl;
            d[prerequisites[i][0]] ++;
        }
        
        std::queue<int> q;
        for(int i = 0; i < numCourses; ++i){
            if(d[i] == 0){
                q.push(i);
            }
        }
        int node = 0;
        while(!q.empty()){
            int x = q.front(); 
            q.pop();
            node++;
            for(auto iter = edges[x].begin(); iter != edges[x].end(); ++iter){
                cout << d[*iter] << endl;
                -- d[*iter];
                if(d[*iter] == 0){
                    q.push(*iter);
                }
            }
        }
        return node == numCourses;
    }
};


// Leetcode python
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        n = len(prerequisites)
        if n == 0:
            return True
        
        # 统计顶点的入度
        in_degree = [0 for _ in range(numCourses)]
        # 邻接表存一下顶点的相领信息
        adj = [set() for _ in range(numCourses)]
        
        queue = collections.deque()
        
        # [0,1] 表示先修课程1，课程0
        for second,first in prerequisites:
			# 存入一条后继信息
            adj[first].add(second)
            in_degree[second] += 1
            
        
        # 入度为0的先用队列存起来
        for i in range(numCourses):
            if in_degree[i] == 0:
                queue.append(i)
        count = 0  
        #bfs
        while queue:
            node = queue.popleft()
            print(node)
            count += 1
            # 遍历入度为0的后继结点，减1为0放入队列
            for succssor in adj[node]:
                in_degree[succssor] -= 1
                if in_degree[succssor] == 0:
                    queue.append(succssor)
            
        return count == numCourses
