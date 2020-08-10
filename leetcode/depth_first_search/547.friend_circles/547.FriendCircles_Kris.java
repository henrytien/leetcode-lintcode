// Source : https://leetcode.com/problems/friend-circles/
// Author : Kris
// Date   : 2020-08-10

/***************************************************************************************************** 
 *
 * 
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is 
 * transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, 
 * then A is an indirect friend of C. And we defined a friend circle is a group of students who are 
 * direct or indirect friends.
 * 
 * Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] 
 * = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have 
 * to output the total number of friend circles among all the students.
 * 
 * Example 1:
 * 
 * Input: 
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. The 2nd 
 * student himself is in a friend circle. So return 2.
 * 
 * Example 2:
 * 
 * Input: 
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct 
 * friends, so the 0th and 2nd students are indirect friends. All of them are in the same friend 
 * circle, so return 1.
 * 
 * Note:
 * 
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 * 
 ******************************************************************************************************/

class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        var unionFind = new UnionFind(M.length);
        for (var i = 0; i < M.length; i++) {
            for (var j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        
        return unionFind.count;
    }
    
    public int findCircleNum_2(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        var count = 0;
        var visit = new boolean[M.length];
        for (var i = 0; i < M.length; i++) {
            if (!visit[i]) {
                bfs(M, visit, i);
                count++;
            }
        }
        
        return count;
    }
    
    void dfs(int[][] M, boolean[] visit, int i) {
        visit[i] = true;
        
        for (var j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && !visit[j]) {
                dfs(M, visit, j);
            }
        }
    }
    
    void bfs(int[][] M, boolean[] visit, int i) {
        var queue = new LinkedList<Integer>();
        queue.offer(i);
        visit[i] = true;
        
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var k = 0; k < size; k++) {
                var row = queue.poll();
                for (var j = 0; j < M[row].length; j++) {
                    if (M[row][j] == 1 && !visit[j]) {
                        queue.offer(j);
                        visit[j] = true;
                    }
                }
            }
        }
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    public int count;
    
    public UnionFind(int size) {
        this.parent = new int[size];
        this.size = new int[size];
        this.count = size;
        
        for (var i = 0; i < size; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    
    int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        
        return i;
    }
    
    void union(int i, int j) {
        var rootI = find(i);
        var rootJ = find(j);
        
        if (rootI == rootJ) {
            return;
        }
    
        if (size[rootI] <= size[rootJ]) {
            parent[rootI] = parent[rootJ];
            size[rootJ] += size[rootI];
        } else {
            parent[rootJ] = parent[rootI];
            size[rootI] += size[rootJ];
        }
        
        count--;
    }
}